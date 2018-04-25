package com.varion.lab.service;

import com.varion.lab.model.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory (String name);
    List<Category> findAllCategories();
    Category findCategoryById (Long id);

}
