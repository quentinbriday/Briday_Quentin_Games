package com.smals.services;

import com.smals.domain.Category;
import com.smals.repositories.CategoryJDBCRepository;

public class CategoryService {
    private CategoryJDBCRepository categoryJDBCRepository = CategoryJDBCRepository.getInstance();

    public Category findGameCategoryById(int id){
        return categoryJDBCRepository.getGameCategory(id);
    }
}
