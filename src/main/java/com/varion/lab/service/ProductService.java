package com.varion.lab.service;

import com.varion.lab.model.Category;
import com.varion.lab.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    Product saveProduct (Product product);
    List<Product> findAllProducts();
    Product findProductrById (Long id);
    Product findProductByCategory (Category category);
    public void saveFile(Product product, MultipartFile file);
}
