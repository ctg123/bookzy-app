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
        //listOfProducts.add(new Product("book-6", "Clean Code: A Handbook of Agile Software Craftmanship, 1st Edition", "Software expert Robert C. Martin presents Clean Code: A Handbook of Agile Software Craftsmanship. Martin has teamed up with his colleagues to distill their best agile practice of cleaning code “on the fly” into a book that will instill within you the values of a software craftsman and a better programmer.", 28.00, "Robert C. Martin"));
        //listOfProducts.add(new Product("book-7", "Cracking the Coding Interview: 150 Programming Questions and Solutions, 6th Edition", "Cracking the Coding Interview gives you the interview preparation you need to get the top software developer jobs. This is a deeply technical book and focuses on the software engineering skills to ace your interview.", 27.00, "Gayle Laakmann McDowell"));
        //listOfProducts.add(new Product("book-8", "The Self-Taught Programmer: The Definitive Guide to Programming Professionally", "'The Self-taught Programmer' is a roadmap, a guide to take you from writing your first Python program, to passing your first technical interview.", 20.00, "Cory Althoff"));
        //listOfProducts.add(new Product("book-9", "Hands-On Machine Learning with Scikit-Learn, Keras, and Tensorflow", "By using concrete examples, minimal theory, and two production-ready Python frameworks—Scikit-Learn and TensorFlow—author Aurélien Géron helps you gain an intuitive understanding of the concepts and tools for building intelligent systems.", 43.00, "Aurélien Géron"));
        //listOfProducts.add(new Product("book-10", "The Complete Software Developer's Career Guide", "The Complete Software Developer’s Career Guide builds soft skills, including communication, negotiation, and managing a team. Developers learn to handle any challenge, from choosing a programming language to acing an interview and moving up the ladder.", 25.00, "John Sonmez"));

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
