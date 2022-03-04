/**
 * 
 */
package edu.uvg.structures;

/**
 * 
 */
import java.util.Vector;

/**
 * @author chama
 *
 */
public class StackVector<T> implements IStack<T> {

    private Vector<T> coreVector;

    /**
     * Constructor of the Class
     */
    public StackVector() {
        coreVector = new Vector<T>();
    }

    /**
     * Insert a value in the Stack.
     * 
     * @param value is the value that will be inserted.
     */
    @Override
    public void push(T value) {
        coreVector.add(0, value);
    }

    /**
     * Remove the upper value in the Stack.
     * 
     * @return T
     */
    @Override
    public T pull() {
        return coreVector.remove(0);
    }

    /**
     * 
     * @return T this return the upper value in the Stack.
     */
    @Override
    public T peek() {
        return coreVector.get(0);
    }

    /**
     * 
     * @return this return the actual length of the stack, int value.
     */
    @Override
    public int count() {
        return coreVector.size();
    }

    /**
     * Verify if Stack is empty.
     * 
     * @return return true if is empty, else return false.
     */
    @Override
    public boolean isEmpty() {
        return coreVector.isEmpty();
    }

}
