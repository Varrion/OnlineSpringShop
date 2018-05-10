package com.varion.lab.web.controller;

import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping ("emt/lab")
public class MenuController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("categories", this.categoryService.findAllCategories());
        model.addAttribute("products", this.productService.findAllProducts());
        return "menu";
    }
}
