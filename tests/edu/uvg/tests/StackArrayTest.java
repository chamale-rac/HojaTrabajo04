/**
 * 
 */
package edu.uvg.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uvg.structures.StackArray;

/**
 * @author chama
 *
 */
class StackArrayTest {
	@Test
	final void testPush() {
		StackArray<Integer> Stack = new StackArray<Integer>(100);
		Stack.push(1);
		assertEquals(1, Stack.peek());
	}

	@Test
	final void testPull() {
		StackArray<Integer> Stack = new StackArray<Integer>(100);
		Stack.push(1);
		Stack.pull();
		assertEquals(true, Stack.isEmpty());
	}
	@Test
	final void testPeek() {
		StackArray<Integer> Stack = new StackArray<Integer>(100);
		Stack.push(2);
		Stack.push(3);
		assertEquals(3, Stack.peek());
	}

	@Test
	final void testCount() {
		StackArray<Integer> Stack = new StackArray<Integer>(100);
		Stack.push(2);
		Stack.push(3);
		assertEquals(2, Stack.count());
	}

	@Test
	final void testIsEmpty() {
		StackArray<Integer> Stack = new StackArray<Integer>(100);
		Stack.push(1);
		assertEquals(false, Stack.isEmpty());
	}

}