package com.iuh.ecapp.service;

import com.iuh.ecapp.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ImageService {
   Image saveImage(String productId, String brandId, String type, MultipartFile file) throws IOException;
   Optional<Image> getImageById(int id);

   List<Image> getImageByProductId(int id);

   List<Image> getImageByBrandId(int id);
}
