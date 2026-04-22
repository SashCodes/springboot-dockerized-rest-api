package com.sashcodes.ecomm_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sashcodes.ecomm_backend.dao.ProductRepository;
import com.sashcodes.ecomm_backend.model.Product;

@Service
public class ProductService{

	ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Product> getProducts() {
		return repo.findAll();
	}

	public Product getProduct(int productId) {
		return repo.findById(productId).orElse(null);
	}

	public Product addProduct(Product product) {
		return repo.save(product);
	}

}
