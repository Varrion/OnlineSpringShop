package com.varion.lab.web.controller;

import com.varion.lab.model.Category;
import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("emt/lab")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/menu/{id}")
    public String getCategoryMenu(Model model, @PathVariable("id") Long id){
        model.addAttribute("category", this.categoryService.findCategoryById(id));
        model.addAttribute("products",this.productService.findAllProducts());
        return "categoryMenu";
    }

    @GetMapping ("/category/add")
        public String addCategory(Model model){
        model.addAttribute("categories",categoryService.findAllCategories());
        model.addAttribute("category", new Category());
        return "forms/category.Add";

        }

    @PostMapping (value = "/category/category-saved")
    public String saveCategory (@ModelAttribute String name, Model model){
        model.addAttribute(this.categoryService.findAllCategories());
        this.categoryService.saveCategory(name);
        return "common/success";
    }
}
