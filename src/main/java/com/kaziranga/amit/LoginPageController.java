
package com.kaziranga.amit;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kaziranga.amit.forms.LoginForm;
import com.kaziranga.amit.forms.RegistrationForm;
import com.kaziranga.amit.service.RegisterUser;
import com.kaziranga.amit.user.Student;
import com.kaziranga.amit.validator.RegistrationFormvalidator;

@Controller
public class LoginPageController {     // class name

	@Autowired
	private RegisterUser user;
	
	@Autowired
	private RegistrationFormvalidator registrationFormvalidator;
	
	//--------------------------------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.GET, value = "/loginpage")  // pare or url rule for login
	public String loingPage(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("emp")!= null && request.getSession().getAttribute("emp").equals(true)) {
			return "redirect:/";
		}
		//System.out.println("welcome to login page");
		model.addAttribute("form" , new LoginForm());
		return "loginpage";
	}
	
    //--------------------------------------------------------------------------------	

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String loingPage(@ModelAttribute("form") LoginForm loginForm, Model model, HttpServletRequest request) {
		System.out.println("user is login with email:"+ loginForm.getEmail());
		
		Optional<Student> student =  user.finduser(loginForm.getEmail(), loginForm.getPassword_1());
		if(student != null && student.isPresent()) {
			request.getSession().setAttribute("emp", true);
			request.getSession().setAttribute("name", student.get().getName());
			model.addAttribute("emp", true);
			model.addAttribute("name", student.get().getName());
			return "page2";
		}
		model.addAttribute("errormessage" , "Email or pswd are incorrect");
		return "loginpage";
	}
	
	
	//--------------------------------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public String logOut(HttpServletRequest request) {
		System.out.println("user is being logout");
		Boolean isUserExist= (Boolean) request.getSession().getAttribute("emp");
		if(isUserExist != null && isUserExist.booleanValue()) {
			request.getSession().invalidate();
		}
		
		return "homepage";
	}
	
	//--------------------------------------------------------------------------------
	///register
	
	@RequestMapping(method = RequestMethod.GET, value = "/register") // pare or url rule for registrationPage
	public String registrationPage(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("emp")!= null && request.getSession().getAttribute("emp").equals(true)) {
			return "redirect:/";
	}
		System.out.println("welcome to register page");
		model.addAttribute("form" , new RegistrationForm());
		return "registrationPage";
	}
	
	
	//--------------------------------------------------------------------------------
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String registerUser(@ModelAttribute("form") RegistrationForm registrationForm, Errors errors,Model model, BindingResult bindingResult) {
		//boolean isformValidated= false;
		 registrationFormvalidator.valiadte(registrationForm, errors);
		 registrationFormvalidator.isUserAlredayRegistered(registrationForm.getEmail(), errors);
		if(!bindingResult.hasErrors()) {
		System.out.println("submit register form");
		int sucess= user.registerUser(registrationForm);
	//	System.out.println("name:"+ registrationForm.getName()+ "email" + registrationForm.getEmail()+ "pwd"+ registrationForm.getPassword_1());
		if(sucess== 1) {
			return "loginpage";
		}
		return "registrationPage";
		}
		model.addAttribute("errors",errors.getGlobalError().getDefaultMessage());
		return "registrationPage";
	}
	
	
	//--------------------------------------------------------------------------------
	
	
}

