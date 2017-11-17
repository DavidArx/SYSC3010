package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit3 {

		String message = "01010";
	 
   TestedClass tested = new TestedClass(message);
   
   @Test
   public void testChooseReply() {	
      //System.out.println("Inside testConcateByteArray()"); 
		
      assertEquals("0266", tested.chooseReply());
   }
}