package autoWiringByDefault;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    
		// If you take a look appContext.xml. Scope is set to singleton(default).
		// If you change the scope to Prototype, you will note the 'destroy' method is not call
		// Prototype means you as developer takes care how the instances are destroyed!!!!
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
	    
	    System.out.println("13. Auto wiring Default:\n");
	    
	    Meal meal = appContext.getBean("unique_id_meal", Meal.class);
	    System.out.println(meal.whatsInThisMeal());
	    
	    System.out.println("----");
	    
    	Meal mealAutoWired = appContext.getBean("mealAutoWiredDef", Meal.class);
    	System.out.println(mealAutoWired.whatsInThisMeal());
	    
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
