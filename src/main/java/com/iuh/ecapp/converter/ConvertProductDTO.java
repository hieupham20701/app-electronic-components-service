package com.iuh.ecapp.converter;

import com.iuh.ecapp.dto.ProductDTO;
import com.iuh.ecapp.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertProductDTO {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertProductDTO(Product product){
        ProductDTO productDTO = modelMapper.map(product,ProductDTO.class);
        return productDTO;
    }
}
