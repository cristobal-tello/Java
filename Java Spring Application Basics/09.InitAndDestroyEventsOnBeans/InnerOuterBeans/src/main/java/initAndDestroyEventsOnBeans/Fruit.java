package initAndDestroyEventsOnBeans;

public class Fruit {
	private String description;
	
	public String talkAboutYourSelf()
	{
		return description;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public void initMethod()
	{
		System.out.println("Fruit ready to go. Description: "+ this.description);
	}
	
	public void destroyMethod()
	{
		System.out.println("This fruit will be destroyed");
	}
}
