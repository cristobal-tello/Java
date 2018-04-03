package com.demo.controllers;

import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Account;

// I need to add a dependency to upload files
/*
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.1</version>
</dependency>
*/
@Controller
public class MyDemoController {

	@RequestMapping(value="/myForm", method=RequestMethod.GET)
	public String myForm()
	{
		return "myForm";
	}
	
	@RequestMapping(value="/handleForm")
	public String performCreate(@RequestParam("theFileNameToUpload") MultipartFile file)
	{
		try
		{
			if(!file.isEmpty())
			{
				
				byte [] bytes = file.getBytes();
				FileOutputStream fos = new FileOutputStream("c:\\temp\\" + file.getOriginalFilename());
				fos.write(bytes);
				fos.close();
				System.out.println("File saved succesfully");
			}
			else {
				System.out.println("Error: File is empty");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		
		return "operationCompleted";
	}
}
