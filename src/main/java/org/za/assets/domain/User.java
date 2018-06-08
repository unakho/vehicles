package org.za.assets.domain;

import org.za.assets.domain.base.NameEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author unakho.kama
 */
@Entity
@Table(name = "tuser")
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

    @OneToMany(mappedBy = "user")
    private List<Route> routes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Vehicle vehicle;

    @OneToOne
    private License license;

    public User() {
    }

    public User(Long id, String name, String surname, String idNo, String contactNo,
                String network, int points, String cardNumber, char gender, List<Route> routes,
                Vehicle vehicle, License license) {

        super(id, name);
        this.surname = surname;
        this.idNo = idNo;
        this.contactNo = contactNo;
        this.network = network;
        this.points = points;
        this.cardNumber = cardNumber;
        this.gender = gender;
        this.routes = routes;
        this.vehicle = vehicle;
        this.license = license;
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

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
