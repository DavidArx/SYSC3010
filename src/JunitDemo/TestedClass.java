package JunitDemo;

/*
* This class prints the given message on console.
*/

public class TestedClass {

   private String message;
   private byte[] data;
   
   public TestedClass(byte[] data){
	      this.message = data.toString(); 
	      this.data = data;
	   }
   
   public TestedClass(String message){
	      this.message = message; 
	      this.data = message.getBytes();
	   }

	public String chooseReply(){
		//String ending = new String(new byte[] {receivePacket.getData()[receivePacket.getData().length -1]});
		//println(ending);
		if (getOpcode().equals("01") && (data[data.length -1] == '0'))
		{
			return "0266";

		}
		else  //error case, wrong opcode or ending not zero byte
		{
			String startStr = "0377";
			byte [] start = startStr.getBytes();
			String messageStr = "Invalid OpCode";
			byte [] message = messageStr.getBytes();
			byte [] end = {'0'};
			return startStr + messageStr + "0";
		}
	}
	


	
	public String getOpcode(){
		return new String(new byte[] {data[0], data[1]});
	}

	
}  