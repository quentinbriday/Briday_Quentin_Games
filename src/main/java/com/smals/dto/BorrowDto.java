package com.smals.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowDto {
    private Integer id;
    private GameDto gameDto;
    private BorrowerDto borrowerDto;
    private Date borrowDate;
    private Date returnDate;
}
