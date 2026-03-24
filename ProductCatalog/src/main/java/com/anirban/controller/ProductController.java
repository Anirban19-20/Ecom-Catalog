package com.anirban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anirban.model.Product;
import com.anirban.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("http://localhost:1004/")
public class ProductController {
	@Autowired
	private ProductService pserve;
	@GetMapping
	public List<Product> getAllProducts(){
		return pserve.getAllProducts();
	}
	@GetMapping("/category/{categoryId}")
	public List<Product> getProductByCategory(@PathVariable Long categoryId){
		return pserve.getProductByCategory(categoryId);
	}
}
