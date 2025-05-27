package com.timbent.user.core.exception;

public class UserDataMissingException extends Exception {

    final String message;

     UserDataMissingException(String message){
         this.message = message;
     }
}
