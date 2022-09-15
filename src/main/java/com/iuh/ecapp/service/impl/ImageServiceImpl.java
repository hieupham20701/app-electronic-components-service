package com.iuh.ecapp.service.impl;

import com.iuh.ecapp.entity.Image;
import com.iuh.ecapp.repository.ImageRepository;
import com.iuh.ecapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Image saveImage(String employeeId, MultipartFile file) throws IOException {
        return null;
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
