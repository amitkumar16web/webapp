package com.kaziranga.amit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kaziranga.amit.forms.LoginForm;

@Controller   //
public class QzlPageController {        // class name
	
	//-------------------------------------------------------------------
	
	@RequestMapping(method = RequestMethod.GET, value = "/qzlpage") // url values
	public String loingPage(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("emp")!= null && request.getSession().getAttribute("emp").equals(true)) {
		model.addAttribute("emp", request.getSession().getAttribute("emp"));
		model.addAttribute("name", request.getSession().getAttribute("name"));
		return "qzl";  // page name 
		}
		return "redirect:/";
	}
	
	//-------------------------------------------------------------- 

}
