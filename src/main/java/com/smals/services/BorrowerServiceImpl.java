package com.smals.services;

import com.smals.domain.Borrower;
import com.smals.repositories.SPRINGDATA.BorrowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl implements GenericCrudService<Borrower> {

    private BorrowerRepository borrowerRepository;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public void save(Borrower entity) {
        borrowerRepository.save(entity);
    }

    @Override
    public void deleteById(int id) {
        borrowerRepository.deleteById(id);
    }

    @Override
    public Borrower findById(int id) {
        return borrowerRepository.findById(id).get();
    }
}
