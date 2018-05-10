package com.varion.lab.web.controller;

import com.varion.lab.model.Product;
import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ManufacturerService;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping ("emt/lab")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/menu/product/{id}")
    public String getProductDetails (Model model, @PathVariable("id") Long id){
        model.addAttribute("product",this.productService.findProductrById(id));
        return "productDetails";
    }

    @GetMapping("/product/add")
    public String addDevice(Model model) {
        model.addAttribute("categories",categoryService.findAllCategories());
        model.addAttribute("manufacturers", manufacturerService.findAllManufacturers());
        model.addAttribute("product", new Product());
        return "forms/product.Add";
    }

    @PostMapping(value = "/product/product-saved")
    public String saveProduct(@ModelAttribute Product product, @RequestParam("file") MultipartFile file, Model model){
        model.addAttribute("categories",categoryService.findAllCategories());
        productService.saveProduct(product);
        productService.saveFile(product,file);
        return "common/success";
    }

}
