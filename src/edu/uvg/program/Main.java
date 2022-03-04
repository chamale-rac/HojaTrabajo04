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

		TextFileManager myTxtReader = new TextFileManager();		
		Scanner myScanner = new Scanner(System.in);
		
	    boolean allCorrect = false;
		String FilePath;
		ArrayList<String> myDoc;        

        System.out.println("\n//INFIX CALC//"); 	
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
        	try {                
        		System.out.print("\nCHOOSE the Stack to be used:\r\n"
        				+ "1. StackVector\r\n"
        				+ "2. StackArray\r\n"
        				+ "3. StackArrayList\r\n"
        				+ ">> ");
        	} catch (Exception e) {
        		System.out.println(e);
        	}
        }
        
        allCorrect = false;        
        while(!allCorrect) {
        	try {      		
        		System.out.print("\nCHOOSE the List to be used:\r\n"
        				+ "1. DoubleLinkedList\r\n"
        				+ "2. SingleLinkedList\r\n"
        				+ ">> ");
        	} catch (Exception e) {
        		System.out.println(e);
        	}
        }
	}

}
