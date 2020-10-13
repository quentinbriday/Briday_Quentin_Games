package com.smals.services.jeeservices;

import com.smals.domain.Borrow;
import com.smals.repositories.JPA.BorrowRepositoryImpl;

import javax.inject.Inject;
import java.util.List;

public class BorrowService {
    //    private BorrowJDBCRepository borrowJDBCRepository = BorrowJDBCRepository.getInstance();
    @Inject
    private BorrowRepositoryImpl borrowRepositoryImpl;

    public List<Borrow> findAllBorrow() {
        return borrowRepositoryImpl.findAll();
//        return borrowJDBCRepository.getAllBorrow();
    }
}
