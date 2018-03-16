package car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FamilyCar {
	
	//@Autowired
	//@Qualifier("fourCyl")
	// You can use the same on the setter but not both at same time, when Autowire is in the set, is considered injection  
	private Engine engineType;
	
	public Engine getEngineType()
	{
		return this.engineType;
	}
	
	public FamilyCar() {
	
	}
	
	public FamilyCar(Engine engineType)
	{
		this.engineType = engineType;
	}
	
	public void setEngineType(Engine engineType)
	{
		this.engineType = engineType;
	}
	
	public String getCarDescription() {
		String description = "";
		
		if(engineType!=null) {
			description+="Engine type: " + engineType.getNumberOfCylinders();
			if (description=="") {
				description = "not set";
			}
		}
		
		return description;
	}

}
