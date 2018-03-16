package car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"car"})
public class AppConfig {

	@Bean(name="fourCyl")
	public FourCylinderEngine getFourCyl()
	{
		return new FourCylinderEngine();
	}
	
	@Bean(name="sixCyl")
	public SixCylinderEngine getSixCyl()
	{
		return new SixCylinderEngine();
	}
	
	//@Bean(name="familyCar")		// Uncoment this to use Injection using Java setter. I think you will need to comment Java cctor
	//public FamilyCar getFamilyCar()
	//{
	//		FamilyCar myCar = new FamilyCar();
	//		myCar.setEngineType(getSixCyl());		 
	//		
	//		return myCar;
	//}
	
	
//	@Bean(name="familyCar")		// Java cctor
//	public FamilyCar getFamilyCar()
//	{
//		FamilyCar myCar = new FamilyCar(getSixCyl());	// Injection using Java cctor, don't forget to comment custom cctor
//		return myCar;
//	}
	
//	@Bean(name="familyCar")	// Autowiring, don't forget to uncomment @Component on the top of the Class. Also Uncoment @Autowired in FamilyCar
//	public FamilyCar getFamilyCar()
//	{
//		FamilyCar myCar = new FamilyCar();
//		return myCar;
//	}

}

