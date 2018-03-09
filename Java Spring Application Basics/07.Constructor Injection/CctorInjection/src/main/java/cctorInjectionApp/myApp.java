package cctorInjectionApp;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    System.out.println("07. Cctor Injection sample:\n");
	    Meal myNormalMeal = new Meal();
	    System.out.println("Normal meal: "+ myNormalMeal.whatsInThisMeal()); 	// As you will see, there is no meal!!!!
	    System.out.println("--");
	    
	    // There are 2 way to use cctor injection.
	    // Using index attribute on constructor-arg tag
	    // Or use name attribute on constructor-arg tag
	    
	    // Using index, check appContext.xml
	    Meal mySpringMeal = appContext.getBean("unique_id_meal", Meal.class);
	    System.out.println("Spring meal: "+ mySpringMeal.whatsInThisMeal());
	    
	    System.out.println("--");
	    
	    // Using index, check appContext.xml
	    Meal meal2 = appContext.getBean("mealOuterBean", Meal.class);
	    System.out.println("Spring meal cctor: "+ meal2.whatsInThisMeal());
	    
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
