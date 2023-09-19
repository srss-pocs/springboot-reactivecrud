package com.example.reactivecrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reactivecrud.entity.Product;
import com.example.reactivecrud.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@GetMapping
	public Flux<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Product> getProductById(@PathVariable int id) {

		return productRepo.findById(id);
	}

	@PostMapping
	public Mono<Product> insertProduct(@RequestBody Product product) {

		return productRepo.save(product);
	}

	@PutMapping("/{id}")
	public Mono<Product> updateProductById(@RequestBody Product product, @PathVariable int id) {

		return productRepo.save(product);
		/*
		 * return productRepo.findById(id) .map( (c)->{ c.setName(product.getName());
		 * c.setPrice(product.getPrice()); return c ;
		 * }).flatMap(c->productRepo.save(c));
		 */
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable int id) {
		return productRepo.deleteById(id);
	}
}
