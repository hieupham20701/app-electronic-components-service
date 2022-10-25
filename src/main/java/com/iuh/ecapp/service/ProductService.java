package com.iuh.ecapp.service;

import com.iuh.ecapp.model.entity.Image;
import com.iuh.ecapp.model.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {


    Map<Product,List<Image>> getAllProducts();
}
