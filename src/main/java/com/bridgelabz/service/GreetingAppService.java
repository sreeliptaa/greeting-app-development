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

    /**
     * Purpose : To edit the available greeting in the database
     *
     * @param id unique id of the greeting message
     * @param greetingAppDTO greeting data from client
     * @return edited greeting message
     */
    public String editMessage(int id, GreetingAppDto greetingAppDTO) {
        Optional<GreetingAppEntity> greetingAppEntity = greetingAppRepository.findById(id);
        if (greetingAppEntity.isPresent()) {
            GreetingAppEntity greetingAppEntity1 = greetingAppEntity.get();
            greetingAppEntity1.setMessage(greetingAppDTO.getMessage());
            greetingAppRepository.save(greetingAppEntity1);
            return "Greeting message edited successfully";
        }
        return "Cannot find greeting message with given id: " + id;
    }
}
