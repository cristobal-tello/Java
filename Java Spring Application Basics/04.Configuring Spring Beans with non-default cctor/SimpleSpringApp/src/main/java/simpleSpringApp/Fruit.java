package simpleSpringApp;

public class Fruit {
	private String myName;
	
	public Fruit()
	{
	
	}
	
	public Fruit(String fruitName)
	{
		setMyName(fruitName);
	}
	
	public void setMyName(String myName)
	{
		this.myName = myName;
	}
	
	public String getMyName()
	{
		return myName;
	}
	
	public String talkAboutYourSelf()
	{
		return "Hi, I'm a FRUIT. I'm come from plants or trees with seeds." + (myName==null ? "" : "(" + myName +")");
		
	}
}
