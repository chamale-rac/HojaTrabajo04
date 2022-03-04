/**
 * 
 */
package edu.uvg.structures;

/**
 * @author moises.alonso
 *
 */
public interface IStack<T> {

	/**
	 * Insert a value in the Stack.
	 * 
	 * @param value is the value that will be inserted.
	 */
	void push(T value);

	/**
	 * Remove the upper value in the Stack.
	 * 
	 * @return
	 */
	T pull();

	/**
	 * 
	 * @return this return the upper value in the Stack.
	 */
	T peek();

	/**
	 * 
	 * @return this return the actual length of the stack, int value.
	 */
	int count();

	/**
	 * Verify if Stack is empty.
	 * 
	 * @return return true if is empty, else return false.
	 */
	boolean isEmpty();
}
