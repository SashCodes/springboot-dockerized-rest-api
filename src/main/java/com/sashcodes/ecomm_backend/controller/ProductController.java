package com.sashcodes.ecomm_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sashcodes.ecomm_backend.model.Product;
import com.sashcodes.ecomm_backend.service.ProductService;

@RestController
public class ProductController {
	
	ProductService service;
	
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello Sashcodes!";
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = service.getProducts();
		System.out.println(" products size returned from db: "+ products.size());
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId){
		Product product = service.getProduct(productId);
		if(product!=null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK );
		}else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND );
		}
		
	}
	
	@PostMapping("/products/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		service.addProduct(product);
		return new ResponseEntity<Product>(HttpStatus.CREATED);
	}
}
