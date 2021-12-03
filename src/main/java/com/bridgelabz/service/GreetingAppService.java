package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingAppDto;
import com.bridgelabz.entity.GreetingAppEntity;
import com.bridgelabz.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    public GreetingAppEntity addGreeting(GreetingAppDto greetingAppDto) {
//        GreetingAppEntity greetingAppEntity = new GreetingAppEntity();
//        greetingAppEntity.setMessage(greetingAppDto.getMessage());
//        return greetingAppRepository.save(greetingAppEntity);
//    }

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

    /**
     * Purpose : To find the greeting message by id
     *
     * @param id : is given to greeting message by unique id
     * @return checking greeting message is found or not
     */
    public String findGreetingMessageById(int id) {
        Optional<GreetingAppEntity> greetingAppEntity = greetingAppRepository.findById(id);
        if (greetingAppEntity.isPresent()) {
            return "The Greeting Message with id is found: " + id;
        }
        return "The Greeting Message with id is not Found: " + id;
    }

    /**
     * Purpose : To list all the greeting messages store in the greeting repository
     *
     * @return the list of all greeting messages
     */
    public List<GreetingAppEntity> greetingMessageList() {
        return greetingAppRepository.findAll();
    }
}
