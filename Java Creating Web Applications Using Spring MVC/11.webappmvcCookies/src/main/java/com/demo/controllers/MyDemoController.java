package com.demo.controllers;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyDemoController {
	
	@RequestMapping(value="/addCookie")
	public String addCookie(HttpServletResponse response)
	{
		response.addCookie(new Cookie("myCookie", "any value"));
		System.out.println("Cookie created");
		return "demoPage";
	}
	
	@RequestMapping(value="/getCookie")
	public String getCookie(@CookieValue("myCookie") String myCookie)
	{
		System.out.println("Cookie retrieved:" + myCookie);
		return "demoPage";
	}
}
