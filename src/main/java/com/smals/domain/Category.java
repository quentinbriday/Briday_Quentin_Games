package com.smals.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Category implements Serializable {

    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @Id @GeneratedValue
    private Integer id;

    public Category(){}

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
