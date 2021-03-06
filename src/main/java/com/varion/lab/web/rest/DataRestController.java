package com.varion.lab.web.rest;

import com.varion.lab.model.Category;
import com.varion.lab.model.Manufacturer;
import com.varion.lab.model.Product;
import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ManufacturerService;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/emt/lab/rest")
public class DataRestController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    @PostMapping("/category")
    public Category saveCategory(@RequestParam("name") String name){

        return this.categoryService.saveCategory(name);
    }

    @PostMapping("/manufacturer")
    public Manufacturer saveManufacturer(@RequestParam("name") String name){

        return this.manufacturerService.saveManufacturer(name);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return this.productService.saveProduct(product);
    }


    @RequestMapping(value = "product/image/{product_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("product_id") Long productId) throws IOException {

        Product product = productService.findProductrById(productId);
        byte[] imageContent = product.getPhotoData();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
}
