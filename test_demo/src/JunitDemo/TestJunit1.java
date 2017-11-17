package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit1 {

   String message = "testMessage";	
   TestedClass tested = new TestedClass(message);
   
   @Test
   public void testGetOpcode() {	
      //System.out.println("Inside testGetOpcode()");    
      assertEquals("te", tested.getOpcode());     
   }
}