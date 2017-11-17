import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.DatagramPacket;
import java.util.Arrays;
import java.util.Scanner;



public class ErrorSimulator {
	public static final int DEFAULT_HOST_PORT = 23, DEFAULT_SERVER_PORT = 69, PACKAGE_SIZE = 1000;
	public static boolean PRINT_PACKET = true;
	
	
	private DatagramSocket receiveSocket;
	private static DatagramPacket receivePacket;
	
	private static Scanner sc;
	
	//IP address of server
	private static InetAddress destinationAddress = null;

	public ErrorSimulator() {
		receiveSocket = UDPHelper.newSocket(DEFAULT_HOST_PORT);
	}
	
	public void receiveRequests() {
		System.out.println("Host waiting for request...");
		receivePacket = UDPHelper.newReceive(PACKAGE_SIZE);
		UDPHelper.receive(receiveSocket, receivePacket);
		//System.out.print("Received");
		System.out.print("    |Ip "+ receivePacket.getAddress());
		System.out.print("    |port "+ receivePacket.getPort());
		System.out.print("    |Opcode "+ ""+receivePacket.getData()[0]+ receivePacket.getData()[1]);
		System.out.println("    |BLK#"+ (-1));
		//clean printing//Utils.tryPrintTftpPacket(receivePacket);
		
		//System.out.println("Create new thread\n");
		//new Thread(new ErrorSimulatorThread(receivePacket, destinationAddress)).start();
	}	
	
	public static void main( String args[] ) {
	    		
		ErrorSimulator s = new ErrorSimulator();
		s.receiveRequests();
		receivePacket = UDPHelper.newReceive(PACKAGE_SIZE);
		new Thread(new ErrorSimulatorThread(receivePacket, destinationAddress)).start();
		
		while(true) {
			s.receiveRequests();
		}
	}
	

}