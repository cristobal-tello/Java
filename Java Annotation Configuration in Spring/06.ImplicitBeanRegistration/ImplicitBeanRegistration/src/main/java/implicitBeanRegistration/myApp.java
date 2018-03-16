package implicitBeanRegistration;

import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import car.FourCylinderEngine;
import car.SixCylinderEngine;
import car.AppConfig;
import car.FamilyCar;

public class myApp {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("06. Implicit Bean Registration:\n");
	    
	    SixCylinderEngine sixCylinderEngine = appContext.getBean("sixCyl", SixCylinderEngine.class);
	    System.out.println("mySix: " + sixCylinderEngine.getNumberOfCylinders());
	    
	    System.out.println("----");
	    
	    FourCylinderEngine fourCylinderEngine = appContext.getBean("fourCyl", FourCylinderEngine.class);
	    System.out.println("myFour: " + fourCylinderEngine.getNumberOfCylinders());
	    
	    ((AnnotationConfigApplicationContext) appContext).close();
	}
}
