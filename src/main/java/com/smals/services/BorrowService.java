package com.smals.services;

import com.smals.domain.Borrow;
import com.smals.repositories.BorrowJDBCRepository;

import java.util.List;

public class BorrowService {
    private BorrowJDBCRepository borrowJDBCRepository = BorrowJDBCRepository.getInstance();

    public List<Borrow> findAllBorrow() {
        return borrowJDBCRepository.getAllBorrow();
    }
}
