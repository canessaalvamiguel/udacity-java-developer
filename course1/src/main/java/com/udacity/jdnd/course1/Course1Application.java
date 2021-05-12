package com.udacity.jdnd.course1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Course1Application {

	public static void main(String[] args) {
		SpringApplication.run(Course1Application.class, args);
	}

	@Bean
	public String message(){
		System.out.println("Hello, Spring!");
		return "Hello, Spring!";
	}

	@Bean
	public String upperCaseMessage(MessageService messageService){
		System.out.println("Creating upperCaseMessage bean");
		return messageService.upperCase();
	}

	@Bean
	public String lowerCaseMessage(MessageService messageService){
		System.out.println("Creating lowerCaseMessage bean");
		return messageService.lowerCase();
	}

}
