/**
 * 
 */
package edu.uvg.patterns;

import edu.uvg.structures.*;

/**
 * @author chama
 *
 */
public class SingletonFactoryStack<T> {
	private static Stack uniqueStack;
	static boolean instance_flag = false;	
	
	public Stack StackInstanceCreator(String StackType, int Size) throws SingletonException {
		if (instance_flag)
			return uniqueStack;
		else 
			instance_flag = true;
			switch(StackType) {
				case "1": 
					uniqueStack = new StackVector<Integer>();
					break;
				case "2": 
					uniqueStack = new StackArray<Integer>(Size);
					break;
				case "3": 
					uniqueStack = new StackArrayList<Integer>();
					break;
			}
			return uniqueStack;
			
	}
	
	
}
