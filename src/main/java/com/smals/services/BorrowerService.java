package com.smals.services;

import com.smals.domain.Borrower;
import com.smals.repositories.JDBC.BorrowerJDBCRepository;
import com.smals.repositories.JPA.BorrowerJPARepository;

import javax.inject.Inject;

public class BorrowerService {
//    private BorrowerJDBCRepository borrowerJDBCRepository = BorrowerJDBCRepository.getInstance();
    @Inject
    private BorrowerJPARepository borrowerJPARepository;
    public Borrower findBorrowerById(int id){
        return borrowerJPARepository.findBorrowerById(id);
//        return borrowerJDBCRepository.getBorrower(id);
    }
}
