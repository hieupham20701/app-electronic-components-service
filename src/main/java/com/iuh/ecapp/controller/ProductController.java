package com.iuh.ecapp.controller;

import com.iuh.ecapp.converter.ConvertProductDTO;
import com.iuh.ecapp.dto.ProductDTO;
import com.iuh.ecapp.entity.Product;
import com.iuh.ecapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ConvertProductDTO convertProductDTO;
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product : products){
            productDTOS.add(convertProductDTO.convertProductDTO(product));
        }
        return ResponseEntity.ok().body(productDTOS);
    }

}
