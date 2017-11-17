package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit6 {

		String message = "01abc0";
	 
   TestedClass tested = new TestedClass(message);
   
   @Test
   public void testChooseReply() {	
      //System.out.println("Inside testConcateByteArray()"); 
		String str = "0377Invalid OpCode0";
		
      assertEquals(str, tested.chooseReply());
   }
}