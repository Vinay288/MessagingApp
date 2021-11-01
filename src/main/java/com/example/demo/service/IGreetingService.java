package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;

@Service
public interface IGreetingService {
Greeting addGreeting(User user);
Greeting getGreetingById(long id);
List<Greeting> getAllGreetings();
Greeting editGreeting(long id,User user);
ResponseEntity<HttpStatus> deleteGreeting(long id);
}
