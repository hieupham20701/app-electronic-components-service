package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.model.entity.Image;
import com.iuh.ecapp.model.entity.Product;
import com.iuh.ecapp.repository.ImageRepository;
import com.iuh.ecapp.repository.ProductRepository;
import com.iuh.ecapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Map<Product,List<Image>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        Map<Product,List<Image>> result = new HashMap<>();
        for (Product product : products){
            List<Image> images = imageRepository.findImageByProductId(product.getId());
            result.put(product, images);
        }
        return result;
    }


}
