package JunitDemo;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;



public class TestJunit1 {


   
   @Test
   public void testChooseReply() {
	   testChooseReplyCase1();
	   testChooseReplyCase2();
	   testChooseReplyCase3();
	   testChooseReplyCase4();
   }
   
   public void testGetOpcode() {	
	      //System.out.println("Inside testGetOpcode()");    
		  testGetOpcodeCase1();
		  testGetOpcodeCase2();
	   }
   
   
   public void testGetOpcodeCase1() {	
      //System.out.println("Inside testGetOpcode()");    
	  String message = "testMessage";	
	  TestedClass tested = new TestedClass(message);
      assertEquals("te", tested.getOpcode());     
     
   }
   public void testGetOpcodeCase2() {	
	      //System.out.println("Inside testGetOpcode()");    
		 
	      String  message = "0";	
	      TestedClass   tested = new TestedClass(message);
	      assertEquals("0", tested.getOpcode());   
	   }
   
   public void testChooseReplyCase1() {	
	   //System.out.println("Inside testConcateByteArray()"); 
	 	String message = "0101dataString0";
	 	String expected = "0266";
	 	TestedClass tested = new TestedClass(message);
	 	assertEquals(expected, tested.chooseReply());
   }
   
   public void testChooseReplyCase2() {
	 	String message = "hello";
	 	String expected = "0377Invalid OpCode0";
	 	TestedClass tested = new TestedClass(message);
	 	assertEquals(expected, tested.chooseReply());
   }
   public void testChooseReplyCase3() {
	 	String message = "0199dataString0";
	 	String expected = "0266";
	 	TestedClass tested = new TestedClass(message);
	 	assertEquals(expected, tested.chooseReply());
   }
   public void testChooseReplyCase4() {
	 	String message = "01abc0";
	 	String expected = "0377Invalid OpCode0";
	 	TestedClass tested = new TestedClass(message);
	 	assertEquals(expected, tested.chooseReply());
   }
  }
