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
		listOfProducts.add(new Product("book-1", "Python Crash Course: A Hands-On, Project-Based Introduction to Programming", "Second edition of the best-selling Python book in the world. A fast-paced, no-nonsense guide to programming in Python.", 25.00, "Eric Matthes"));
		listOfProducts.add(new Product("book-2", "Effective Java, 3rd Edition", "In this new edition of Effective Java, Bloch explores new design patterns and language idioms that have been introduced since the second edition was released in 2008 shortly after Java SE6, including Lambda, streams, generics and collections, as well as selected Java 9 features. ", 50.00, "Joshua Bloch"));
		listOfProducts.add(new Product("book-3", "C Programmming Language, 2nd Edition", "This book was written by the developers of C themselves and is easily the best C programming book out there. It includes a comprehensive guide to the C programming language, ANSI changes, scope rules and everything else related to C.", 30.00, "Brian W. Kernigham, Dennis M. Ritchie"));
        listOfProducts.add(new Product("book-4", "Eloquent JavaScript: A Modern Introduction to Programming", "This is the best selling book on Javascript that provides a deep dive into the Javascript language. Every chapter has a number of projects to give you a hands-on experience of writing real-world applications.", 32.00, "Marijn Haverbeke"));
        listOfProducts.add(new Product("book-5", "The DevOps Handbook", "Increase profitability, elevate work culture, and exceed productivity goals through DevOps practices.", 20.00, "Gene Kim, Patrick Debois"));

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
