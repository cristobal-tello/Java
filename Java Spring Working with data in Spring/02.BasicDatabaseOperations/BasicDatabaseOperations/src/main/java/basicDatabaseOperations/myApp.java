package basicDatabaseOperations;

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
	    
	    // Get all records
	    List<FoodGroup> foodGroupList = foodGroupDAO.getFoodGroups();
	    
	    for(FoodGroup fg: foodGroupList)
	    {
	    	System.out.println(fg.TalkAboutYourSelf());
	    }
	    
	    System.out.println("-------------------------------");
	    
	    // Get a single record
	    FoodGroup f1 = foodGroupDAO.getFoodGroup(2);
	    System.out.println(f1.TalkAboutYourSelf());
	    
	    FoodGroup f2 = foodGroupDAO.getFoodGroup(4);
	    System.out.println(f2.TalkAboutYourSelf());
	    
	    // Insert a record, 1st option
	    System.out.println("-----------Insert a record, 1st option--------------------");
	    foodGroupDAO.addFoodGroup("Chucherías", "Cosas dulces con azucar");
	    foodGroupDAO.addFoodGroup("Fish", "Animals from rivers and sea");
	    
	    // Insert a record, 2nd option
	    System.out.println("-----------Insert a record, 2nd option--------------------");
	    FoodGroup foodGroup = new FoodGroup();
	    foodGroup.setName("any name");
	    foodGroup.setDescription("any description");
	    foodGroupDAO.addFoodGroup2(foodGroup);
	    
	    // Update a record
	    System.out.println("-----------Update a record--------------------");
	    FoodGroup foodGroup2 = new FoodGroup();
	    foodGroup2.setId(18);		// Id that I want to update
	    foodGroup2.setName("Name updated");	// New data to be replaced
	    foodGroup2.setDescription("Description updated");	// New data to be replaced
	    foodGroupDAO.updateFoodGroup(foodGroup2);
	    
	    // Delete a record
	    System.out.println("-----------Delete a record--------------------");
	    foodGroupDAO.delete(23);
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}

}
