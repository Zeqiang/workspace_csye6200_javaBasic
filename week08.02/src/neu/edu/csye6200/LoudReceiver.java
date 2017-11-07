package neu.edu.csye6200;

import neu.edu.csye6200.API.SpeachReceiverAPI;

// Concrete class implementing SpeacherReceiverAPI interface
public class LoudReceiver implements SpeachReceiverAPI{
	
	private String message = null;

	public LoudReceiver(String msg) {
		message = msg;
	}

	@Override
	public void greeting() {
		System.out.println("hollaring hello".toUpperCase());
	}
	@Override
	public void speak() {
		System.out.println(message.toUpperCase());
	}
	@Override
	public void goodbye() {
		System.out.println("boisterous bye".toUpperCase());
	}

}
