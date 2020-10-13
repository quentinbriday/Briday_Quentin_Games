package com.smals.services.jeeservices;

import com.smals.domain.Category;
import com.smals.repositories.JPA.CategoryRepositoryImpl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class CategoryService {
    //    private CategoryJDBCRepository categoryJDBCRepository = CategoryJDBCRepository.getInstance();
    @Inject
    CategoryRepositoryImpl categoryRepositoryImpl;

    public Category findGameCategoryById(int id) {
//        return categoryJDBCRepository.getGameCategory(id);
        return categoryRepositoryImpl.findById(id);
    }
}
