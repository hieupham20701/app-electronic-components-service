package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.entity.Brand;
import com.iuh.ecapp.repository.BrandRepository;
import com.iuh.ecapp.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
