package neu.edu.csye6200;

public abstract class Outer {

	int num = 1;
	
	// inner class
	public class Inner {
		
		public void print() {
			System.out.println("I am the inner class");
			System.out.println(this);
			System.out.println(Outer.this);
		}  // end method print()
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String a = "inner";
			return a;
		}
	} // end class Inner
	
	// Accessing the inner class from an outer class method
	public void useInner() {
		Inner inner = new Inner();
		inner.print();
	} // end method useInner()

}
