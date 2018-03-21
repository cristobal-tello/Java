*** This project can be created using from Eclipse, from menu, File->New->Maven Project. Select maven-archetype-webapp artifact Id.

Add next dependencies:
spring-webmvc
javax.servlet-api (provided)
jst (provided)

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
  	<servlet-class>org.spring.framework.web.servlet.DispatcherServlet</servlet-class>
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
Create a class call MyDemoController

- Create view(s)


	
