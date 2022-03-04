/**
 * References
 * https://www.w3schools.blog/java-generic-stack-implementation
 * https://gist.github.com/simonjohn027/5d21e492a68e929b414706b76f08d4f1
 */

/**
 * 
 */
package edu.uvg.structures;

/**
 * @author chama
 *
 */
public class StackArray<T> implements IStack<T> {
	
	private T[] coreArray; 
	private int coreArraySize;
	private int coreArrayTop;
	
	public StackArray(int coreArraySize) {
			this.coreArraySize = coreArraySize;
			this.coreArray = (T[]) new Object[this.coreArraySize];
			this.coreArrayTop = -1;
	}
	
	@Override
	public void push(T value) {
		coreArray[++coreArrayTop] = value;
		
	}

	@Override
	public T pull() {
		return coreArray[coreArrayTop--];
	}

	@Override
	public T peek() {
		return coreArray[coreArrayTop];
	}

	@Override
	public int count() {
		return coreArrayTop + 1;
	}

	@Override
	public boolean isEmpty() {
		return coreArrayTop == -1 ? true : false;
	}

}
