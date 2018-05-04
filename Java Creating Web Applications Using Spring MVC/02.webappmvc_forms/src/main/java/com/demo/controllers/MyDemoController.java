package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Account;

@Controller
public class MyDemoController {

	//http://localhost:8080/webappmvc/getQuote.html
	
	@RequestMapping(value="/createAccount")
	public String createAccount(@ModelAttribute ("aNewAccount") Account account)
	{
		System.out.println(account.getFirstName() + " "+ account.getLastName());
		
		return "createAccount";
	}
}
