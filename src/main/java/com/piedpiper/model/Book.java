package com.piedpiper.model;

public class Book {
 private long id;
 private String name;
 private String author;
 private float price;
 
 public Book() {
  id = 0;
 }

 public Book(long id, String name, String author, float price){
  this.id = id;
  this.name = name;
  this.author = author;
  this.price = price;
 }

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public String getName() {
  return name;  
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getAuthor() {
    return author;
   }
  
 public void setAuthor(String author) {
  this.author = author;
   }
  
 public float getPrice() {
  return price;
   }
  
 public void setPrice(float price) {
  this.price = price;
   }
  
 @Override
  public int hashCode() {
   final int prime = 31;
   int result = 1;
   result = prime * result + (int) (id ^ (id >>> 32));
   return result;
   }
  
 @Override
  public boolean equals(Object obj) {
   if (this == obj)
    return true;
   if (obj == null)
    return false;
   if (getClass() != obj.getClass())
    return false;
   Book other = (Book) obj;
   if (id != other.id)
    return false;
   return true;
   }
}