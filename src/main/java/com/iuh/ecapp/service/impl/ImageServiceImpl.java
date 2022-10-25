package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.model.entity.Image;
import com.iuh.ecapp.repository.BrandRepository;
import com.iuh.ecapp.repository.ImageRepository;
import com.iuh.ecapp.repository.ProductRepository;
import com.iuh.ecapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Image saveImage(String productId, String brandId, String type, MultipartFile file) throws IOException {
        Image image = new Image();
        if(!productId.equals("")){
            image.setProduct(productRepository.findById(Integer.parseInt(productId)).get());

        }else{
            image.setProduct(null);
        }
        if(!brandId.equals("")){
            image.setBrand(brandRepository.findById(Integer.parseInt(brandId)).get());
        }else {
            image.setBrand(null);
        }
        image.setFile(file.getBytes());
        String typeFile = StringUtils.cleanPath(file.getOriginalFilename());
        image.setFileType(typeFile);
        image.setType(type);
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getImageById(int id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Image> getImageByProductId(int id) {
        return imageRepository.findImageByProductId(id);
    }

    @Override
    public List<Image> getImageByBrandId(int id) {
        return imageRepository.findImageByBrandId(id);
    }

}
