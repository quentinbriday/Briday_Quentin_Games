package com.smals.repositories.SPRINGDATA;

import com.smals.domain.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Integer> {
}
