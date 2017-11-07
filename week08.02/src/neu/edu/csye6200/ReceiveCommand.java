package neu.edu.csye6200;

//import edu.neu.csye6200.api.AbstractRecv;
import neu.edu.csye6200.API.CommandAPI;

public class ReceiveCommand implements CommandAPI {

	private AbstractRecv cmdReceiver;

	public ReceiveCommand(AbstractRecv receiver) {
		// assign receiver for this command
		cmdReceiver = receiver;
	}

	@Override
	public void execute() {
		// use AbstractRecv API to perform a customized receive execution
		cmdReceiver.recv();
	}
}
