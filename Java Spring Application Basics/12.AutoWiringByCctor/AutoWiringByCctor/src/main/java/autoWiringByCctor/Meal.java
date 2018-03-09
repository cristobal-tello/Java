package autoWiringByCctor;

import autoWiringByCctor.Dairy;
import autoWiringByCctor.Fruit;
import autoWiringByCctor.Grain;
import autoWiringByCctor.Meat;
import autoWiringByCctor.Vegetable;

public class Meal
{
	private Fruit fruit;
	private Dairy dairy;
	private Grain grain;
	private Meat meat;
	private Vegetable vegetable;
	
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
			output+="\n" + fruit.talkAboutYourSelf();
		}
		
		if(dairy!=null) {
			output+="\n" + dairy.talkAboutYourSelf();
		}
		
		if(grain!=null) {
			output+="\n" + grain.talkAboutYourSelf();
		}
		
		if(meat!=null) {
			output+="\n" + meat.talkAboutYourSelf();
		}
		
		if(vegetable!=null) {
			output+="\n" + vegetable.talkAboutYourSelf();
		}
		
		return output;
	}
	
}
