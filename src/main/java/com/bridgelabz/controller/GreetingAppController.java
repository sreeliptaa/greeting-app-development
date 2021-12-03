package com.bridgelabz.controller;

import com.bridgelabz.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/message")
    public String greeting() {

        return "Hello, Welcome to our Greeting App.";
    }

    @GetMapping(value = "/message2")
    public String greeting(@RequestParam String name) {

        return "Hello " + name + ", Welcome to our Greeting App.";
    }

    @GetMapping(value = "/message3")
    public String helloGreeting() {
        return greetingAppService.helloGreeting();
    }

    @GetMapping(value = "/message4/{name}")
    public String greetingMessage(@PathVariable String name) {
        return "Hello " + name ;
    }

    @GetMapping(value = "/message5")
    public String greeting(@RequestParam String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
