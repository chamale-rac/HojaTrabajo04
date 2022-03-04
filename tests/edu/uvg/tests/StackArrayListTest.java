/**
 * 
 */
package edu.uvg.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.uvg.structures.StackArrayList;

/**
 * @author chama
 *
 */
class StackArrayListTest {
	@Test
	final void testPush() {
		StackArrayList<Integer> Stack = new StackArrayList<Integer>();
		Stack.push(1);
		assertEquals(1, Stack.peek());
	}

	@Test
	final void testPull() {
		StackArrayList<Integer> Stack = new StackArrayList<Integer>();
		Stack.push(1);
		Stack.pull();
		assertEquals(true, Stack.isEmpty());
	}
	@Test
	final void testPeek() {
		StackArrayList<Integer> Stack = new StackArrayList<Integer>();
		Stack.push(2);
		Stack.push(3);
		assertEquals(3, Stack.peek());
	}

	@Test
	final void testCount() {
		StackArrayList<Integer> Stack = new StackArrayList<Integer>();
		Stack.push(2);
		Stack.push(3);
		assertEquals(2, Stack.count());
	}

	@Test
	final void testIsEmpty() {
		StackArrayList<Integer> Stack = new StackArrayList<Integer>();
		Stack.push(1);
		assertEquals(false, Stack.isEmpty());
	}

}