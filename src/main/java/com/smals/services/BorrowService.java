package com.smals.services;

import com.smals.domain.Borrow;
import com.smals.repositories.JDBC.BorrowJDBCRepository;
import com.smals.repositories.JPA.BorrowJPARepository;

import javax.inject.Inject;
import java.util.List;

public class BorrowService {
//    private BorrowJDBCRepository borrowJDBCRepository = BorrowJDBCRepository.getInstance();
    @Inject
    private BorrowJPARepository borrowJPARepository;

    public List<Borrow> findAllBorrow() {
        return borrowJPARepository.findAllBorrow();
//        return borrowJDBCRepository.getAllBorrow();
    }
}
