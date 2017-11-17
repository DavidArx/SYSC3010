package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;



public class TestJunit1 {


   
   @Test
   public void testGetOpcode() {	
      //System.out.println("Inside testGetOpcode()");    
	  String message = "testMessage";	
	  TestedClass tested = new TestedClass(message);
      assertEquals("te", tested.getOpcode());     
      
	  message = "0";	
	  tested = new TestedClass(message);
      assertEquals("0", tested.getOpcode());   
   }
}