package neu.edu.csye6200;

import neu.edu.csye6200.API.CommandAPI;

public class SoftCommand implements CommandAPI {

	private SoftReceiver cmdReceiver;
	
	public SoftCommand(SoftReceiver soft) {
		// assign receiver for this command
		cmdReceiver = soft;
	}

	@Override
	public void execute() {
		// use Receiver API to perform a customized SoftReceiver execution
		cmdReceiver.greeting();
		cmdReceiver.speak();
		cmdReceiver.goodbye();
	}

}
