package com.example.testcrud.Service.impl;

import com.example.testcrud.Converter.productConverter;
import com.example.testcrud.Dto.productDto;
import com.example.testcrud.Entity.product;
import com.example.testcrud.Repository.productRepo;
import com.example.testcrud.Service.interfaces.productService;
import com.example.testcrud.exception.InvalidException;
import com.example.testcrud.exception.NotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class productServiceimpl implements productService {
    @Autowired
    private productConverter productConverter;
    @Autowired
    private productRepo productRepo;
    @Override
    public void addProduct(productDto dto){
        product pro = productConverter.toEntity(dto);
        productRepo.save(pro);
    }

    @Override
    public void deleteProduct(int id) {
        Optional<product> pro = productRepo.findById(id);
        if(pro.isPresent()){
            productRepo.deleteById(id);
        }else {
            throw new NotfoundException("khong ton tai san pham");
        }

    }

    @Override
    public void editProduct(int id, productDto dto) {
        product pro = productRepo.findById(id).orElseThrow(()-> new NotfoundException("khong ton tai san pham"));
        pro.setPrice(dto.getPrice());
        pro.setName(dto.getName());
        productRepo.save(pro);
    }
}
