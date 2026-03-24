package com.anirban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anirban.model.Product;
import com.anirban.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository prepo;
	
	public List<Product> getAllProducts(){
		return prepo.findAll();
	}
	
	public List<Product> getProductByCategory(Long categoryId){
		return prepo.findByCategoryId(categoryId);
	}
}
