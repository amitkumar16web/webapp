package com.kaziranga.amit.service.dao;

import java.util.Optional;

import com.kaziranga.amit.forms.RegistrationForm;
import com.kaziranga.amit.user.Student;


public interface UserRegistration {   //

	public abstract int userRegistration(RegistrationForm registrationForm);
	
	 public abstract Optional<Student> findUserByemailAndPassword(String email, String password);
	 
	 public abstract boolean findUserByemail(String email);

	
	
}
