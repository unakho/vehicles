package org.za.assets.dto;

import org.za.assets.dto.base.NameDto;

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

    private VehicleDto vehicle;
    private LicenseDto license;

    public UserDto(Long id, String name, String surname, String idNo, String contactNo,
                   String network, int points, String cardNumber, char gender) {

        super(id, name);
        this.surname = surname;
        this.idNo = idNo;
        this.contactNo = contactNo;
        this.network = network;
        this.points = points;
        this.cardNumber = cardNumber;
        this.gender = gender;
    }

    public UserDto(Long id, String name, String surname, String idNo, String contactNo,
                   String network, int points, String cardNumber, char gender, VehicleDto vehicle, LicenseDto license) {

        super(id, name);
        this.surname = surname;
        this.idNo = idNo;
        this.contactNo = contactNo;
        this.network = network;
        this.points = points;
        this.cardNumber = cardNumber;
        this.gender = gender;
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

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public LicenseDto getLicense() {
        return license;
    }

    public void setLicense(LicenseDto license) {
        this.license = license;
    }
}
