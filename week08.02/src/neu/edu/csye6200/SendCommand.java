package neu.edu.csye6200;

//import edu.neu.csye6200.api.AbstractSend;
import neu.edu.csye6200.API.CommandAPI;

public class SendCommand implements CommandAPI {

	private AbstractSend cmdReceiver;

	public SendCommand(AbstractSend sender) {
		// assign receiver for this command
		cmdReceiver = sender;
	}

	@Override
	public void execute() {
		// use AbstractRecv API to perform a customized send execution
		cmdReceiver.send();
	}

}
