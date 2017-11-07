package neu.edu.csye6200;

import neu.edu.csye6200.API.CommandAPI;
import neu.edu.csye6200.API.SpeachReceiverAPI;

public class LoudCommand implements CommandAPI{

	private SpeachReceiverAPI cmdReceiver;

	public LoudCommand(SpeachReceiverAPI loud) {
		// assign receiver for this command
		cmdReceiver = loud;
	}
	@Override
	public void execute() {
		// use Receiver API to perform a customized LoudReceiver execution
//		cmdReceiver.greeting();
		cmdReceiver.speak();
//		cmdReceiver.goodbye();
	}

}
