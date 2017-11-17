package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit2 {



@Test
public void testChooseReply() {	
  //System.out.println("Inside testConcateByteArray()"); 
	String message = "0101dataString0";
	String expected = "0266";
	TestedClass tested = new TestedClass(message);
	assertEquals(expected, tested.chooseReply());
	
	message = "hello";
	expected = "0377Invalid OpCode0";
	tested = new TestedClass(message);
	assertEquals(expected, tested.chooseReply());
	
	message = "0199dataString0";
	expected = "0266";
	tested = new TestedClass(message);
	assertEquals(expected, tested.chooseReply());
	
	message = "01abc0";
	expected = "0377Invalid OpCode0";
	tested = new TestedClass(message);
	assertEquals(expected, tested.chooseReply());
	
}

}