package com.example.testcrud.Service.interfaces;

import com.example.testcrud.Dto.productDto;

public interface productService {
    public void addProduct(productDto dto);
    public void deleteProduct(int id);
    public void editProduct(int id, productDto dto);
}
