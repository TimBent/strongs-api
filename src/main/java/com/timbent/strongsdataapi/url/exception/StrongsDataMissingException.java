package com.timbent.strongsdataapi.url.exception;

public class StrongsDataMissingException extends Exception {

    final String message;

     StrongsDataMissingException( String message){
         this.message = message;
     }
}
