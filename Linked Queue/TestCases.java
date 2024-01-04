/*
  Test cases for LinkedQueue class.

  Compile: javac -d target -cp .:target:junit-platform-console-standalone-1.9.1.jar TestCases.java

  Run: java -jar junit-platform-console-standalone-1.9.1.jar --class-path target --select-class TestCases

*/

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class TestCases {
    String msg;
    String tst;


    public void setup() {
    }

    public void tearDown() {
    }

    /*
      Test the constructor.
      This test makes a queue and verifies that it is empty, 
      thereby testing the constructor AND the size() method.
    */
    @Test // This pragma is required before each test method.
    public void testConstructor0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing a new queue reports empty.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    assertEquals(q.isEmpty(),true);
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected an empty queue." + ex);
	}
    }
    

    @Test 
    public void testConstructor1() {

	msg = "Testing a new queue has size 0.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    assertEquals(q.size(),0);
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected an empty queue." + ex);
	}
    }

    @Test
    public void testEnqueue0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing enqueue reports a queue size of 1.";

	try {
			LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    assertEquals(q.size(),1);
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected a queue size of 1." + ex);
	}
    }
    
    @Test
    public void testEnqueue1() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing enqueue reports not empty.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    assertEquals(q.isEmpty(),false);
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected queue to not be empty." + ex);
	}
    }

    @Test
    public void testEnqueue2() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing enqueue returns accurate value in head";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    assertEquals(Double.valueOf(q.peek()), Double.valueOf(7.0));
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value in head." + ex);
	}
    }

    @Test
    public void testDequeue0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing dequeue returns accurate value.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    double test = Double.valueOf(q.dequeue());
	    assertEquals(Double.valueOf(test), Double.valueOf(7.0));
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }

    @Test
    public void testDequeue1() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing dequeue returns accurate value.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    double test;
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(67.5));
	    q.enqueue(Double.valueOf(14.54));
	    test = Double.valueOf(q.dequeue());
	    q.enqueue(Double.valueOf(44.3));
			test = Double.valueOf(q.dequeue());
			test = Double.valueOf(q.dequeue());
	    q.enqueue(Double.valueOf(85.42));
	    test = Double.valueOf(q.dequeue());

	    assertEquals(Double.valueOf(test), Double.valueOf(44.3));
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }

    @Test
    public void testPeek0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing peek returns accurate value.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(5.4));
	    double test = q.peek();
	    assertEquals(Double.valueOf(test), Double.valueOf(7.0));
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }

    @Test
    public void testToString0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing ToString returns correct string.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(3.4));
	    q.enqueue(Double.valueOf(14.54));
	    q.enqueue(Double.valueOf(85.42));
	    assertEquals(q.toString(), "7.0, 3.4, 14.54, 85.42");
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }

    @Test
    public void testToString1() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing ToString returns not null";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(3.4));
	    q.enqueue(Double.valueOf(14.54));
	    q.enqueue(Double.valueOf(85.42));
	    assertNotNull(q.toString());
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }

    @Test
    public void testToString2() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing peek returns accurate value.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(14.3));
	    
	    assertEquals(q.toString(), "7.0, 14.3"); // XX not specified format.
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }

    @Test
    public void testHasNext0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing hasNext returns accurate value.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(3.4));
	    Iterator<Double> iter = q.iterator();
	    assertTrue(iter.hasNext());
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected true." + ex);
	}
    }

    @Test
    public void testHasNext1() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing hasNext returns true in the middle of the list";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(3.4));
	    q.enqueue(Double.valueOf(14.54));
	    q.enqueue(Double.valueOf(85.42));
	    Iterator<Double> iter = q.iterator();
	    iter.next();
	    iter.next();
	    assertTrue(iter.hasNext());
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected true." + ex);
	}
    }

		@Test
    public void testHasNext2() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing hasNext returns false at last node.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(3.4));
	    q.enqueue(Double.valueOf(14.54));
	    q.enqueue(Double.valueOf(85.42));
	    Iterator<Double> iter = q.iterator();
	    iter.next();
	    iter.next();
	    iter.next();
	    assertTrue(!iter.hasNext()); // XX should be True!
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected false." + ex);
	}
    }

    @Test
    public void testNext0() { // Use "test" as the first four
	// characters of every testing method

	// The msg below explains the test and will be part of the output.
	msg = "Testing next returns accurate value.";

	try {
	    LinkedQueue<Double> q = new LinkedQueue<Double>();
	    q.enqueue(Double.valueOf(7.0));
	    q.enqueue(Double.valueOf(3.4));
	    q.enqueue(Double.valueOf(14.54));
	    q.enqueue(Double.valueOf(85.42));
	    Iterator<Double> iter = q.iterator();
	    assertEquals(Double.valueOf(iter.next()),Double.valueOf(3.4)); // XX should be 7.0
	    System.out.println("PASS: " + msg);
	} catch (AssertionError aex) {
	    fail("assertion error" + aex);  // assertion failed
	}
	catch (IllegalArgumentException ex) {
	    fail("Expected accurate value." + ex);
	}
    }
    
    
    // TODO: More tests.
    // Tests for enqueue
    // Tests for dequeue
    // Tests for peek
    // Tests for the iterator's various methods

} // end of TestCases

