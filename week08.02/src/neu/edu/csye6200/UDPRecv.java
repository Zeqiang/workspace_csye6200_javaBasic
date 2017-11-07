package neu.edu.csye6200;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JComponent;

import edu.neu.csye6200.api.AbstractRecv;
import edu.sti.util.TextAreaUpdaterTask;

public class UDPRecv extends AbstractRecv implements Runnable {
	public final static int DEFAULT_BUF_SIZE = 256;
	public final static int DEFAULT_PORT = 4445;
	private int rBufSize = DEFAULT_BUF_SIZE;
	private int port = 0;
	private TextAreaUpdaterTask<JComponent> guiUpdater = null;

	public UDPRecv()
	{
		super();
		this.port = DEFAULT_PORT;
	}

	public UDPRecv(int rBufSize, int port) {
		super();
		this.rBufSize = rBufSize;
		this.port = port;
	}

	public UDPRecv(TextAreaUpdaterTask<JComponent> task)
	{
		super();
		this.port = DEFAULT_PORT;
		this.guiUpdater = task;
	}

	@Override
	public StringBuffer recv() {
		return recv(port);
	}

	@Override
	public StringBuffer recv(int port) {
		return recvPacket(port);
	}

	public StringBuffer recvPacket(int port) {
		StringBuffer rDataSB = new StringBuffer("not a single byte!");
		try (DatagramSocket socket = new DatagramSocket(port)) {
			byte[] buf = new byte[DEFAULT_BUF_SIZE];
			DatagramPacket rPacket = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(rPacket);
				showPacket("Received from: ", rPacket);
				String rData = null;
				try {
					rData = new String(rPacket.getData(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rDataSB =  new StringBuffer(rData);
			} catch (IOException e) {
				System.err.println(UDPRecv.class.getName() + " socket.receive ERROR: '" + e.getMessage() + "'");
				e.printStackTrace();
			} finally {
				socket.close();
			}
		} catch (SocketException e) {
			System.err.println(UDPRecv.class.getName() + " DatagramSocket ERROR: '" + e.getMessage() + "'");
			e.printStackTrace();
		}

		return rDataSB;
	}

	private void showPacket(String title, DatagramPacket p) {
		String rData = null;
		try {
			rData = new String(p.getData(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(title + "IP Address: " + p.getAddress().toString() + ":" + "Port: " + p.getPort() + "\n"
				+ "'" + rData + "' ");
	}

	@Override
	public void run() {
		StringBuffer buf = null;
		buf = recv();
		System.out.println(buf);
		if (null != guiUpdater) {
			guiUpdater.setMessage(buf.toString());
			EventQueue.invokeLater(guiUpdater);
		}
	}
	
	public static void demo() {
		System.out.println("\n\n" + UDPRecv.class.getSimpleName() + ".demo()");
		Thread t1 = new Thread(new UDPRecv());
		t1.start();
//		UDPSend udpSend = new UDPSend();
//		udpSend.send("localhost", UDPRecv.DEFAULT_PORT, Driver.class.getSimpleName() +" just saying Hi!");
		Thread t2 = new Thread(new UDPSend());
		t2.start();
		
	}
}
