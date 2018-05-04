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
		"No se tome la vida demasiado en serio; nunca saldra usted vivo de ella - Hubbard"
	};
	
	//	http://localhost:8080/webappmvc/getQuote?userName=Joe
	
	@RequestMapping(value="/getQuote")	// Simple mapping
	//@RequestMapping(value="/getQuote", params="from")		// Force the url includes 'from' param
	//@RequestMapping(value="/getQuote", params="!from")		// Force the url DON'T include 'from' param
	//@RequestMapping(value="/getQuote", params="from=cris")		// Force the url include 'from' param and the value needs to be Cris
	//@RequestMapping(value="/getQuote", headers="X-API-KEY")		// Headers need to contains X-API-KEY key. Use Modify Headers for Google Chrome extension
	//@RequestMapping(value="/getQuote", headers="X-API-KEY=77")		// Headers need to contains X-API-KEY key = 77. 
	//public String getRandomQuote(Model model)	// Simple method prototype
	//public String getRandomQuote(@RequestParam("userName") String userNameParam, Model model)		// A userName param is mandatory
	public String getRandomQuote(@RequestParam(value="userName", required = false) String userNameParam, Model model)		// A userName param IS NOT mandatory
	{
		int rand = new Random().nextInt(quotes.length);
		String randomQuote = quotes[rand];
		model.addAttribute("randomQuote", randomQuote);
		model.addAttribute("userName", userNameParam);
		
		
		return "quote";
	}
}