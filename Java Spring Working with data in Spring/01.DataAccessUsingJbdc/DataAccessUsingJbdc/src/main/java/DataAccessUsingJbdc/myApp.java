package DataAccessUsingJbdc;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.models.FoodGroup;
import com.models.FoodGroupDAO;

public class myApp {
	
	// In order to connect mySQL database, we need to add next dependencies
	//
	//<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
	//<dependency>
	//    <groupId>mysql</groupId>
	//    <artifactId>mysql-connector-java</artifactId>
	//    <version>5.1.38</version>
	//</dependency>
	//
	//
	//<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
	//<dependency>
	//    <groupId>org.springframework</groupId>
	//    <artifactId>spring-jdbc</artifactId>
	//    <version>4.3.14.RELEASE</version>
	//</dependency>
	
	//	<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
	//<dependency>
	//	<groupId>commons-dbcp</groupId>
	//	<artifactId>commons-dbcp</artifactId>
	//	<version>1.4</version>
	//</dependency>



	public static void main(String[] args) throws IOException {
	    
		  final String dir = System.getProperty("user.dir");
	        System.out.println("current dir = " + dir);
	        
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
	    FoodGroupDAO foodGroupDAO = appContext.getBean("foodGroupDAO", FoodGroupDAO.class);
	    
	    List<FoodGroup> foodGroupList = foodGroupDAO.getFoodGroups();
	    
	    for(FoodGroup fg: foodGroupList)
	    {
	    	System.out.println(fg.TalkAboutYourSelf());
	    }
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}

}
