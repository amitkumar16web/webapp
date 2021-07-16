package com.kaziranga.amit.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.kaziranga.amit.forms.RegistrationForm;
import com.kaziranga.amit.service.RegisterUser;

public class RegistrationFormvalidator {

	
	@Autowired
	private RegisterUser user;
	
public boolean valiadte(RegistrationForm registrationForm, Errors errors) {
		boolean isRejected= false;
		String nameRegex = "^[\\p{L} .'-]+$";
		Pattern namePattern = Pattern.compile(nameRegex,Pattern.CASE_INSENSITIVE);
	    Matcher nameMatcher = namePattern.matcher(registrationForm.getName());
	    if(!nameMatcher.find()) {
	    	errors.reject("name", "Name field is inavlid");
	    	return isRejected;
	    }
	   
	    String emailRegex= "^[e\\+]+[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[i,n]{2})$"; 
	    Pattern emailPattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
	    Matcher emailMatcher = emailPattern.matcher(registrationForm.getEmail());
	    if(!emailMatcher.find()) {
	    	errors.reject("email", "Email field is inavlid");
	    	return isRejected;
	    }
	    
	    
	    String passwordRegex= "^.{4,10}$";
	    Pattern passwordPattern = Pattern.compile(passwordRegex,Pattern.CASE_INSENSITIVE);
	    Matcher passwordMatcher = passwordPattern.matcher(registrationForm.getPassword_1());
	    if(!passwordMatcher.find()) {
	    	errors.reject("password", "Password length shold be 4-10");
	    	return isRejected;
	    }
	    
	    return true;
	    
	   }
	

	public boolean isUserAlredayRegistered(String email, Errors errors) {
		//System.out.println("checking user Alreday Exist or not");
		 if(user.finduser(email)) {
			 errors.reject("email", "A User With This Email Id is Alreday Registered");
			 return true;
		 }
		 
		 return false;
		
	}

}
