
package com.kaziranga.amit;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller             
public class HomePageController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		System.out.println("WELCOME TO HOME PAGE");
		model.addAttribute("emp", request.getSession().getAttribute("emp"));
		model.addAttribute("name", request.getSession().getAttribute("name"));
		
		return "homepage";
	}

}
