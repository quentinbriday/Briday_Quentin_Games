package com.smals.service;

import com.smals.domain.Borrow;
import com.smals.domain.Borrower;
import com.smals.domain.Category;
import com.smals.domain.Game;
import com.smals.repositories.CategoryJDBCRepository;
import com.smals.repositories.GameJDBCRepository;

import java.util.List;

public class CategoryService {
    private CategoryJDBCRepository categoryJDBCRepository = CategoryJDBCRepository.getInstance();

    public Category findGameCategoryById(int id){
        return categoryJDBCRepository.getGameCategory(id);
    }
}
