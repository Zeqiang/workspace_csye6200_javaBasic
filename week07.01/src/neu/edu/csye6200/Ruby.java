package neu.edu.csye6200;

import neu.edu.csye6200.API.AbstractGemStone;

public class Ruby extends AbstractGemStone {

	@Override
	public String color() {
		return "Red";
	}

	@Override
	public double cost(double grams) {
		return 5 * grams;
	}

	@Override
	public String toString() {
		return "I am a "
				+ this.color()
				+ "Ruby "
				+ "With a Cost of : $"
				+ this.cost(1)
				+ " per gram";
	}
	
	public static void demo(){
		AbstractGemStone obj = new Ruby();
		Object object = obj;
		
		System.out.println(obj);
		System.out.println(object);
		
	}
}
