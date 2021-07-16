package com.kaziranga.amit.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.kaziranga.amit.forms.RegistrationForm;
import com.kaziranga.amit.service.RegisterUser;
import com.kaziranga.amit.service.dao.UserRegistration;
import com.kaziranga.amit.user.Student;

public class RegisterUserImpl implements RegisterUser {

	@Autowired
	private UserRegistration userRegistration;

	@Override
	public int registerUser(RegistrationForm registrationForm) {

		//System.out.println("inside RegisterUserImpl.java");
		int userSuceess = 0;
		try {
			userSuceess = userRegistration.userRegistration(registrationForm);
		} catch (Exception e) {
			//System.out.println("error" + e.getMessage());
		}

		return userSuceess;
	}

	@Override
	public Optional<Student> finduser(String email, String password) {
		Optional<Student> student = null;
		try {
			 student = userRegistration.findUserByemailAndPassword(email, password);
		} catch (Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				//System.out.println("User Does not exist in DB");
				return student;
			}
		}

		return student;

	}
	
	
	@Override
	public boolean finduser(String email) {
		boolean isuserExist = false;
		try {
			isuserExist = userRegistration.findUserByemail(email);
		} catch (Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				//System.out.println("User Does not exist in DB");
				return false;
			}
		}

		return isuserExist;

	}
	

}
