package com.smals.service;

import com.smals.domain.Borrow;
import com.smals.domain.Borrower;
import com.smals.domain.Category;
import com.smals.domain.Game;
import com.smals.repositories.BorrowJDBCRepository;
import com.smals.repositories.GameJDBCRepository;

import java.util.List;

public class BorrowService {
    private BorrowJDBCRepository borrowJDBCRepository = BorrowJDBCRepository.getInstance();

    public List<Borrow> findAllBorrow() {
        return borrowJDBCRepository.getAllBorrow();
    }
}
