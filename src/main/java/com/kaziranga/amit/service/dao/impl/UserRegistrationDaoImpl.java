package com.kaziranga.amit.service.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kaziranga.amit.forms.RegistrationForm;
import com.kaziranga.amit.service.dao.UserRegistration;
import com.kaziranga.amit.user.Student;

public class UserRegistrationDaoImpl implements UserRegistration {

	
	
	  @Autowired 
	  JdbcTemplate jdbcTemplate;
	  
	 	 
	@Override
	public int userRegistration(RegistrationForm registrationForm) {

		//System.out.println("name:" + registrationForm.getName());

		
		  return jdbcTemplate.update(
		  "insert into students (name,mobile,branch,sem,email,password) values(?,?,?,?,?,?)",
		  registrationForm.getName(), registrationForm.getMobile(), registrationForm.getBranch(), registrationForm.getSem(),
		  registrationForm.getEmail(), registrationForm.getPassword_1());
		 
	}
	
	
	
	
	 @Override
	    public Optional<Student> findUserByemailAndPassword(String email, String password) {
		         return jdbcTemplate.queryForObject(
	                "select * from students where email = ? and password = ?",
	                new Object[]{email, password},
	                (rs, rowNum) ->
	                        Optional.of(new Student(
	                                rs.getString("name"),
	                                rs.getString("mobile"),
	                                rs.getString("branch"),
	                                rs.getString("sem"),
	                                rs.getString("email"),
	                                rs.getString("password")
	                        ))
	        );
	    }
	 
	 
	 @Override
	    public boolean findUserByemail(String email) {
		         return jdbcTemplate.queryForObject(
	                "select * from students where email = ?",
	                new Object[]{email},
	                (rs, rowNum) ->{
	               if(rs.getRow()>0) {
	            	   return true;
	               }
	               return false;
	                        
	        
	                } );
	              }

	
	
	
	

}
