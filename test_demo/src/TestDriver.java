

public class TestDriver {
	
	
	public static void main( String args[] )
	{
		String serverArgs[] = {"555"};
		Server.main(serverArgs);
		//String clientArgs[] = {"127.0.0.1", "777"};
		//Client.main(args);
		ErrorSimulator s = new ErrorSimulator();
		
		
	}


}
