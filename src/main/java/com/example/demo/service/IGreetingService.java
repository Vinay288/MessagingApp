package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;

@Service
public interface IGreetingService {
Greeting addGreeting(User user);
Greeting getGreetingById(long id);
}
