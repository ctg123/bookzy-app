package com.bookzy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import com.bookzy.models.Product;

@Service
//This is the baseline class to construct the products. The inventory of Books is passed in the Array.
public class ProductService {
	
	public List<Product> getAllProducts() {
		
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Product("book-1", "Python Crash Course: A Hands-On, Project-Based Introduction to Programming", "Second edition of the best-selling Python book in the world. A fast-paced, no-nonsense guide to programming in Python. Updated and thoroughly revised to reflect the latest in Python code and practices.
        ", 25.00, "Eric Matthes"));
		listOfProducts.add(new Product("book-2", "Samsung Y", "This is Awesome Samsung ", 300.4, "Samsung Inc"));
		listOfProducts.add(new Product("book-3", "LG Z", "This is Awesome LG ", 200.4, "LG Inc"));

		return listOfProducts;
	}
	
	public Product getProductById(String id) {
		
		Predicate<Product> byId = p -> p.getId().equals(id);
		return filterProducts(byId);
	}
	
	public Product filterProducts(Predicate<Product> strategy) {
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}

}
