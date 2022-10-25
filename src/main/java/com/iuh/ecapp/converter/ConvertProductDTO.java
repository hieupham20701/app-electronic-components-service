package com.iuh.ecapp.converter;

import com.iuh.ecapp.dto.ImageDTO;
import com.iuh.ecapp.dto.ProductDTO;
import com.iuh.ecapp.model.entity.Image;
import com.iuh.ecapp.model.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertProductDTO {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ConverterImageDTO converterImageDTO;
    public ProductDTO convertProductDTO(Product product, List<Image> images){
        ProductDTO productDTO = modelMapper.map(product,ProductDTO.class);
        List<ImageDTO> imageDTOS = new ArrayList<>();
        for(Image image : images){
            ImageDTO imageDTO = converterImageDTO.converImageDTO(image);
            imageDTOS.add(imageDTO);
        }
        productDTO.setImageDTOs(imageDTOS);
        return productDTO;
    }
}
