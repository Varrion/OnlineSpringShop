package com.varion.lab.service;

import com.varion.lab.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct (Product product);
    List<Product> findAllProducts();
    Product findProductrById (Long id);
}
