package com.piedpiper.service;

import java.util.List;
import com.piedpiper.model.Book;

public interface BookService {

 public Book findById(long id);
 public Book findByName(String bookName);
 public void saveBook(Book book);
 public void updateBook(Book book);
 public void deleteBookById(long id);
 public List<Book> findAllBooks();
 public void deleteAllBooks();
 public boolean isBookExist(Book Book);
 
}