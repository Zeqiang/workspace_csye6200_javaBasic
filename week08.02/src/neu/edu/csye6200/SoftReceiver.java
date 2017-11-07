package neu.edu.csye6200;

import neu.edu.csye6200.API.SpeachReceiverAPI;

//Concrete class implementing SpeachReceiver interface
public class SoftReceiver implements SpeachReceiverAPI {
	private String message = null;

	public SoftReceiver(String msg) {
		message = msg;
	}

	@Override
	public void greeting() {
		System.out.println("softspoken salute".toLowerCase());
	}
	@Override
	public void speak() {
		System.out.println(message.toLowerCase());
	}
	@Override
	public void goodbye() {
		System.out.println("faint farewell".toLowerCase());
	}

}
