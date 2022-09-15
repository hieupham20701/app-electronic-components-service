package com.iuh.ecapp.service;

import com.iuh.ecapp.entity.Product;
import com.iuh.ecapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {


    List<Product> getAllProducts();
}
