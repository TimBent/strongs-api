package com.timbent.strongsdataapi.url;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timbent.strongsdataapi.url.helper.StrongsDataError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/v1/strongs-data-retriever")
public class StrongsDataController {

    private final StrongsDataService strongsDataService;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(StrongsDataService.class);

    @Autowired
    public StrongsDataController(StrongsDataService strongsDataService, ObjectMapper objectMapper){
        this.strongsDataService = strongsDataService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public String welcome(){
        return "Welcome to the Strongs Data API!";
    }


    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
    public ResponseEntity<?> getStrongsDataForToday(){

        String requestedStrongsData = strongsDataService.getJsonStringForRandomStrongsNumber();

        if( requestedStrongsData.isEmpty()){
            StrongsDataError error = new StrongsDataError("Strongs Data Not Found");
            return ResponseEntity.badRequest().body(error);
        } else {
            return ResponseEntity.ok(requestedStrongsData);
        }

    }

    @GetMapping("/{strongsNumber}")
    public ResponseEntity<?> getStrongsDataFromStrongsNumber(@PathVariable String strongsNumber ){

        String requestedStrongsData = strongsDataService.getJsonStringForStrongsNumber(strongsNumber);
        logger.info("Json string from db: " + requestedStrongsData);
        if( requestedStrongsData.isEmpty()){
            StrongsDataError error = new StrongsDataError("Strongs Data Not Found for: %s".formatted(strongsNumber));
            return ResponseEntity.badRequest().body(error);
        } else {
            return ResponseEntity.ok(requestedStrongsData);
        }

    }

    @GetMapping("/favourites/{userId}")
    public ResponseEntity<?> getStrongsDataFromStrongsNumber(@PathVariable List<String> strongsNumber ){

        String requestedStrongsData = strongsDataService.getJsonStringForStrongsNumber(strongsNumber);
        logger.info("Json string from db: " + requestedStrongsData);
        if( requestedStrongsData.isEmpty()){
            StrongsDataError error = new StrongsDataError("Strongs Data Not Found for: %s".formatted(strongsNumber));
            return ResponseEntity.badRequest().body(error);
        } else {
            return ResponseEntity.ok(requestedStrongsData);
        }

    }

}
