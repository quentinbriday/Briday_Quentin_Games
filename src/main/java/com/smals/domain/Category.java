package com.smals.domain;

import java.io.Serializable;

public class Category implements Serializable {

    private String categoryName;
    private Integer id;

    public Category(String categoryName, Integer id) {
        this.categoryName = categoryName;
        this.id = id;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", id=" + id +
                '}';
    }
}
