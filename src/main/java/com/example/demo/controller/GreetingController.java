package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;

@RestController
public class GreetingController {
	
private static String template="Hello, %s!";
private final AtomicLong counter=new AtomicLong();

@GetMapping("/greeting")
public Greeting greeting(@RequestParam(value="name" ,defaultValue = "World")String name) {
	return new Greeting(counter.incrementAndGet(),String.format(template, name));
}

@RequestMapping(value = { "/query" })
public Greeting sayHi(@RequestParam(value = "fname", defaultValue = "vinay") String fname,
		@RequestParam(value = "lname", defaultValue = "Hiremath") String lname) {
	return new Greeting(counter.incrementAndGet(),String.format(template, fname+" "+lname));
}

@GetMapping("/param/{name}")
public Greeting parameterName(@PathVariable String name) {
	return new Greeting(counter.incrementAndGet(),String.format(template, name));}

@PostMapping("/post")
public Greeting setUser(@RequestBody Greeting greeting) {
	return new Greeting(counter.incrementAndGet(),String.format(template, greeting.getName()));
}
@PutMapping("/put/{firstName}")
public Greeting sayHelloPutMethod(@PathVariable String firstName,@RequestParam(value="lastName",defaultValue="Hiremath") String lastName) {
	return new Greeting(counter.incrementAndGet(),String.format(template, firstName+" "+lastName));
}
}
