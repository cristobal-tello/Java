package innerOuterApp;

public class Apple extends Fruit {
	private String name;
	private String description = "not set yet";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String talkAboutYourSelf()
	{
		String result = super.talkAboutYourSelf();
		if (description!=null) result+= "\n" + description;
		return result;
	}
}
