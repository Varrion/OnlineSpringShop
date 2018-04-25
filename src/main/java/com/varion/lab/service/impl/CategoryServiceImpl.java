package com.varion.lab.service.impl;

import com.varion.lab.model.Category;
import com.varion.lab.repository.CategoryRepository;
import com.varion.lab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory (String name){
        Category category = new Category();
        category.setName(name);

        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories(){

        return this.categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById (Long id) {

        return this.categoryRepository.getOne(id);
    }
}
