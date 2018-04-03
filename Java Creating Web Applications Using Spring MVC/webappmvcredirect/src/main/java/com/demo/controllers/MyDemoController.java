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
	public String createAccount(@ModelAttribute ("aNewAccount") Account account)
	{
		System.out.println("Create Account: " + account.getFirstName() + " "  + account.getLastName());
		
		return "createAccount";
	}
	
	
	@RequestMapping(value="/doCreate")
	public String doCreate(@ModelAttribute ("aNewAccount") Account account)
	{
		System.out.println("DoCreate: " + account.getFirstName() + " " + account.getLastName());
		
		//return "accountConfirmed";		// This way, if user "refresh" the page a the data is send again
		return "redirect:accConfirm";
	}
	
	@RequestMapping(value="/accConfirm")
	public String accountConfirmation(@ModelAttribute ("aNewAccount") Account account)
	{
		System.out.println("Account confirm: " + account.getFirstName() + " " + account.getLastName());
		
		return "accountConfirmed"; 
	}
			
}
