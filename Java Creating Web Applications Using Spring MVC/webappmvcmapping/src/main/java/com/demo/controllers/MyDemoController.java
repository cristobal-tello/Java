package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.Account;

@Controller
public class MyDemoController {

	@RequestMapping(value="/createAccount")
	public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account)
	{
		return "createAccount";
	}
	
	
	@RequestMapping(value="/accountCreated", method=RequestMethod.POST)
	public String performCreate(Account account)
	{
		System.out.println(account.getFirstName() + " " + account.getLastName());
		
		return "accountCreated";
	}
}
