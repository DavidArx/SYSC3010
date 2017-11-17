import java.net.*;
import java.util.Scanner;




import java.net.*;

public class MockClient {

	private final static int PACKETSIZE = 100 ;
	private static DatagramSocket socket;
	private static DatagramPacket sendPacket;
	private static DatagramPacket receivePacket;
	
	private static boolean quiteMode = false;
	
	static String ipStr = "127.0.0.1";
	static String portStr = "777";
	static InetAddress host;
	static int port;
	
	
	public static void main( String args[] )
	{
		String ipStr;
		String portStr;
	      if( args.length != 2 )
	      {
	         println( "client use default ip and port" ) ;
	    	  ipStr = "127.0.0.1";
	    	  portStr = "777";
	      }
	      else {
	    	  ipStr = args[0];
	    	  portStr = args[1];
	      }
	      init(ipStr, portStr);
	      testCase1();
	      testCase2();
	      testCase3();
	      testCase4();
	      testCase5();
    }
	

	public static void init(String ipStr, String portStr)
	{
	      try
	      {
		         // Convert the arguments first, to ensure that they are valid
		         host = InetAddress.getByName( ipStr );
		         port         = Integer.parseInt( portStr );
		         socket = new DatagramSocket() ;
		         
		         /*
		         while(true){
		         		String message = "Hello";
		        		 byte [] data = message.getBytes();
		        		 sendPacket = new DatagramPacket( data, data.length, host, port ) ;
		        		 println( "Client sending");
		        		 socket.send( sendPacket ) ;
		        		 println( "Client sent");
		        		 		        		 
		        		 receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		        		 println( "Client receiving");
		        		 socket.receive( receivePacket ) ;
		        		 println( "Client received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;
		         }
		         */
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	}
	
	public static void checkOpcode(String expected, String actual){
		print( "expected: "+ expected) ;
		print( "actual: " +actual) ;
		 if (actual.equals(expected)) System.out.println(" - pass");
		 else System.out.println(" - fail");
	}
	
	public static byte[] concateByteArray(byte[] a, byte[] b){
		byte[] c = new byte[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	public static void testCase1()
	{
	      try
	      {
		         		String message = "0101dataString";
		         		String expectedOpcode = "02";
		         		
		    			byte [] start = message.getBytes();
		    			byte [] end = {0};		         		
		        		 byte [] data = concateByteArray(start, end);
		        		 
		        		 sendPacket = new DatagramPacket( data, data.length, host, port ) ;
		        		 println( "Client sending");
		        		 socket.send( sendPacket ) ;
		        		 println( "Client sent");
		        		 		 
		        		 receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		        		 println( "Client receiving");
		        		 socket.receive( receivePacket ) ;
		        		 println( "Client received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;
		        		 
		        		 System.out.print("test case 2: valid data '0101dataString' - ");
		        		 checkOpcode(expectedOpcode, getOpcode());		        		 
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	}
	
	public static void testCase2()
	{
	      try
	      {
		         		String message = "dataString";
		         		String expectedOpcode = "03";
		         		
		    			byte [] start = message.getBytes();
		    			byte [] end = {0};		         		
		        		 byte [] data = concateByteArray(start, end);
		         		
		        		 //byte [] data = message.getBytes();
		        		 sendPacket = new DatagramPacket( data, data.length, host, port ) ;
		        		 println( "Client sending");
		        		 socket.send( sendPacket ) ;
		        		 println( "Client sent");
		        		 		 
		        		 receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		        		 println( "Client receiving");
		        		 socket.receive( receivePacket ) ;
		        		 println( "Client received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;
		        		 println( "Client received: " + new String(receivePacket.getData()).trim() ) ;
		        		 
		        		 System.out.print("test case 1: invalid data 'dataString' - ");
		        		 checkOpcode(expectedOpcode, getOpcode());		        		 
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	}
	
	
	public static void testCase3()
	{
	      try
	      {
		         		String message = "0177dataString";
		         		String expectedOpcode = "03";
		         		
		    			byte [] data = message.getBytes();
		         		
		        		 sendPacket = new DatagramPacket( data, data.length, host, port ) ;
		        		 println( "Client sending");
		        		 socket.send( sendPacket ) ;
		        		 println( "Client sent");
		        		 		 
		        		 receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		        		 println( "Client receiving");
		        		 socket.receive( receivePacket ) ;
		        		 println( "Client received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;
		        		 
		        		 System.out.print("test case 3: missing ending 0 '0177dataString' - ");
		        		 checkOpcode(expectedOpcode, getOpcode());		        		 
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	}
	
	public static void testCase4()
	{
	      try
	      {
		         		String message = "9977dataString";
		         		String expectedOpcode = "03";
		         		
		    			byte [] start = message.getBytes();
		    			byte [] end = {0};		         		
		        		 byte [] data = concateByteArray(start, end);
		         		
		        		 //byte [] data = message.getBytes();
		        		 sendPacket = new DatagramPacket( data, data.length, host, port ) ;
		        		 println( "Client sending");
		        		 socket.send( sendPacket ) ;
		        		 println( "Client sent");
		        		 		 
		        		 receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		        		 println( "Client receiving");
		        		 socket.receive( receivePacket ) ;
		        		 println( "Client received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;
		        		 
		        		 System.out.print("test case 4: invalid OpCode '9977dataString' - ");
		        		 checkOpcode(expectedOpcode, getOpcode());		        		 
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	}
	
	public static void testCase5()
	{
	      try
	      {
		         		String message = "01XXdataString";
		         		String expectedOpcode = "03";
		         		
		    			byte [] start = message.getBytes();
		    			byte [] end = {0};		         		
		        		 byte [] data = concateByteArray(start, end);
		         		
		        		 //byte [] data = message.getBytes();
		        		 sendPacket = new DatagramPacket( data, data.length, host, port ) ;
		        		 println( "Client sending");
		        		 socket.send( sendPacket ) ;
		        		 println( "Client sent");
		        		 		 
		        		 receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
		        		 println( "Client receiving");
		        		 socket.receive( receivePacket ) ;
		        		 println( "Client received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;
		        		 
		        		 System.out.print("test case 5: invalid block number '01XXdataString' - ");
		        		 checkOpcode(expectedOpcode, getOpcode());		        		 
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	}
	

	
	public static String getOpcode(){
    	return new String(new byte[] {receivePacket.getData()[0], receivePacket.getData()[1]});
	}
	
	public int getBlockNum(){
		//invalid opcode
    	if (receivePacket.getData()[0] != (byte) 0) return -1;
    	//check block number
    	if (receivePacket.getData()[1] == (byte)3 || receivePacket.getData()[1] == (byte)4) {
	    	return ((int) Math.pow(2, 8))*unsignedToBytes(receivePacket.getData()[2]) + unsignedToBytes(receivePacket.getData()[3]);
    	}
    	return -1;
	}
	
	public byte[] intToByte(int value) {
	    return new byte[] {
	            (byte)(value >>> 8),
	            (byte)value};
	}
	
	  public int unsignedToBytes(byte b) {
		    return b & 0xFF;
		  }
	  
	
	
	public static void stop()
	{
  	  println ("Client closing down");
      if( socket != null ) socket.close() ;
    }
	
	public static void print(String str)
	{
  	  if (!quiteMode) System.out.print (str);
    }
	
	public static void println(String str)
	{
  	  if (!quiteMode) System.out.println (str);
    }
	
}
