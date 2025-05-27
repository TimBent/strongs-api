package com.timbent.user.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timbent.user.core.helper.UserDataError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "api/v1/strongs-data-retriever")
public class UserDataController {

    private final UserDataService userDataService;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(UserDataService.class);

    @Autowired
    public UserDataController(UserDataService userDataService, ObjectMapper objectMapper){
        this.userDataService = userDataService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String welcome(){
        return "Welcome to the Strongs User Data API!";
    }


    @GetMapping(value = "/{userId}", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
    public ResponseEntity<?> getUserData( @PathVariable String userId ){

        String userDataResponse = userDataService.getJsonStringForStrongsNumber( userId );

        if( userDataResponse.isEmpty() ){
            UserDataError error = new UserDataError("User Data Not Found for {%s}".formatted(userId));
            return ResponseEntity.badRequest().body(error);
        } else {
            return ResponseEntity.ok(userDataResponse);
        }

    }



}
