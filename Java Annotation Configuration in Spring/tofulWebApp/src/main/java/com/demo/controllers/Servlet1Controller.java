package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Servlet1Controller {
		
	//	http://localhost:8080/tofulWebApp/getQuote.html
	
		@RequestMapping(value="/getQuote")
		public String getRandomQuote(Model model)
		{
			model.addAttribute("randomQuote", "To be or not to be - Shakespeare");
			
			return "quote";		// Name of the view, that is .jsp file
		}
}
