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

	
	@Test
	final void testCalculate() throws Exception {
		MyCalc myCalc = new MyCalc();
		assertEquals(myCalc.Calculate("1+2*9", "1", "1"), "19.0");
		
		String convert =  myCalc.Convert("1+2*9", "1");
		String evaluate = myCalc.Evaluate("1 2 9 * +", "1");
		
		assertEquals(convert, "1 2 9 * + ");
		assertEquals(evaluate, "19.0");
	}
	
}


