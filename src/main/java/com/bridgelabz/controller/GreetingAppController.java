package com.bridgelabz.controller;

import com.bridgelabz.dto.GreetingAppDto;
import com.bridgelabz.entity.GreetingAppEntity;
import com.bridgelabz.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Purpose : To demonstrate the various HTTP methods
 *
 * @author SREELIPTA
 * @since 02-12-2021
 */

@RestController
public class GreetingAppController {

    @Autowired
    private GreetingAppService greetingAppService;

    /**
     * Purpose : To get mapping from client
     *
     * @return greeting message
     */
    @GetMapping(value = "/message")
    public String greeting() {

        return "Hello, Welcome to our Greeting App.";
    }

    /**
     * Purpose : To get mapping for showing greeting message
     *
     * @return message with name
     */
    @GetMapping(value = "/message2")
    public String greeting(@RequestParam String name) {

        return "Hello " + name + ", Welcome to our Greeting App.";
    }

    /**
     * Purpose : Function to get mapping from client
     *
     * @return greeting message
     */
    @GetMapping(value = "/message3")
    public String helloGreeting() {

        return greetingAppService.helloGreeting();
    }

    /**
     * Purpose : To get mapping from client to show message
     *
     * @return greeting with name
     */
    @GetMapping(value = "/message4/{name}")
    public String greetingMessage(@PathVariable String name) {

        return "Hello " + name;
    }

    /**
     * Purpose : To get mapping from client to show message
     *
     * @return greeting with first name and last name
     */
    @GetMapping(value = "/message5")
    public String greeting(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    /**
     * Purpose : To get request from client to show message
     * @param greetingAppDto used to greeting data from client
     * @return greeting message added in database
     */
    @PostMapping("/savemessage")
    public GreetingAppEntity saveGreeting(
            @RequestBody GreetingAppDto greetingAppDto
    ) {
        return greetingAppService.saveMessage(greetingAppDto);
    }
}
