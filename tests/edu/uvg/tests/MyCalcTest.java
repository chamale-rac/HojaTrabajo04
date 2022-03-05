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
	final void testCalculateWithParentesis() throws Exception {
		MyCalc myCalc = new MyCalc();
		System.out.println(myCalc.Convert("(1+2)*9", "1"));
	
	}
}
