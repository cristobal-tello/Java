package autoValueAnnotation;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myApp {

	public static void main(String[] args) throws IOException {
	    
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
	    
	    System.out.println("03. Autovalue annotation:\n");
	    
	    Fruit fruit1 = appContext.getBean("unique_id_fruit", Fruit.class);
	    System.out.println(fruit1.talkAboutYourSelf());
	    
	    System.out.println("----");
	    
	    Fruit fruit2 = appContext.getBean("unique_id_fruit_annotation", Fruit.class);
	    System.out.println(fruit2.talkAboutYourSelf());
	    
	    System.out.println("----");
    	
	    ((ClassPathXmlApplicationContext) appContext).close();
	}
}
