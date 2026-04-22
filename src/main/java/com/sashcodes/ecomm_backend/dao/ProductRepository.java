package com.sashcodes.ecomm_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sashcodes.ecomm_backend.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
