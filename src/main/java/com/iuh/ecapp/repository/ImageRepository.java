package com.iuh.ecapp.repository;

import com.iuh.ecapp.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findImageByProductId(int productId);
    List<Image> findImageByBrandId(int brandId);
}
