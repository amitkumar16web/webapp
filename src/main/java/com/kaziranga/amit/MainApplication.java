package com.kaziranga.amit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MainApplication {     // main class 
  
	public static void main(String[] args) {
		System.out.println("***Welcome to Moglix****");
		System.out.println("Thank you :)");
		SpringApplication.run(MainApplication.class, args);
		
	}

}
