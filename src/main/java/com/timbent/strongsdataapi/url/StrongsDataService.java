package com.timbent.strongsdataapi.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StrongsDataService {

    private final int HEBREW_MAX = 8674;

    private final Logger logger = LoggerFactory.getLogger(StrongsDataService.class);

    private final StrongsDataRepository strongsDataRepository;

    public StrongsDataService(StrongsDataRepository strongsDataRepository) {
        this.strongsDataRepository = strongsDataRepository;
    }

    public String getJsonStringForRandomStrongsNumber(){
        String strongsNumber = getRandomNumberHebrew();
        Optional<String> strongsDataJson = strongsDataRepository.findByStrongsNumber( strongsNumber );
        logger.info("Json string from db: " + strongsDataJson.orElse(""));
        return strongsDataJson.orElse("");
    }

    public String getJsonStringForStrongsNumber(String strongsNumber){
        Optional<String> strongsDataJson = strongsDataRepository.findByStrongsNumber( strongsNumber );
        logger.info("Json string from db: " + strongsDataJson.orElse(""));
        return strongsDataJson.orElse("");
    }

    public String getRandomNumberHebrew(){
        int randomNumber = ThreadLocalRandom.current().nextInt(1, HEBREW_MAX + 1);
        return String.format("H%04d", randomNumber);
    }

}
