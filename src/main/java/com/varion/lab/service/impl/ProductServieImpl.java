package com.varion.lab.service.impl;

import com.varion.lab.model.Category;
import com.varion.lab.model.Product;
import com.varion.lab.repository.ProductRepository;
import com.varion.lab.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServieImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct (Product product){

        return this.productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts(){

        return this.productRepository.findAll();
    }

    @Override
    public Product findProductrById( Long id){

        return this.productRepository.getOne(id);
    }

    @Override
    public Product findProductByCategory(Category category){
        return this.productRepository.getOne(category.getId());
    }

    @Override
    public void saveFile(Product product, MultipartFile file) {
        try {
            product.setPhotoData(file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.saveProduct(product);
    }
}
