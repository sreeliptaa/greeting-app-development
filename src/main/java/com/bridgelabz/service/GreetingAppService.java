package com.bridgelabz.service;

import org.springframework.stereotype.Service;

/**
 * Purpose : To implement all the methods in GreetingAppController
 *
 * @author SREELIPTA
 * @since 02-12-2021
 */
@Service
public class GreetingAppService {
    public String helloGreeting() {
        return "Hello World";
    }
}
