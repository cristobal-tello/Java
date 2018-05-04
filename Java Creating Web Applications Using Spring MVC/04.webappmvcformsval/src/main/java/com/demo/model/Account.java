package com.demo.model;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;

// For validation, don't forget to add javax.validation on pom.xml

//<!-- https://mvnrepository.com/artifact/javax.validation/validation-api -->
//<dependency>
//<groupId>javax.validation</groupId>
//    <artifactId>validation-api</artifactId>
//<version>1.1.0.Final</version>
//</dependency>

// For 'email' validation, we need hibernate-validator on pom.xml
//<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
//<dependency>
//<groupId>org.hibernate</groupId>
//<artifactId>hibernate-validator</artifactId>
//<version>5.1.2.Final</version>
//</dependency>

public class Account {
	
	@Size(min=5, max=20)
	private String firstName;
	
	@Size(min=5, max=40)
	private String lastName;
	
	@Size(min=5, max=50)
	private String address;
	
	@NotNull @Email
	private String email;
	
	@NotNull @Min(18)
	private int age;

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
