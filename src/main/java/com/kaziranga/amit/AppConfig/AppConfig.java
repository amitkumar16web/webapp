package com.kaziranga.amit.AppConfig;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kaziranga.amit.service.RegisterUser;
import com.kaziranga.amit.service.dao.UserRegistration;
import com.kaziranga.amit.service.dao.impl.UserRegistrationDaoImpl;
import com.kaziranga.amit.service.impl.RegisterUserImpl;
import com.kaziranga.amit.validator.RegistrationFormvalidator;

@Configuration    // 
public class AppConfig {     // class name
	
	//------------------------------------------------------------------------------
	@Bean                    
	public RegisterUser user() {
		return new RegisterUserImpl();
		
	}
	
	//------------------------------------------------------------------------------
	
	@Bean
	public UserRegistration userRegistration() { 
		return new UserRegistrationDaoImpl();
		
	}
	
	//----------------------------------------------------------------------------------
	
	@Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource() 
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
       // dataSourceBuilder.url("jdbc:mysql://127.0.0.1:3307/csemajorproject?serverTimezone=IST");  // DB cnctn or DB NAME csemr time zone
       dataSourceBuilder.url("jdbc:mysql://127.0.0.1:3307/moglixtp?serverTimezone=IST");  // DB cnctn or DB NAME csemr time zone
       dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
	
	//--------------------------------------------------------------------------------------
	
	@Bean
	public JdbcTemplate jdbctemp() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource());
		return jdbcTemplate;
	}
	
    //-----------------------------------------------------------------------------------------
	
	@Bean
	public RegistrationFormvalidator registrationFormvalidator() {
		return new RegistrationFormvalidator();
	}
	
	//------------------------------------close---------------------------------------------
}   //-----------------------classs close--------------------------------------------------
