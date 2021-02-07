package com.piedpiper.exception;

public class BookException {
    private String errorMessage;
   
    public BookException(String errorMessage) {
     this.errorMessage = errorMessage;
    }
   
    public String getErrorMessage() {
     return errorMessage;
    }
   
   }   