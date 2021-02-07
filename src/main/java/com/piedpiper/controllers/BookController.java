package com.piedpiper.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.piedpiper.exception.BookException;
import com.piedpiper.model.Book;
import com.piedpiper.service.BookService;

@RestController
@RequestMapping("/")
public class BookController {

@Autowired
BookService bookService;

@RequestMapping(value = "/book", method = RequestMethod.GET)
public ResponseEntity <List<Book>> findAllBooks() {
 List<Book> books = bookService.findAllBooks();
 if(books.isEmpty()){
     return new ResponseEntity <List<Book>>(HttpStatus.NO_CONTENT);
 }
 return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
}

@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
public RequestEntity<?> findBook(@PathVariable("id") long id){
 Book book = bookService.findById(id);
 if (book == null){
    return new ResponseEntity<BookException>(
      new BookException("ERROR: Book Id" + id
        + " not found"), HttpStatus.NOT_FOUND);
 }   
 return new ResponseEntity<Book>(book, HttpStatus.OK);
}

@RequestMapping(value = "/book", method = RequestMethod.POST)
 public ResponseEntity<?> createBook(@RequestBody Book book,
   UriComponentsBuilder ucBuilder) {

  if (bookService.isBookExist(book)) {
   return new ResponseEntity<BookException>(
     new BookException("ERROR: Book name ="
       + book.getName() + " already exist."),
     HttpStatus.CONFLICT);
  }
  bookService.saveBook(book);

  HttpHeaders headers = new HttpHeaders();
  headers.setLocation(ucBuilder.path("/api/book/{id}")
    .buildAndExpand(book.getId()).toUri());
  return new ResponseEntity<String>(headers, HttpStatus.CREATED);
 }

 @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT)
 public ResponseEntity<?> updateBook(@PathVariable("id") long id,
   @RequestBody Book book) {


    Book currentBook = bookService.findById(id);

    if (currentBook == null) {
        return new ResponseEntity<BookException>(
          new BookException("ERROR: Id =" + id
            + " not found."), HttpStatus.NOT_FOUND);
       }
     
       currentBook.setName(book.getName());
       currentBook.setAuthor(book.getAuthor());
       currentBook.setPrice(book.getPrice());
       return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
      }

@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<?> deleteBook(@PathVariable("id") long id) {

  Book book = bookService.findById(id);
  if (book == null) {
   return new ResponseEntity<BookException>(
     new BookException("ERROR: Id =" + id
       + " not found."), HttpStatus.NOT_FOUND);
  }
  bookService.deleteBookById(id);
  return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
 }

 @RequestMapping(value = "/book", method = RequestMethod.DELETE)
 public ResponseEntity<Book> deleteAllBooks() {

  bookService.deleteAllBooks();
  return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
 }

}