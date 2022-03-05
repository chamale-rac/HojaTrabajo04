/**
 * 
 */
package edu.uvg.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uvg.program.MyCalc;

/**
 * @author chama
 *
 */
class MyCalcTest {

	/**
	 * Test method for {@link edu.uvg.program.MyCalc#finalize()}.
	 */
	@Test
	final void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.uvg.program.MyCalc#MyCalc()}.
	 */
	@Test
	final void testMyCalc() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.uvg.program.MyCalc#Calculate(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	final void testCalculate() throws Exception {
		MyCalc myCalc = new MyCalc();
		System.out.println(myCalc.Evaluate("1 2 9 * +", "1"));
		assertEquals(myCalc.Evaluate("1 2 9 * +", "1"), "19.0");
	}

	/**
	 * Test method for {@link edu.uvg.program.MyCalc#Convert(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testConvert() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link edu.uvg.program.MyCalc#Evaluate(java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testEvaluate() {
		fail("Not yet implemented"); // TODO
	}

}
