package com.smals.dto;

import lombok.Data;

@Data
public class BorrowerDto {
    private Integer id;
    private String borrowerName;
    private String street;
    private String houseNumber;
    private String busNumber;
    private int postcode;
    private String city;
    private String telephone;
    private String email;
}
