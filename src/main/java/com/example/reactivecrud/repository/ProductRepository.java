package com.example.reactivecrud.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.reactivecrud.entity.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product,Integer> {
}
