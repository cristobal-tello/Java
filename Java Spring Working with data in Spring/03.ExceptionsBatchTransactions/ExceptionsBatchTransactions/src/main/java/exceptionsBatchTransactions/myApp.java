package exceptionsBatchTransactions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

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
	    
	    try
	    {
			FoodGroupDAO foodGroupDAO = appContext.getBean("foodGroupDAO", FoodGroupDAO.class);
		    
		    // Get all records
		    List<FoodGroup> foodGroupList = foodGroupDAO.getFoodGroups();
		    
		    for(FoodGroup fg: foodGroupList)
		    {
		    	System.out.println(fg.TalkAboutYourSelf());
		    }
	    }
	    catch(DataAccessException e)
	    {
	    	System.out.println(e.getMessage());
	    	System.out.println(e.getClass());
	    }
	    
	    
	    System.out.println("-------------------------------");
	    
	    FoodGroupDAO foodGroupDAO = appContext.getBean("foodGroupDAO", FoodGroupDAO.class);

	    FoodGroup a = new FoodGroup();
	    a.setName("any name1");
	    a.setDescription("any description1");
	    
	    FoodGroup b = new FoodGroup();
	    b.setName("any name2");
	    b.setDescription("any description2");
	    
	    FoodGroup c = new FoodGroup();
	    c.setName("any name3");
	    c.setDescription("any description3");
	    
	    FoodGroup d = new FoodGroup();		// If @Transactional("myTransactionManager") is enable in createFoodGroups, no records will be inserted
	    									// If not, any name1, 2 and 3 will be inserted
	    
	    d.setName("any name1");
	    d.setDescription("any description1");
	    
	    List<FoodGroup> myList = new ArrayList<FoodGroup>();
	    myList.add(a);
	    myList.add(b);
	    myList.add(c);
	    myList.add(d);
	    
	    int [] affectedRows = foodGroupDAO.createFoodGroups(myList);
	    
	    for(int n: affectedRows)
	    {
	    	System.out.println("Updated rows: " + n);
	    }
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}

}
