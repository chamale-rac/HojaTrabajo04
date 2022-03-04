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
	
	public IStack<String> getInstance(String StackType, int Size){
		
		IStack<String> uniqueStack;
		
		switch(StackType) {
			case "1": 
				uniqueStack = new StackVector<String>();
				break;
			case "2": 
				uniqueStack = new StackArray<String>(Size);
				break;
			default: 
				uniqueStack = new StackArrayList<String>();
				break;
		}
			
		return uniqueStack;			
	}
	
}
