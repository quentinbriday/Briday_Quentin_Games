package com.smals.repositories.SPRINGDATA;

import com.smals.domain.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
    public List<Borrower> findAllByBorrowerNameContainingOrderByBorrowerName(String borrowerName);
}
