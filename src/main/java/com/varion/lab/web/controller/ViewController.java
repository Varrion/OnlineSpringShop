package com.varion.lab.web.controller;

import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("emt/lab")
public class ViewController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getIndex(){

        return "index";
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("categories", this.categoryService.findAllCategories());
        model.addAttribute("products", this.productService.findAllProducts());
        return "menu";
    }

    @GetMapping("/menu/{id}")
    public String getCategoryMenu(Model model, @PathVariable("id") Long id){
        model.addAttribute("category", this.categoryService.findCategoryById(id));
        return "categoryMenu";
    }
}
