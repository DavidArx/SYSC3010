package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit2 {

		String message = "0101dataString";
	 
   TestedClass tested = new TestedClass(message);
   
   @Test
   public void testChooseReply() {	
      //System.out.println("Inside testConcateByteArray()"); 
		
      assertEquals("0377Invalid OpCode0", tested.chooseReply());
   }
}