package org.za.assets.domain;

import org.za.assets.domain.base.NameEntity;
import org.za.assets.dto.*;
import org.za.assets.service.utils.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "user")
public class User extends NameEntity {

    @Column(name = "last_name", length = 25)
    private String surname;

    @Column(name = "id_number", length = 20)
    private String idNo;

    @Column(name = "msisdn", length = 20)
    private String contactNo;

    @Column(name = "network", length = 10)
    private String network;

    private int points;

    @Column(name = "card_number", length = 20)
    private String cardNumber;

    private char gender;
    
    @OneToOne
    @JoinColumn(name = "license_id")
    private License license;

    @OneToMany(mappedBy = "user")
    private List<Route> routes;

    @OneToMany(mappedBy = "user")
    private List<Profile> profiles;

    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicles;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public User() {
    }

    public User(UUID id, String name, String surname, String idNo, String contactNo,
                String network, int points, String cardNumber, char gender) {

        super(id, name);
        setSurname(surname);
        setIdNo(idNo);
        setContactNo(contactNo);
        setNetwork(network);
        setPoints(points);
        setCardNumber(cardNumber);
        setGender(gender);
    }

    private User(UUID id, String name, String surname, String idNo, String contactNo,
                String network, int points, String cardNumber, char gender, License license) {
        super(id, name);
        setSurname(surname);
        setIdNo(idNo);
        setContactNo(contactNo);
        setNetwork(network);
        setPoints(points);
        setCardNumber(cardNumber);
        setGender(gender);
        setLicense(license);
    }

    private String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private String getIdNo() {
        return idNo;
    }

    private void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    private String getContactNo() {
        return contactNo;
    }

    private void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    private String getNetwork() {
        return network;
    }

    private void setNetwork(String network) {
        this.network = network;
    }

    private int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    private String getCardNumber() {
        return cardNumber;
    }

    private void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private char getGender() {
        return gender;
    }

    private License getLicense() {
        return license;
    }

    private void setGender(char gender) {
        this.gender = gender;
    }

    private void setLicense(License license) {
        this.license = license;
    }

    private List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    private List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    //lazily fetch vehicles
    public List<VehicleDto> getVehiclesDtos() {
        return getVehicles().stream().map(a -> mapFrom(a)).collect(Collectors.toList());
    }

    //lazily fetch routes
    public List<RouteDto> getRoutesDtos() {
        return getRoutes().stream().map(route ->
                mapFrom(route)).collect(Collectors.toList());
    }

    //lazily fetch profiles
    private List<ProfileDto> getProfilesDtos() {
        return getProfiles().stream().map(a -> mapFrom(a)).collect(Collectors.toList());
    }

    //for each vehicle needed to be used by a driver we gonna call this method
    public Vehicle addVehicle(VehicleDto vehicle) {

        if (vehicle == null)
            throw new RuntimeException("Vehicle dto is null!");

        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();

        return new Vehicle(vehicle.getId(), vehicle.getName(), vehicle.getModel(), vehicle.getType(),
                vehicle.getRegNo(), ldtac.convertToDatabaseColumn(vehicle.getLastServiceDate()),
                ldtac.convertToDatabaseColumn(vehicle.getNextServiceDate()));
    }

    /*
     * @param dto
     * @return route dto
     * This method is used by services that are related with Route entity
     */
    public Route addRoute(RouteDto route){

        if (route == null)
            throw new RuntimeException("Route dto is null!");

        return new Route(route.getId(), route.getStartAddress(),
                route.getEndAddress(), route.getMileage());
    }

    /*
     * @param dto
     * @return profile dto
     * This method is used by services that are related with Profile entity
     */
    public Profile addProfile(ProfileDto profile){

        if (profile == null)
            throw new RuntimeException("Profile dto is null!");

        return new Profile(profile.getId(), profile.getValue());
    }

    /*
     * @param vehicle entity
     * @return vehicle dto
     */
    private VehicleDto mapFrom(Vehicle vehicle) {

        if (vehicle == null)
            throw new RuntimeException("Vehicle entity is null!");

        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();
        return new VehicleDto(vehicle.getId(), vehicle.getName(), vehicle.getModel(),
                vehicle.getType(), vehicle.getRegNo(), ldtac.convertToEntityAttribute(vehicle.getLastServiceDate()),
                ldtac.convertToEntityAttribute(vehicle.getNextServiceDate()));
    }

    /*
     * @param route entity
     * @return route dto
     */
    private RouteDto mapFrom(Route route){

        if (route == null)
            throw new RuntimeException("Route entity is null!");

        return new RouteDto(route.getId(), route.getStartAddress(), route.getEndAddress(),
                route.getMileage());
    }

    /*
     * @param profile entity
     * @return profile dto
     */
    private ProfileDto mapFrom(Profile profile){

        if (profile == null)
            throw new RuntimeException("Profile entity is null!");

        return new ProfileDto(profile.getId(), profile.getValue());
    }

    /*
     * @param user dto
     * @return user entity
     */
    public User mapTo(UserDto dto) {

        if (dto == null)
            throw new RuntimeException("User dto is null!");

        return new User(dto.getId(), dto.getName(), dto.getSurname(), dto.getIdNo(),
                dto.getContactNo(), dto.getNetwork(), dto.getPoints(), dto.getCardNumber(),
                dto.getGender(), this.getLicense().mapTo(dto.getLicense()));
    }

    /*
     * @param user entity
     * @return user dto
     */
    public UserDto mapFrom(User user) {

        if (user == null)
            throw new RuntimeException("User dto is null!");

        return new UserDto(user.getId(), user.getName(), user.getSurname(), user.getIdNo(),
                    user.getContactNo(), user.getNetwork(), user.getPoints(), user.getCardNumber(),
                    user.getGender());
    }
}
