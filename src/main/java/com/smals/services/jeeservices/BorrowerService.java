package com.smals.services.jeeservices;

import com.smals.domain.Borrower;
import com.smals.repositories.JPA.BorrowerRepositoryImpl;

import javax.inject.Inject;

public class BorrowerService {
    //    private BorrowerJDBCRepository borrowerJDBCRepository = BorrowerJDBCRepository.getInstance();
    @Inject
    private BorrowerRepositoryImpl borrowerRepositoryImpl;

    public Borrower findBorrowerById(int id) {
        return borrowerRepositoryImpl.findById(id);
//        return borrowerJDBCRepository.getBorrower(id);
    }
}
