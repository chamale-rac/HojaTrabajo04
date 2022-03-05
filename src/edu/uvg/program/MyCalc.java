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
                Character[] chars= new Character[Expression.split(" ").length];
                int count=0;
                for(String cha: Expression.split(" ")){
                    chars[count]=cha.charAt(0);
                    count++;
                }
        
                Expression.split(" ");
                String expresion="";
                boolean parren=false;
                int content=0;
                int contentA=0;
                int contentAp=0;
                int contentBp=0;
                int contentB=0;
                for(Character cha: chars){
                    if(parren){
                        if(cha.equals("+")|cha.equals("-")){
                            myList.Insert(cha, contentA+contentB);
                            contentA++;
                            contentAp++;
                            
                        }else if(cha.equals("*")|cha.equals("/")){
                                myList.Insert(cha, contentB);
                                contentB++;
                                contentBp++;
                        }else if(cha.equals("0")|cha.equals("1")|cha.equals("2")|cha.equals("3")|cha.equals("4")|cha.equals("5")|cha.equals("6")|cha.equals("7")|cha.equals("8")|cha.equals("9")){
                            expresion=expresion+cha+" ";
                        } else if(cha.equals("(")){
                                parren=false;
                                while(contentBp>0&&contentAp>0){
                                    if(contentBp>0){
                                        expresion= expresion+myList.Get(contentB)+" ";
                                        myList.Delete(contentB);
                                        contentB--;
                                        contentBp--;
                                    }
                                    else if(contentAp>0){
                                        expresion= expresion+myList.Get(contentB+contentA)+" ";
                                        myList.Delete(contentB+contentA);
                                        contentA--;
                                        contentAp--;
                               
                                    }
                                    
                                }
                                
                        }
                    }
                    else if(cha.equals("+")|cha.equals("-")){
                            myList.Insert(cha, contentA+contentB);
                            contentA++;   
                    }else if(cha.equals("*")|cha.equals("/")){
                                myList.Insert(cha, contentB);
                                contentB++;
                    }else if(cha.equals("0")|cha.equals("1")|cha.equals("2")|cha.equals("3")|cha.equals("4")|cha.equals("5")|cha.equals("6")|cha.equals("7")|cha.equals("8")|cha.equals("9")){
                            expresion=expresion+cha+" ";
                    } else if(cha.equals("(")){
                        parren=true;
                    }
                }   
                while(contentB>0&&contentA>0){
                    if(contentB>0){
                        expresion= expresion+myList.Get(contentB)+" ";
                        myList.Delete(contentB);
                        contentB--;
                        
                        }
                    else if(contentA>0){
                        expresion= expresion+myList.Get(contentB+contentA)+" ";
                        myList.Delete(contentB+contentA);
                        contentA--;         
                    }
                                    
                }
		return Expression;
		
	}
	
	public String Evaluate(String Expression, String StackType) throws Exception {
		StackInstanceCreator myStackCreator = new StackInstanceCreator();
		IStack<Float> myStack = myStackCreator.getInstance(StackType, Expression.split(" ").length);
		
		float result;
		float valA;
		float valB;

	    char actualChar;

	    boolean haveValue;
	    boolean haveOperator;

	    List<Character> acceptedValues;
	    List<Character> acceptedOperators;
	    
	    result = 0f;
        valA = 0f;
        valB = 0f;

        actualChar = ' ';

        haveOperator = false;
        haveValue = false;

        acceptedValues = new ArrayList<>(
                List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        acceptedOperators = new ArrayList<>(
                List.of('*', '/', '+', '-'));
	        
		for (int i = 0; i <= Expression.length() - 1; i++) {

            result = 0;
            actualChar = Expression.charAt(i);
            haveValue = acceptedValues.contains(actualChar);
            haveOperator = acceptedOperators.contains(actualChar);

            if (haveValue || haveOperator) {
                if (haveValue) {
                	float f = Character.getNumericValue(actualChar);
                	myStack.push(f);
                }
                if (haveOperator) {
                    valA = 0;
                    valB = 0;

                    try {
                        valB = myStack.peek();
                        myStack.pull();
                        valA = myStack.peek();
                        myStack.pull();
                    } catch (Exception e) {

                        while (!myStack.isEmpty()) {
                        	myStack.pull();
                        }

                    	throw new Exception("Critical! Invalid Expression.");

                    }
                    switch (actualChar) {
                        case '+':
                        	myStack.push(valA + valB);
                            break;
                        case '-':
                        	myStack.push(valA - valB);
                            break;
                        case '/':
                            if (valB == 0) {
                                while (!myStack.isEmpty()) {
                                	myStack.pull();
                                } 

                                throw new Exception("Critical! 0 Division.");    
                            }
                            else {
                            	myStack.push(valA / valB);
                            }
                            break;
                            
                        case '*':
                        	myStack.push(valA * valB);
                            break;
                    }
                }
            } else if (actualChar != ' ') {
            	throw new Exception("Critical! Invalid Expression.");
            }

        }

        result = myStack.peek();
        while (!myStack.isEmpty()) {
        	myStack.pull();
        }
        return Float.toString(result);
	}
	
	public void finalize() {
		instance_flag = false;
	}
}
