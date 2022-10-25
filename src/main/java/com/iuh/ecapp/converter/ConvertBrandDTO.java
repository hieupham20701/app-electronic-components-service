package com.iuh.ecapp.converter;

import com.iuh.ecapp.dto.BrandDTO;
import com.iuh.ecapp.model.entity.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertBrandDTO {

    @Autowired
    private ModelMapper modelMapper;
    public BrandDTO convertBrandDTO(Brand brand){
        return modelMapper.map(brand, BrandDTO.class);
    }
}
