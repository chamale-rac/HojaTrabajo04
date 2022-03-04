/**
 * 
 */
package edu.uvg.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uvg.structures.StackVector;

/**
 * @author chama
 *
 */
class StackVectorTest {
	@Test
	final void testPush() {
		StackVector<Integer> Stack = new StackVector<Integer>();
		Stack.push(1);
		assertEquals(1, Stack.peek());
	}

	@Test
	final void testPull() {
		StackVector<Integer> Stack = new StackVector<Integer>();
		Stack.push(1);
		Stack.pull();
		assertEquals(true, Stack.isEmpty());
	}
	@Test
	final void testPeek() {
		StackVector<Integer> Stack = new StackVector<Integer>();
		Stack.push(2);
		Stack.push(3);
		assertEquals(3, Stack.peek());
	}

	@Test
	final void testCount() {
		StackVector<Integer> Stack = new StackVector<Integer>();
		Stack.push(2);
		Stack.push(3);
		assertEquals(2, Stack.count());
	}

	@Test
	final void testIsEmpty() {
		StackVector<Integer> Stack = new StackVector<Integer>();
		Stack.push(1);
		assertEquals(false, Stack.isEmpty());
	}

}
