package com.demo.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyDemoController {

	private String[] quotes = {
		"To be or not to be - Shakespeare",
		"Spring is nature's way of saying 'Let's party' - Robin Williams",
		"The is always right to do what is right - Martin Luther King",
		"Hay mucha gente que no cree en nada, pero que tiene miedo de todo - Hebbel",
		"No se tome la vida demasiado en serio; nunca saldrá usted vivo de ella - Hubbard"
	};
	
	//	http://localhost:8080/webappmvc/getQuote?userName=Joe
	
	@RequestMapping(value="/getQuote")
	public String getRandomQuote(Model model)
	{
		System.out.println("URL mapped successfully");
		int rand = new Random().nextInt(quotes.length);
		String randomQuote = quotes[rand];
		
		model.addAttribute("randomQuote", randomQuote);
		
		System.out.println("Model updated with random quote");
		
		return "quote";
	}
	
	// This method will be fired BEFORE getRandomQuote
	@ModelAttribute
	public void setUserDetails(@RequestParam ("userName") String userName, Model model)
	{
		model.addAttribute("userName", userName);
		
		String userRole = "undefined";
		
		if (userName.equals("Andy"))
		{
			userRole = "Student";
		}
		else if (userName.equals("Joe")) {
			userRole = "Teacher";
		}
		
		model.addAttribute("userRole", userRole);
		
		System.out.println("Model updated with user information");
	}
	
	
}
