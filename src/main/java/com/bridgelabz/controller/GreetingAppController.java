package com.bridgelabz.controller;

import com.bridgelabz.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
