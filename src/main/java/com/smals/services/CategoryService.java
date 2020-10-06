package com.smals.services;

import com.smals.domain.Category;
import com.smals.repositories.JDBC.CategoryJDBCRepository;
import com.smals.repositories.JPA.CategoryJPARepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class CategoryService {
//    private CategoryJDBCRepository categoryJDBCRepository = CategoryJDBCRepository.getInstance();
    @Inject
    CategoryJPARepository categoryJPARepository;

    public Category findGameCategoryById(int id){
//        return categoryJDBCRepository.getGameCategory(id);
        return categoryJPARepository.findCategoryById(id);
    }
}
