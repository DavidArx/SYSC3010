package JunitDemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   TestJunit1.class, TestJunit2.class, TestJunit3.class,TestJunit4.class,TestJunit5.class,TestJunit6.class
})

public class JunitTestSuite {
}