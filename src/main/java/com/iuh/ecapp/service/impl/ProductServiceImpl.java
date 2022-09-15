package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.entity.Product;
import com.iuh.ecapp.repository.ProductRepository;
import com.iuh.ecapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository PRODUCT_REPOSITORY;
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = PRODUCT_REPOSITORY.findAll();
        return products;
    }


}
