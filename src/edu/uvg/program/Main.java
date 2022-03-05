/**
 * 
 */
package edu.uvg.program;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author chama
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		MyCalc myCalc = new MyCalc();
		TextFileManager myTxtReader = new TextFileManager();		
		Scanner myScanner = new Scanner(System.in);
		
	    boolean allCorrect = false;
		String FilePath, StackType = "", ListType = "", End;
		ArrayList<String> myDoc = new ArrayList<String>();        

        System.out.println("\n//INFIX CALC//"); 	
        
        
        boolean finishProgram = false;
        
        
        while(!finishProgram) {
        while(!allCorrect) {        	
		try {
			System.out.println("\nINSERT path of *.txt file:\n>> ");
			FilePath = myScanner.nextLine();
	        myDoc = myTxtReader.daReader(FilePath);
	        allCorrect = true;
		} catch (Exception e) {
			System.out.println(e);
		}
        }
        
        allCorrect = false;        
        while(!allCorrect) {          	
    		System.out.print("\nCHOOSE the Stack to be used:\r\n"
    				+ "1. StackVector\r\n"
    				+ "2. StackArray\r\n"
    				+ "3. StackArrayList\r\n"
    				+ ">> ");
    		StackType = myScanner.nextLine();
    		if(StackType.equals("1") || StackType.equals("2")|| StackType.equals("3")) {
    			System.out.println("Excellent! Stack selected correctly");
    			allCorrect = true;
    		} else {
    			System.out.println("Critical! Invalid option selected.");
    		}
        }
        
        allCorrect = false;        
        while(!allCorrect) {     		
    		System.out.print("\nCHOOSE the List to be used:\r\n"
    				+ "1. DoubleLinkedList\r\n"
    				+ "2. SingleLinkedList\r\n"
    				+ ">> ");
    		ListType = myScanner.nextLine();
    		if(ListType.equals("1") || ListType.equals("2")) {
    			System.out.println("Excellent! List selected correctly");
    			allCorrect = true;
    		} else {
    			System.out.println("Critical! Invalid option selected.");
    		}
        }	
        
        int i = 0;
        String result = "";
        for (String line : myDoc) {
        	try {
            result = myCalc.Calculate(line, StackType, ListType);
            
            i++;
            System.out.println("[LINE " + Integer.toString(i) + "] " + line + " = "
                    + result + "\n");
            
        	}  catch (Exception e) {
    			System.out.println(e);
    		}             
        }
        
        myDoc.clear();
        System.out.print("\nFinish the program? [Write 'y' to confirm]:\r\n"
				+ ">> ");
		End = myScanner.nextLine();		
		if(End.equals("y")) {
			finishProgram = true;
		}
		
        }
		
        System.out.print("Have a nice day!");
		
        

	}

}