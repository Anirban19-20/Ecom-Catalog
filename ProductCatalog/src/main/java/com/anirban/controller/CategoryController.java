package com.anirban.controller;

import java.util.List;
import com.anirban.model.Category;
import com.anirban.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:1004/")
public class CategoryController {
	@Autowired
	private CategoryService cservice;
	@GetMapping
	public List<Category> getAllCategories(){
		return cservice.getAllCategories();
	}
	
}
