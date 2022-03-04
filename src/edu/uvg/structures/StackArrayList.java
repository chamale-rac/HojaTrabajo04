/**
 * 
 */
package edu.uvg.structures;

import java.util.ArrayList;
/**
 * @author moises.alonso
 *
 */
public class StackArrayList<T> implements IStack<T> {

	private ArrayList<T> coreList;

	/**
	 * Constructor of the Class
	 */
	public StackArrayList() {
		coreList = new ArrayList<T>();
	}

	/**
	 * Insert a value in the Stack.
	 * 
	 * @param value is the value that will be inserted.
	 */
	@Override
	public void push(T value) {
		coreList.add(0, value);
	}

	/**
	 * Remove the upper value in the Stack.
	 * 
	 * @return T
	 */
	@Override
	public T pull() {
		return coreList.remove(0);
	}

	/**
	 * 
	 * @return T this return the upper value in the Stack.
	 */
	@Override
	public T peek() {
		return coreList.get(0);
	}

	/**
	 * 
	 * @return this return the actual length of the stack, int value.
	 */
	@Override
	public int count() {
		return coreList.size();
	}

	/**
	 * Verify if Stack is empty.
	 * 
	 * @return return true if is empty, else return false.
	 */
	@Override
	public boolean isEmpty() {
		return coreList.isEmpty();
	}

}
