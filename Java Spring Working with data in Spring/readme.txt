Getting MYSQL database using Maven

Maven dependencies:

<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.38</version>
</dependency>


<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>4.3.14.RELEASE</version>
</dependency>



	
<!-- 	START -- HARD CODED WAY -->
<!-- 	<bean id="myDriverDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> -->
<!-- 		<property name="driverClassName" value="com.mysql.jbdc.driver"/> -->
<!-- 		<property name="url" value="jbdc:mysql://localhost/any_database" /> -->
<!-- 		<property name="username" value="joe" /> -->
<!-- 		<property name="password" value="Password1234" /> -->
<!-- 	</bean> -->
	<!--  END -- HARD CODED WAY -->

	
	<!--  START -- Details in external file properties -->
	
	
	
<!-- 	<bean id="myDriverDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> -->
<!-- 		<property name="driverClassName" value="${dbDriver}"/> -->
<!-- 		<property name="url" value="${dbUrl}" /> -->
<!-- 		<property name="username" value="${dbUser}" /> -->
<!-- 		<property name="password" value="${dbPassword}" /> -->
<!-- 	</bean> -->
	<!--  END -- Details in external file properties -->


<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="com.mysql.jdbc.Driver"/>
		<property name="url" value="jdbc:mysql://localhost/springdemodb" />
		<property name="username" value="joe" />
		<property name="password" value="Password1234" />
	</bean>
