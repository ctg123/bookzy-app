package com.piedpiper.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import com.piedpiper.model.Book;

@Service
public class BookServiceImpl implements BookService {

 private static final AtomicLong counter = new AtomicLong();

 private static List<Book> books;

 static {
  init();
 }

 private static void init() {
  List<Book> bookList = new ArrayList<Book>();
  bookList.add(new Book(counter.incrementAndGet(), "Java", "Andrew",
    100.0f));
  bookList.add(new Book(counter.incrementAndGet(),
    "Data Structure & Algorithm", "John", 200.f));
  books = bookList;
 }

 public Book findById(long id) {
  for (Book book : books) {
   if (book.getId() == id) {
    return book;
   }
  }
  return null;
 }

 public void saveBook(Book book) {
  book.setId(counter.incrementAndGet());
  books.add(book);
 }

 public void updateBook(Book book) {
  int index = books.indexOf(book);
  books.set(index, book);
 }

 public void deleteBookById(long id) {
  for (Iterator<Book> iter = books.iterator(); iter.hasNext();) {
   Book book = iter.next();
   if (book.getId() == id) {
    iter.remove();
   }
  }
 }

 public List<Book> findAllBooks() {
  return books;
 }

 public void deleteAllBooks() {
  books.clear();
 }

 public boolean isBookExist(Book book) {
  return findByName(book.getName()) != null;
 }

 public Book findByName(String bookName) {
  for (Book book : books) {
   if (book.getName().equalsIgnoreCase(bookName)) {
    return book;
   }
  }
  return null;
 }

}