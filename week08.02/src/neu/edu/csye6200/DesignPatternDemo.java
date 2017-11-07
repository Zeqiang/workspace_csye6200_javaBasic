package neu.edu.csye6200;

import java.util.ArrayList;
import java.util.List;

import neu.edu.csye6200.UDPRecv;
import neu.edu.csye6200.UDPSend;
//import neu.edu.csye6200.API.AbstractRecv;
//import neu.edu.csye6200.API.AbstractSend;
import neu.edu.csye6200.API.CruncherReceiverAPI;

public class DesignPatternDemo {

	public DesignPatternDemo() {
		// TODO Auto-generated constructor stub
	}

	public void useFactoryDemo() {
		CruncherFactory cFactory = new CruncherFactory();
		List<CruncherReceiverAPI> crunchers = new ArrayList<CruncherReceiverAPI>();
		List<String> criteria =  new ArrayList<String>();
		criteria.add("INTEGER");
		criteria.add("AVG");
		crunchers.add(cFactory.getNumberCruncher(criteria));
		criteria.clear();
		criteria.add("INTEGER");
		criteria.add("RANK");
		crunchers.add(cFactory.getNumberCruncher(criteria));
		criteria.clear();
		criteria.add("INTEGER");
		criteria.add("SUM");
		crunchers.add(cFactory.getNumberCruncher(criteria));
		criteria.clear();

		System.out.println(crunchers.size() +" Number Crunchers:");
		for (CruncherReceiverAPI c : crunchers) {
			c.execute();		// polymorphism: Superclass method overriden by subclass
		}
	}
	public void useCommandDemo() {
		// create receiver object complete with data needed for command
		LoudReceiver loudReceiver = new LoudReceiver("The Patriots Win!!");
		
		// create command object and bind with receiver
		LoudCommand loudCommand = new LoudCommand(loudReceiver);
		
		// create invoker and wrap a command object
		ForegroundInvoker loudInvoker = new ForegroundInvoker(loudCommand);
		
		// now (or at any time later) use the invoker object to perform the command
		loudInvoker.execute();
		
		SoftReceiver softReceiver = new SoftReceiver("The Patriots Lose.");
		SoftCommand softCommand = new SoftCommand(softReceiver);
		ForegroundInvoker	softInvoker	 = new ForegroundInvoker(softCommand);
		softInvoker.execute();
//		BackgroundInvoker	backgroundInvoker	 = new BackgroundInvoker(softCommand);
//		backgroundInvoker.execute();
	}
	
//	public void useUDPCommandDemo() {
//		System.out.println(DesignPatternDemo.class.getSimpleName() + ".useUDPCommandDemo()");
//		// create receiver object complete with data needed for command
//		AbstractRecv udpReceiver = new UDPRecv();
//		
//		// create command object and bind with receiver
//		ReceiveCommand udpRecvCommand = new ReceiveCommand(udpReceiver);
//		
//		// create invoker and wrap a command object
//		BackgroundInvoker udpRecvInvoker = new BackgroundInvoker(udpRecvCommand);
//		
//		// now (or at any time later) use the invoker object to perform the command
//		udpRecvInvoker.execute();
//		
//		AbstractSend udpSender = new UDPSend("The Patriots Win the SuperBowl!!!");
//		SendCommand udpSendCommand = new SendCommand(udpSender);
//		BackgroundInvoker	udpSendInvoker	 = new BackgroundInvoker(udpSendCommand);
//		udpSendInvoker.execute();
//
//	}
	
	static public void demo() {
		DesignPatternDemo obj =  new DesignPatternDemo();
		obj.useFactoryDemo();
		obj.useCommandDemo();
//		obj.useUDPCommandDemo();
	}
}
