package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GREETINGS")
public class Greeting {
@Id
private long id;
@Override
public String toString() {
	return "Greeting [id=" + id + ", message=" + message + "]";
}
private String message;

public Greeting() {
	id=0;
	message="";
}
public Greeting(long id, String message) {
	setId(id);
	setMessage(message);
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

}
