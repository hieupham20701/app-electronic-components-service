package com.iuh.ecapp.controller;

import com.iuh.ecapp.converter.ConvertBrandDTO;
import com.iuh.ecapp.dto.BrandDTO;
import com.iuh.ecapp.model.entity.Brand;
import com.iuh.ecapp.service.BrandService;
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
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ConvertBrandDTO convertBrandDTO;
    @GetMapping
    public ResponseEntity<List<BrandDTO>> getBrands(){
        List<Brand> brands = brandService.getBrands();
        List<BrandDTO> brandDTOS = new ArrayList<>();
        for(Brand brand : brands){
            brandDTOS.add(convertBrandDTO.convertBrandDTO(brand));
        }
        return ResponseEntity.ok().body(brandDTOS);
    }

}
