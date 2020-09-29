package com.smals.domain;

public class Borrower {

    private Integer id;
    private String borrowerName;
    private String street;
    private String houseNumber;
    private String busNumber;
    private int postcode;
    private String city;
    private String telephone;
    private String email;

    public Borrower(String borrowerName, String city) {
        this.borrowerName = borrowerName;
        this.city = city;
    }

    public Borrower(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerName='" + borrowerName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Borrower(Integer id, String borrowerName, String street, String houseNumber, String busNumber, int postcode, String city, String telephone, String email) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.busNumber = busNumber;
        this.postcode = postcode;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
    }
}
