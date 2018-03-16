package car;

import org.springframework.stereotype.Component;

@Component("sixCyl")
public class SixCylinderEngine implements Engine {

	@Override
	public int getNumberOfCylinders() {
		return 6;
	}

	@Override
	public String drive() {
		return "Driving crazy with 6 cylinders";
	}

}
