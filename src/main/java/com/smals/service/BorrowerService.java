package com.smals.service;

import com.smals.domain.Borrow;
import com.smals.domain.Borrower;
import com.smals.domain.Category;
import com.smals.domain.Game;
import com.smals.repositories.BorrowerJDBCRepository;
import com.smals.repositories.GameJDBCRepository;

import java.util.List;

public class BorrowerService {
    private BorrowerJDBCRepository borrowerJDBCRepository = BorrowerJDBCRepository.getInstance();

    public Borrower findBorrowerById(int id){
        return borrowerJDBCRepository.getBorrower(id);
    }
}
