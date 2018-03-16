package car;

import org.springframework.stereotype.Component;

@Component("fourCyl")
public class FourCylinderEngine implements Engine {

	@Overridce
	public int getNumberOfCylinders() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String drive() {
		return "Driving efficiently with 4 cylinders";
	}

}
