package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.model.Account;

@Controller
@SessionAttributes("aNewAccount")
public class MyDemoController {

	// This project is very similar to webappmvcredirect
	// with a difference
	// In webappmvcredirect accountConfirmation method returns null.
	// In this project, the same method call automatically addAccountToModel method and aNewAccount it's saved
	
	@ModelAttribute
	public void addAccountToModel(Model model)
	{
		System.out.println("Making sure account object is on model");
		if(!model.containsAttribute("aNewAccount")) {
			Account a = new Account();
			model.addAttribute("aNewAccount", a);
		}
	}
	
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
		
		return "redirect:accConfirm";
	}
	
	@RequestMapping(value="/accConfirm")
	public String accountConfirmation(@ModelAttribute ("aNewAccount") Account account)
	{
		System.out.println("Account confirm: " + account.getFirstName() + " " + account.getLastName());
		
		return "accountConfirmed"; 
	}
			
}
