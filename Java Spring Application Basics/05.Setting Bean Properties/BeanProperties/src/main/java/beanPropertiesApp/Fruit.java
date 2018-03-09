package beanPropertiesApp;

import java.util.List;
import java.util.Map;

public class Fruit {
	private String myName;
	
	private List<String> listFruit;
	
	private Map<String, String> mapFruit;
	
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
		String outputString = "Hi, I'm a FRUIT. I'm come from plants or trees with seeds." + (myName==null ? "" : "(" + myName +")");
		
		if (listFruit!=null && listFruit.size() > 0)
		{
			outputString+="\nList:\n";
			for(int i=0;i<listFruit.size();i++) {
				outputString+=listFruit.get(i);
				outputString+="\n";
			}
		}
		
		if (mapFruit!=null && mapFruit.size() > 0)
		{
			outputString+="\nMap:\n";
			for(Map.Entry<String, String> fruitName : mapFruit.entrySet()) {
				outputString+=fruitName.getKey() + "==>" + fruitName.getValue();
				outputString+="\n";
			}
		}
		
		return outputString; 
	}

	public List<String> getListFruit() {
		return listFruit;
	}

	public void setListFruit(List<String> listFruit) {
		this.listFruit = listFruit;
	}

	public Map<String, String> getMapFruit() {
		return mapFruit;
	}

	public void setMapFruit(Map<String, String> mapFruit) {
		this.mapFruit = mapFruit;
	}
}
