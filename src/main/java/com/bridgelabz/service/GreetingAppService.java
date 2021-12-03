package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingAppDto;
import com.bridgelabz.entity.GreetingAppEntity;
import com.bridgelabz.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Purpose : To implement all the methods in GreetingAppController
 *
 * @author SREELIPTA
 * @since 02-12-2021
 */
@Service
public class GreetingAppService {

    @Autowired
    GreetingAppRepository greetingAppRepository;

    /**
     * Purpose : To get a simple message
     *
     * @return a message that is Hello World
     */
    public String helloGreeting() {
        return "Hello World";
    }

    /**
     * Purpose : To save the greeting message to the database
     *
     * @param greetingAppDto :is used to greeting data from client
     * @return greeting message created
     */
    public GreetingAppEntity saveMessage(GreetingAppDto greetingAppDto) {
        GreetingAppEntity greetingAppEntity = new GreetingAppEntity();
        greetingAppEntity.setMessage(greetingAppDto.getMessage());
        return greetingAppRepository.save(greetingAppEntity);
    }
}
