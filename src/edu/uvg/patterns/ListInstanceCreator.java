package edu.uvg.patterns;

import edu.uvg.structures.DoubleLinkedList;
import edu.uvg.structures.IList;
import edu.uvg.structures.MyList;
import edu.uvg.structures.SingleLinkedList;

public class ListInstanceCreator {
	public IList<Character> getInstance(String ListType) {
		IList<Character> uniqueList = null;		
		switch(ListType) {
		case "1": 
			uniqueList = new DoubleLinkedList<Character>();
			break;
		case "2": 
			uniqueList = new SingleLinkedList<Character>();
			break;
		}
		return uniqueList;		
	}
}
