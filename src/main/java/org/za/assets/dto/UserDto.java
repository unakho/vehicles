package org.za.assets.dto;

import org.za.assets.dto.base.NameDto;

import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class UserDto extends NameDto {

    private String surname;
    private String idNo;
    private String contactNo;
    private String network;
    private int points;
    private String cardNumber;
    private char gender;

    private LicenseDto license;
    private List<VehicleDto> vehicles;
    private List<RouteDto> routes;
    private List<ProfileDto> profiles;

    public UserDto(UUID id, String name, String surname, String idNo,
                   String contactNo, String network, int points, String cardNumber,
                   char gender) {
        super(id, name);
        this.surname = surname;
        this.idNo = idNo;
        this.contactNo = contactNo;
        this.network = network;
        this.points = points;
        this.cardNumber = cardNumber;
        this.gender = gender;
    }

    public UserDto(UUID id, String name, String surname, String idNo,
                   String contactNo, String network, int points, String cardNumber,
                   char gender, LicenseDto license, List<VehicleDto> vehicles,
                   List<RouteDto> routes, List<ProfileDto> profiles) {

        super(id, name);
        this.surname = surname;
        this.idNo = idNo;
        this.contactNo = contactNo;
        this.network = network;
        this.points = points;
        this.cardNumber = cardNumber;
        this.gender = gender;
        this.license = license;
        this.vehicles = vehicles;
        this.routes = routes;
        this.profiles = profiles;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LicenseDto getLicense() {
        return license;
    }

    public void setLicense(LicenseDto license) {
        this.license = license;
    }
    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

    public List<RouteDto> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteDto> routes) {
        this.routes = routes;
    }

    public List<ProfileDto> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDto> profiles) {
        this.profiles = profiles;
    }
}
