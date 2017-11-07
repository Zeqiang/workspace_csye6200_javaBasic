package neu.edu.csye6200;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Out out = new Out();
		out.useInner();	// use Outer method
		
		// MUST instantiate the inner class
		Outer.Inner inner = out.new Inner();
		inner.print();	// use Inner method
		
		//Anonymous Inner Class
		outCar car = new outCar(){
            public void drive(){ 
                System.out.println("Driving another car!"); 
            } 
        }; 
        car.drive(); //no meaning
	}

}
