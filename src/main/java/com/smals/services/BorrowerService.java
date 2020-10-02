package com.smals.services;

import com.smals.domain.Borrower;
import com.smals.repositories.BorrowerJDBCRepository;

public class BorrowerService {
    private BorrowerJDBCRepository borrowerJDBCRepository = BorrowerJDBCRepository.getInstance();

    public Borrower findBorrowerById(int id){
        return borrowerJDBCRepository.getBorrower(id);
    }
}
