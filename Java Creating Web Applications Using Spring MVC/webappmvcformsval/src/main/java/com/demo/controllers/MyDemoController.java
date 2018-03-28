package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Account;

@Controller
public class MyDemoController {

	//http://localhost:8080/webappmvc/getQuote.html
	
	@RequestMapping(value="/createAccount")	// We added  @Valid tag and BindingResult result
	public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result)
	{
		if (result.hasErrors()) {
			System.out.println("Validation fails");
		}
		else {
			System.out.println(account.getFirstName() + " "+ account.getLastName());
		}
		
		return "createAccount";
	}
}
