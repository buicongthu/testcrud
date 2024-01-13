package com.example.testcrud.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productDto {
    private Integer id;
    private String name;
    private double price;
}
