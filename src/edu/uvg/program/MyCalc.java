/**
 * 
 */
package edu.uvg.program;

import java.util.ArrayList;
import java.util.List;

import edu.uvg.patterns.ListInstanceCreator;
import edu.uvg.patterns.SingletonException;
import edu.uvg.patterns.StackInstanceCreator;

import edu.uvg.structures.MyStack;
import edu.uvg.structures.IList;
import edu.uvg.structures.IStack;
import edu.uvg.structures.MyList;

/**
 * @author chama
 *
 */
public class MyCalc {
	static boolean instance_flag = false;
	
	public MyCalc() throws SingletonException {
		if (instance_flag)
			throw new SingletonException("Only one MyCalc allowed");
		else 
			instance_flag = true;
		System.out.println("myCalc opened");
	}
	
	public String Calculate(String Expression, String StackType, String ListType) throws Exception {
		Expression = Convert(Expression, ListType);
		Expression = Evaluate(Expression, StackType);
		return Expression;		
	}
	
	public String Convert(String Expression, String ListType) {
		ListInstanceCreator myListCreator = new ListInstanceCreator();
		IList<Character> myList = myListCreator.getInstance(ListType);
		
		
		
		return Expression;
		
	}
	
	public String Evaluate(String Expression, String StackType) throws Exception {
		StackInstanceCreator myStackCreator = new StackInstanceCreator();
		IStack<String> myStack = myStackCreator.getInstance(StackType, Expression.split(" ").length);
		
		 String[] separator=Expression.split("");
	        String operators="";
	        //Filtras el contenido del texto segun el tipo de caracte de psfix que tiene
	        if(separator.length>5){
	            for(int i = separator.length-1; i>=0;i-- ){
	                String element=separator[i];
	                if(element.equals("+")|element.equals("-")|element.equals("*")|element.equals("/")){
	                    operators=operators+element;
	                }else if(element.equals("0")|element.equals("1")|element.equals("2")|element.equals("3")|element.equals("4")|element.equals("5")|element.equals("6")|element.equals("7")|element.equals("8")|element.equals("9")){
	                    myStack.push(element);
	                }
	            }
	        }
	        String[] operatorsList= operators.split("");
	        float myCero = 0.0f;
	        
	        for(int i = operatorsList.length-1; i>=0;i-- ){
	            float digit1=Float.parseFloat(myStack.peek());
	            myStack.pull();
	            float digit2= Float.parseFloat(myStack.peek());
	            myStack.pull();
	            float result=0;
	            switch(operatorsList[i]){
	                case "+":
	                    result=digit1+digit2;
	                    myStack.push(result+"");
	                    break;
	                case "-":
	                    result=digit1-digit2;
	                    myStack.push(result+"");
	                    break;
	                case "*":
	                    result=digit1*digit2;
	                    myStack.push(result+"");
	                    break;
	                case "/":
	                	if(digit2 == myCero) {
	                		throw new Exception("Critical! 0 division.");
	                	}
	                    result=digit1/digit2;	
	                    myStack.push(result+"");
	                    break;
	            }
	        }
	        
	        return myStack.peek();
	}
	
	public void finalize() {
		instance_flag = false;
	}
}
