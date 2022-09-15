package com.iuh.ecapp.controller;

import com.iuh.ecapp.converter.ConverterImageDTO;
import com.iuh.ecapp.entity.Image;
import com.iuh.ecapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/images")
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ConverterImageDTO converterImageDTO;

    @GetMapping("/products/files/{productId}")
    public ResponseEntity<List<byte[]>> getProductImages(@PathVariable int productId){
        List<Image> images = imageService.getImageByProductId(productId);
        List<byte[]> files = new ArrayList<byte[]>();
        for (int i = 0; i < images.size(); i++) {
            files.add(images.get(i).getFile());
        }
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/brands/files/{brandId}")
    public ResponseEntity<List<byte[]>> getFileBrandImage(@PathVariable int brandId) {
        List<Image> images = imageService.getImageByBrandId(brandId);
        List<byte[]> files = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            files.add(images.get(i).getFile());
        }
        return ResponseEntity.ok().body(files);
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileImageById(@PathVariable int id) {
        Optional<Image> image = imageService.getImageById(id);
//        image.orElseThrow(()-> return ResponseEntity.status(Ht));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.get().getFileType() + "\"")
                .body(image.get().getFile());
    }



}

