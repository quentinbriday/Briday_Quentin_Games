package com.smals.services;

import com.smals.domain.Borrow;
import com.smals.repositories.SPRINGDATA.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements GenericCrudService<Borrow> {

    private BorrowRepository borrowRepository;

    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    public List<Borrow> findAllByBorrowerName(String borrowerName){
        return borrowRepository.findAllByBorrower_BorrowerNameContainingOrderByBorrowDate(borrowerName);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void save(Borrow entity) {
        borrowRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
        borrowRepository.deleteById(id);
    }

    @Override
    public Borrow findById(int id) {
        return borrowRepository.findById(id).get();
    }
}
