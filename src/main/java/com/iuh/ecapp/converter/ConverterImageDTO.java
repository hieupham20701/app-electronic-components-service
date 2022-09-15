package com.iuh.ecapp.converter;

import com.iuh.ecapp.dto.ImageDTO;
import com.iuh.ecapp.entity.Image;
import com.iuh.ecapp.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ConverterImageDTO {

    public ImageDTO converImageDTO(Image image){
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(image.getId());
        imageDTO.setType(image.getType());
        imageDTO.setUrl(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(image.getId() + "")
                .toUriString());
        return imageDTO;
    }

}
