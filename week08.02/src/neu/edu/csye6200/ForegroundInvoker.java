package neu.edu.csye6200;

import neu.edu.csye6200.API.CommandAPI;

public class ForegroundInvoker implements Runnable {

	public CommandAPI cmd;
	public ForegroundInvoker(CommandAPI c) {
		cmd = c;
	}
	
	public void execute() {
		// invoke the command
		this.cmd.execute();
	}

	@Override
	public void run() {
		this.execute();
	}

}
