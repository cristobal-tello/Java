package beanPropertiesApp;

public class Vegetable {

	String vegetableName;
	
	public String getVegetableName() {
		return vegetableName;
	}

	public void setVegetableName(String vegetableName) {
		this.vegetableName = vegetableName;
	}

	public String talkAboutYourSelf()
	{
		return "Hi, I'm a VEGETABLE. I'm a plant that is eaten as food." + (vegetableName==null?"":"("+vegetableName+")");
	}
}
