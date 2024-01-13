package com.example.testcrud.Converter;

import com.example.testcrud.Dto.productDto;
import com.example.testcrud.Entity.product;
import org.springframework.stereotype.Component;

@Component
public class productConverter {
    public product toEntity(productDto dto){
        product pro = new product();
        pro.setName(dto.getName());
        pro.setPrice(dto.getPrice());
        return pro;
    }
    public productDto toDto(product pro){
        productDto dto = new productDto();
        dto.setName(pro.getName());
        dto.setPrice(pro.getPrice());
        return dto;
    }
}
