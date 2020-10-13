package com.smals.repositories.SPRINGDATA;

import com.smals.domain.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    public List<Borrow> findAllByBorrower_BorrowerNameContainingOrderByBorrowDate(String borrowerName);
}
