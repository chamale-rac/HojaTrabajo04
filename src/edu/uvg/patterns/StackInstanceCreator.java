/**
 * 
 */
package edu.uvg.patterns;

import edu.uvg.structures.IStack;
import edu.uvg.structures.MyStack;
import edu.uvg.structures.StackArray;
import edu.uvg.structures.StackArrayList;
import edu.uvg.structures.StackVector;

/**
 * @author chama
 *
 */
public class StackInstanceCreator {
	
	public IStack<Float> getInstance(String StackType, int Size){
		
		IStack<Float> uniqueStack;
		
		switch(StackType) {
			case "1": 
				uniqueStack = new StackVector<Float>();
				break;
			case "2": 
				uniqueStack = new StackArray<Float>(Size);
				break;
			default: 
				uniqueStack = new StackArrayList<Float>();
				break;
		}
			
		return uniqueStack;			
	}
	
}
