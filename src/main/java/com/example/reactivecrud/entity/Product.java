package com.example.reactivecrud.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

	@Id
	private Integer id;
	private String name;
	private Double price;
}