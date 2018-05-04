*** This project can be created using from Eclipse, from menu, File->New->Maven Project. Select maven-archetype-webapp artifact Id.

Add next dependencies:
spring-webmvc
javax.servlet-api (provided)
javax.servlet » jstl (provided)

On pom.xml add next plugin in <build>
<plugins>
    <plugin>
      <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <source>1.6</source>
          <target>1.6</target>
        </configuration>
    </plugin>
</plugins>

Also, add Maven dependecies in project. Project properties, search for 'Deployment Assembly", click Add, Java Build Path Entries, Maven Dependencies.

- Configure web.xml, you need to put the servlets and the mapping
	<servlet>
	<servlet-mapping>

*** Change the web.xml with the next schema:

<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee" 
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
  http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  
  <display-name>My Demp App</display-name>

</web-app>

*** Configure our servlet config

<servlet>
  	<servlet-name>MyDemoApp</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<init-param>
  		<param-name>contextConfigLocation</param-name>
  		<param-value>/WEB-INF/config/myDemo-servletConfig.xml</param-value>
  	</init-param>
</servlet>
  
<servlet-mapping>
	<servlet-name>MyDemoApp</servlet-name>
	<url-pattern>*.html</url-pattern>
</servlet-mapping>

- Create a folder on webapp->web-inf. Create a folder 'config'. Inside 'config' folder create a new Spring Bean Definition file
 with 'myDemo-servletConfig.xml' name
 
 - Add xmlns:mvc="http://www.springframework.org/schema/mvc" in xml file

<mvc:annotation-driven/>
	
	<context:component-scan base-package="com.demo.controllers" />
	

- Create the controller(s)

Create a new package. Called 'com.demo.controllers'. Make sure you create the package in 'src/main/java. If not exist, just create it
Create a class call MyDemoController, like this

package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDemoController {

	//http://localhost:8080/webappmvc/getQuote.html
	
	@RequestMapping(value="/getQuote")
	public String getRandomQuote(Model model)
	{
		model.addAttribute("randomQuote", "To be or not to be - Shakespeare");
		
		return "quote";		// Name of the view, that is .jsp file
	}
}


- Create view(s)

In WEB-INF folder, create another folder 'jsp'. Create a jsp file inside with the name 'quote.jsp'.
Add next:

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My demo app</title>
</head>
<body>
<h1>The quote is:</h1>
<p>${randomQuote}</p>
</body>
</html>

- Resolview controller-view

On myDemo-servletConfig.xml add next:

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context-4.0.xsd
                           http://www.springframework.org/schema/mvc
                           http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd">
	
	<mvc:annotation-driven/>
	
	<context:component-scan base-package="com.demo.controllers" />
	
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="WEB-INF/jsp/" />
		<property name="suffix" value=".jsp" />
	</bean>

</beans>