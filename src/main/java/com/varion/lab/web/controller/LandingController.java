package com.varion.lab.web.controller;

import com.varion.lab.model.Category;
import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emt/lab")
public class LandingController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getIndex(){

        return "index";
    }
}
