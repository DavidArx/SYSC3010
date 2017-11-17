
import java.net.*;

public class Server {

	private final static int PACKETSIZE = 100 ;
	private static DatagramSocket socket;
	private static DatagramPacket sendPacket;
	private static DatagramPacket receivePacket;
	private static boolean quiteMode = false;
	static String portStr;
	static int blockNum = 0;
			
			
	public static void main( String args[] )
	{
	      if( args.length != 1 )
	      {
	         println( "server use default port: 777" ) ;
	         portStr  = "777";
	      }
	      else {
	    	  portStr = args[0] ;
	      }
		run();
    }
	
	

	
	public static void run()
	{
	      try
	      {
	    	 int port = Integer.parseInt( portStr ) ;
	         // Construct the socket
	         socket = new DatagramSocket( port ) ;

	         while(true)
	         {
		        println( "Server receiving on port " + port ) ;
	    		receivePacket = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	    	    socket.receive( receivePacket ) ;
	            println( "Server received: " + receivePacket.getAddress() + " " + receivePacket.getPort() + ": " + new String(receivePacket.getData()).trim() ) ;

	            //String message = "hi there";
	    		byte [] data = chooseReply();
	    		println( "Server reply: " + new String(data).trim());
	    		sendPacket = new DatagramPacket( data, data.length, receivePacket.getAddress(), receivePacket.getPort() ) ;
	    		println( "Server sending");
	    	    socket.send( sendPacket ) ;
	    	    println( "Server sent");
	    	    
	    		blockNum++;
	        }  
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
	      finally
	      {
	    	  stop();
	      }
	}
	
	public static byte[] chooseReply(){
		//String ending = new String(new byte[] {receivePacket.getData()[receivePacket.getData().length -1]});
		//println(ending);
		if (getOpcode().equals("01") && (receivePacket.getData()[receivePacket.getLength() -1] == 0))
		{
			String ACKstr = "0266";
			byte [] ACK = ACKstr.getBytes();
			return ACK;

		}
		else  //error case, wrong opcode or ending not zero byte
		{
			String startStr = "0377";
			byte [] start = startStr.getBytes();
			String messageStr = "Invalid OpCode";
			byte [] message = messageStr.getBytes();
			byte [] end = {0};
			return concateByteArray(concateByteArray(start, message), end);
		}
	}
	
	public static byte[] concateByteArray(byte[] a, byte[] b){
		byte[] c = new byte[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	
	
	public static String getOpcode(){
		//println( "getOpcode: "  +new String(new byte[] {receivePacket.getData()[0], receivePacket.getData()[1]}));
    	return new String(new byte[] {receivePacket.getData()[0], receivePacket.getData()[1]});
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
