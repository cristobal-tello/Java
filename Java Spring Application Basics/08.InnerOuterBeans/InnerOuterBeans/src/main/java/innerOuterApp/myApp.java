package innerOuterApp;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    System.out.println("08. Inner and outer Beans sample:\n");
	    
	    Meal meal = appContext.getBean("unique_id_meal_cctor", Meal.class);
	    System.out.println("Spring meal: "+ meal.whatsInThisMeal());
	    
	    Meal meal2 = appContext.getBean("mealOuterBean", Meal.class);
	    System.out.println("Spring meal with apple: "+ meal2.whatsInThisMeal());
	    
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
