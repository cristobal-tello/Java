package autoWiringConstructor;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
	    System.out.println("02. Autowiring Constructor:\n");
	    
	    Meal meal = appContext.getBean("unique_id_meal", Meal.class);
	    System.out.println(meal.whatsInThisMeal());
	    
	    System.out.println("----");
    	
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
