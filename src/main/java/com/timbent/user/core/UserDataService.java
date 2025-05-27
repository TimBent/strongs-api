package com.timbent.user.core;

import com.timbent.user.dao.UserDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserDataService {

    private final int HEBREW_MAX = 8674;

    private final Logger logger = LoggerFactory.getLogger(UserDataService.class);

    private final UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }


    public String getJsonStringForStrongsNumber(String userId){
        Optional<String> userDataJson = userDataRepository.getUserData( userId );
        logger.info("Json string from db: " + userDataJson.orElse(""));
        return userDataJson.orElse("");
    }

    public String getRandomNumberHebrew(){
        int randomNumber = ThreadLocalRandom.current().nextInt(1, HEBREW_MAX + 1);
        return String.format("H%04d", randomNumber);
    }

}
