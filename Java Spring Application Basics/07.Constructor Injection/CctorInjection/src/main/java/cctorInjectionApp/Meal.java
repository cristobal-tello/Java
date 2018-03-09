package cctorInjectionApp;

public class Meal
{
	private Fruit fruit;
	private Dairy dairy;
	private Grain grain;
	private Meat meat;
	private Vegetable vegetable;
	
	public Meal()
	{
	
	}
	
	public Meal(Fruit f, Dairy d, Grain g, Meat m, Vegetable v)
	{
		this.fruit = f;
		this.dairy = d;
		this.grain = g;
		this.meat = m;
		this.vegetable = v;
	}
		
	public String whatsInThisMeal()
	{
		String output = "This meal contains:";
		
		if(fruit!=null) {
			output+="\nsome fruit...";
		}
		
		if(dairy!=null) {
			output+="\nsome dairy...";
		}
		
		if(grain!=null) {
			output+="\nsome grain...";
		}
		
		if(meat!=null) {
			output+="\nsome meat...";
		}
		
		if(vegetable!=null) {
			output+="\nsome vegetables...";
		}
		
		return output;
	}
	
}
