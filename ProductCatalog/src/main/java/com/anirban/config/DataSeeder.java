package com.anirban.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anirban.model.Category;
import com.anirban.model.Product;
import com.anirban.repository.CategoryRepository;
import com.anirban.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{
	@Autowired
	private ProductRepository prepo;
	@Autowired
	private CategoryRepository crepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		prepo.deleteAll();
		crepo.deleteAll();
		
		//create category
		Category electronics= new Category();
		electronics.setName("Electronis");
		Category clothing= new Category();
		clothing.setName("Clothing");
		Category home= new Category();
		home.setName("Home & Kitchen");
		
		crepo.saveAll(Arrays.asList(electronics,clothing,home));
		
		//create product
		Product phone=new Product();
		phone.setName("SmartPhone");
		phone.setDescription("Latest model smartphone with amazing features");
		phone.setImgUrl("https://placehold.co/600x400");
		phone.setPrice(34999.99);
		phone.setCategory(electronics);
		
		Product laptop=new Product();
		laptop.setName("Laptop");
		laptop.setDescription("High performance laptop for gaming");
		laptop.setImgUrl("https://placehold.co/600x400");
		laptop.setPrice(89999.99);
		laptop.setCategory(electronics);
		
		Product jacket=new Product();
		jacket.setName("Winter Jacket");
		jacket.setDescription("Warm & cozy winter wear");
		jacket.setImgUrl("https://placehold.co/600x400");
		jacket.setPrice(999.99);
		jacket.setCategory(clothing);
		
		Product sofa=new Product();
		sofa.setName("Sofa");
		sofa.setDescription("Comfortable Sofa for family");
		sofa.setImgUrl("https://placehold.co/600x400");
		sofa.setPrice(26999.99);
		sofa.setCategory(home);
		
		prepo.saveAll(Arrays.asList(phone,laptop,jacket,sofa));
	}
	
}
