package setterInjectionApp;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    System.out.println("06. Setter Injection sample:\n");
	    
	    Meal myNormalMeal = new Meal();
	    System.out.println("Normal meal: "+ myNormalMeal.whatsInThisMeal()); 	// As you will see, there is no meal!!!!
	    System.out.println("--");
	    
	    Meal mySpringMeal = appContext.getBean("unique_id_meal", Meal.class);
	    System.out.println("Spring meal: "+ mySpringMeal.whatsInThisMeal()); 	// As you will see, meal inside!!!!!
	    
	    System.out.println("--");
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
