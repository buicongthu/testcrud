package com.example.testcrud.Controller;

import com.example.testcrud.Dto.productDto;
import com.example.testcrud.Service.impl.productServiceimpl;
import com.example.testcrud.exception.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class productController {
    @Autowired
    private productServiceimpl productServiceimpl;
    @PostMapping("/add")
    public ResponseEntity<Object> addproduct(@RequestBody productDto productDto){
        try {
            productServiceimpl.addProduct(productDto);
            return ResponseEntity.ok("add successfully");
        }catch (InvalidException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delte/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id){
        try {
            productServiceimpl.deleteProduct(id);
            return ResponseEntity.ok("delete successfully");
        }catch (InvalidException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editProduct(@PathVariable int id,@RequestBody productDto productDto){
        try {
            productServiceimpl.editProduct(id,productDto);
            return ResponseEntity.ok("edit successfully");
        }catch (InvalidException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
