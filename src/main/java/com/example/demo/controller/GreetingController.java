package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.service.IGreetingService;

@RestController
public class GreetingController {

	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private IGreetingService greetingService;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}

	@GetMapping("/get/{id}")
	public String getMessageById(@PathVariable Long id) {
		return greetingService.getGreetingById(id).getMessage();
	}

	@GetMapping("/getAll")
	public List<Greeting> getMessages() {
		return greetingService.getAllGreetings();
	}

	@PutMapping("/edit/{id}")
	public Greeting editMessage(@PathVariable Long id,
			@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.editGreeting(id, user);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteGreeting(@PathVariable Long id) {
		greetingService.deleteGreeting(id);
	}

}
