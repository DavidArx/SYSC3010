package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit5 {

		String message = "0101dataString0";
	 
   TestedClass tested = new TestedClass(message);
   
   @Test
   public void testChooseReply() {	
      //System.out.println("Inside testConcateByteArray()"); 
		
      assertEquals("0266", tested.chooseReply());
   }
}