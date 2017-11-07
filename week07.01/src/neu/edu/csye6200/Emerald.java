package neu.edu.csye6200;

import neu.edu.csye6200.API.AbstractGemStone;

public class Emerald extends AbstractGemStone{

	@Override
	public String color() {
		return "green";
	}

	@Override
	public double cost(double grams) {
		return 2.5 * grams;
	}
	
	@Override
	public String toString() {
		return "I am a "
				+ this.color()
				+ "Emerald "
				+ "With a Cost of : $"
				+ this.cost(1)
				+ " per gram";
	}
	
	public static void demo(){
		AbstractGemStone obj = new Emerald();
		Object object = obj;
		
		System.out.println(obj);
		System.out.println(object);
		
	}
}
