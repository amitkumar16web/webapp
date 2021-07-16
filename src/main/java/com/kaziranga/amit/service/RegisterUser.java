package com.kaziranga.amit.service;

import java.util.Optional;

import com.kaziranga.amit.forms.RegistrationForm;
import com.kaziranga.amit.user.Student;

public interface RegisterUser {   //

	public abstract int registerUser(RegistrationForm registrationForm);
	
	public abstract Optional<Student> finduser(String email, String password);
	
	public abstract boolean finduser(String email);
	
}
