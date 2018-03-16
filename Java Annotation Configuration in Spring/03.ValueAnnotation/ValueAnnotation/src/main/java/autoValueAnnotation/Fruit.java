package autoValueAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Fruit {
	private String description = "Not set yet";
	
	public String talkAboutYourSelf()
	{
		return this.description + ". From talkAboutYourSelf";
	}

	
	public String getDescription() {
		return this.description;
	}
	
	@Autowired
	public void setDescription(@Value("Description set using Annotations")String description) {
		this.description = description;
	}
}
