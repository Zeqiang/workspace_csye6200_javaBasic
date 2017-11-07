package neu.edu.csye6200;

import neu.edu.csye6200.API.CommandAPI;

public class BackgroundInvoker implements Runnable {
	public CommandAPI cmd;
	
	public BackgroundInvoker(CommandAPI c) {
		cmd = c;
	}
	
	public void execute() {
		// invoke the command
//		this.cmd.execute();
		Thread t1 = new Thread(this);
		t1.start();
	}

	@Override
	public void run() {
		this.cmd.execute();
	}
}
