[33mcommit 1e682dbc6621f4e104e03918f365ca719901a728[m[33m ([m[1;36mHEAD -> [m[1;32mmain[m[33m)[m
Author: chamale-rac <samuel.chamale23@gmail.com>
Date:   Fri Mar 4 17:40:31 2022 -0600

    Evaluate Postfix implemented

[1mdiff --git a/src/edu/uvg/patterns/ListInstanceCreator.java b/src/edu/uvg/patterns/ListInstanceCreator.java[m
[1mnew file mode 100644[m
[1mindex 0000000..0938c3d[m
[1m--- /dev/null[m
[1m+++ b/src/edu/uvg/patterns/ListInstanceCreator.java[m
[36m@@ -0,0 +1,21 @@[m
[32m+[m[32mpackage edu.uvg.patterns;[m
[32m+[m
[32m+[m[32mimport edu.uvg.structures.DoubleLinkedList;[m
[32m+[m[32mimport edu.uvg.structures.IList;[m
[32m+[m[32mimport edu.uvg.structures.MyList;[m
[32m+[m[32mimport edu.uvg.structures.SingleLinkedList;[m
[32m+[m
[32m+[m[32mpublic class ListInstanceCreator {[m
[32m+[m	[32mpublic IList<Character> getInstance(String ListType) {[m
[32m+[m		[32mIList<Character> uniqueList = null;[m[41m		[m
[32m+[m		[32mswitch(ListType) {[m
[32m+[m		[32mcase "1":[m[41m [m
[32m+[m			[32muniqueList = new DoubleLinkedList<Character>();[m
[32m+[m			[32mbreak;[m
[32m+[m		[32mcase "2":[m[41m [m
[32m+[m			[32muniqueList = new SingleLinkedList<Character>();[m
[32m+[m			[32mbreak;[m
[32m+[m		[32m}[m
[32m+[m		[32mreturn uniqueList;[m[41m		[m
[32m+[m	[32m}[m
[32m+[m[32m}[m
[1mdiff --git a/src/edu/uvg/patterns/StackInstanceCreator.java b/src/edu/uvg/patterns/StackInstanceCreator.java[m
[1mnew file mode 100644[m
[1mindex 0000000..500ce88[m
[1m--- /dev/null[m
[1m+++ b/src/edu/uvg/patterns/StackInstanceCreator.java[m
[36m@@ -0,0 +1,37 @@[m
[32m+[m[32m/**[m
[32m+[m[32m *[m[41m [m
[32m+[m[32m */[m
[32m+[m[32mpackage edu.uvg.patterns;[m
[32m+[m
[32m+[m[32mimport edu.uvg.structures.IStack;[m
[32m+[m[32mimport edu.uvg.structures.MyStack;[m
[32m+[m[32mimport edu.uvg.structures.StackArray;[m
[32m+[m[32mimport edu.uvg.structures.StackArrayList;[m
[32m+[m[32mimport edu.uvg.structures.StackVector;[m
[32m+[m
[32m+[m[32m/**[m
[32m+[m[32m * @author chama[m
[32m+[m[32m *[m
[32m+[m[32m */[m
[32m+[m[32mpublic class StackInstanceCreator {[m
[32m+[m[41m	[m
[32m+[m	[32mpublic IStack<String> getInstance(String StackType, int Size){[m
[32m+[m[41m		[m
[32m+[m		[32mIStack<String> uniqueStack;[m
[32m+[m[41m		[m
[32m+[m		[32mswitch(StackType) {[m
[32m+[m			[32mcase "1":[m[41m [m
[32m+[m				[32muniqueStack = new StackVector<String>();[m
[32m+[m				[32mbreak;[m
[32m+[m			[32mcase "2":[m[41m [m
[32m+[m				[32muniqueStack = new StackArray<String>(Size);[m
[32m+[m				[32mbreak;[m
[32m+[m			[32mdefault:[m[41m [m
[32m+[m				[32muniqueStack = new StackArrayList<String>();[m
[32m+[m				[32mbreak;[m
[32m+[m		[32m}[m
[32m+[m[41m			[m
[32m+[m		[32mreturn uniqueStack;[m[41m			[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/edu/uvg/program/Main.java b/src/edu/uvg/program/Main.java[m
[1mindex dfca642..a4402fe 100644[m
[1m--- a/src/edu/uvg/program/Main.java[m
[1m+++ b/src/edu/uvg/program/Main.java[m
[36m@@ -61,10 +61,6 @@[m [mpublic class Main {[m
         		System.out.println(e);[m
         	}[m
         }[m
[31m-		[m
[31m-		[m
[31m-        [m
[31m-[m
 	}[m
 [m
 }[m
[1mdiff --git a/src/edu/uvg/program/MyCalc.java b/src/edu/uvg/program/MyCalc.java[m
[1mnew file mode 100644[m
[1mindex 0000000..e4cc358[m
[1m--- /dev/null[m
[1m+++ b/src/edu/uvg/program/MyCalc.java[m
[36m@@ -0,0 +1,104 @@[m
[32m+[m[32m/**[m
[32m+[m[32m *[m[41m [m
[32m+[m[32m */[m
[32m+[m[32mpackage edu.uvg.program;[m
[32m+[m
[32m+[m[32mimport java.util.ArrayList;[m
[32m+[m[32mimport java.util.List;[m
[32m+[m
[32m+[m[32mimport edu.uvg.patterns.ListInstanceCreator;[m
[32m+[m[32mimport edu.uvg.patterns.SingletonException;[m
[32m+[m[32mimport edu.uvg.patterns.StackInstanceCreator;[m
[32m+[m
[32m+[m[32mimport edu.uvg.structures.MyStack;[m
[32m+[m[32mimport edu.uvg.structures.IList;[m
[32m+[m[32mimport edu.uvg.structures.IStack;[m
[32m+[m[32mimport edu.uvg.structures.MyList;[m
[32m+[m
[32m+[m[32m/**[m
[32m+[m[32m * @author chama[m
[32m+[m[32m *[m
[32m+[m[32m */[m
[32m+[m[32mpublic class MyCalc {[m
[32m+[m	[32mstatic boolean instance_flag = false;[m
[32m+[m[41m	[m
[32m+[m	[32mpublic MyCalc() throws SingletonException {[m
[32m+[m		[32mif (instance_flag)[m
[32m+[m			[32mthrow new SingletonException("Only one MyCalc allowed");[m
[32m+[m		[32melse[m[41m [m
[32m+[m			[32minstance_flag = true;[m
[32m+[m		[32mSystem.out.println("myCalc opened");[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mpublic String Calculate(String Expression, String StackType, String ListType) throws Exception {[m
[32m+[m		[32mExpression = Convert(Expression, ListType);[m
[32m+[m		[32mExpression = Evaluate(Expression, StackType);[m
[32m+[m		[32mreturn Expression;[m[41m		[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mpublic String Convert(String Expression, String ListType) {[m
[32m+[m		[32mListInstanceCreator myListCreator = new ListInstanceCreator();[m
[32m+[m		[32mIList<Character> myList = myListCreator.getInstance(ListType);[m
[32m+[m[41m		[m
[32m+[m[41m		[m
[32m+[m[41m		[m
[32m+[m		[32mreturn Expression;[m
[32m+[m[41m		[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mpublic String Evaluate(String Expression, String StackType) throws Exception {[m
[32m+[m		[32mStackInstanceCreator myStackCreator = new StackInstanceCreator();[m
[32m+[m		[32mIStack<String> myStack = myStackCreator.getInstance(StackType, Expression.split(" ").length);[m
[32m+[m[41m		[m
[32m+[m		[32m String[] separator=Expression.split("");[m
[32m+[m	[32m        String operators="";[m
[32m+[m	[32m        //Filtras el contenido del texto segun el tipo de caracte de psfix que tiene[m
[32m+[m	[32m        if(separator.length>5){[m
[32m+[m	[32m            for(int i = separator.length-1; i>=0;i-- ){[m
[32m+[m	[32m                String element=separator[i];[m
[32m+[m	[32m                if(element.equals("+")|element.equals("-")|element.equals("*")|element.equals("/")){[m
[32m+[m	[32m                    operators=operators+element;[m
[32m+[m	[32m                }else if(element.equals("0")|element.equals("1")|element.equals("2")|element.equals("3")|element.equals("4")|element.equals("5")|element.equals("6")|element.equals("7")|element.equals("8")|element.equals("9")){[m
[32m+[m	[32m                    myStack.push(element);[m
[32m+[m	[32m                }[m
[32m+[m	[32m            }[m
[32m+[m	[32m        }[m
[32m+[m	[32m        String[] operatorsList= operators.split("");[m
[32m+[m	[32m        float myCero = 0.0f;[m
[32m+[m[41m	        [m
[32m+[m	[32m        for(int i = operatorsList.length-1; i>=0;i-- ){[m
[32m+[m	[32m            float digit1=Float.parseFloat(myStack.peek());[m
[32m+[m	[32m            myStack.pull();[m
[32m+[m	[32m            float digit2= Float.parseFloat(myStack.peek());[m
[32m+[m	[32m            myStack.pull();[m
[32m+[m	[32m            float result=0;[m
[32m+[m	[32m            switch(operatorsList[i]){[m
[32m+[m	[32m                case "+":[m
[32m+[m	[32m                    result=digit1+digit2;[m
[32m+[m	[32m                    myStack.push(result+"");[m
[32m+[m	[32m                    break;[m
[32m+[m	[32m                case "-":[m
[32m+[m	[32m                    result=digit1-digit2;[m
[32m+[m	[32m                    myStack.push(result+"");[m
[32m+[m	[32m                    break;[m
[32m+[m	[32m                case "*":[m
[32m+[m	[32m                    result=digit1*digit2;[m
[32m+[m	[32m                    myStack.push(result+"");[m
[32m+[m	[32m                    break;[m
[32m+[m	[32m                case "/":[m
[32m+[m	[41m                [m	[32mif(digit2 == myCero) {[m
[32m+[m	[41m                [m		[32mthrow new Exception("Critical! 0 division.");[m
[32m+[m	[41m                [m	[32m}[m
[32m+[m	[32m                    result=digit1/digit2;[m[41m	[m
[32m+[m	[32m                    myStack.push(result+"");[m
[32m+[m	[32m                    break;[m
[32m+[m	[32m            }[m
[32m+[m	[32m        }[m
[32m+[m[41m	        [m
[32m+[m	[32m        return myStack.peek();[m
[32m+[m	[32m}[m
[32m+[m[41m	[m
[32m+[m	[32mpublic void finalize() {[m
[32m+[m		[32minstance_flag = false;[m
[32m+[m	[32m}[m
[32m+[m[32m}[m
[1mdiff --git a/src/edu/uvg/structures/DoubleLinkedList.java b/src/edu/uvg/structures/DoubleLinkedList.java[m
[1mindex d65d5f2..986d5b2 100644[m
[1m--- a/src/edu/uvg/structures/DoubleLinkedList.java[m
[1m+++ b/src/edu/uvg/structures/DoubleLinkedList.java[m
[36m@@ -132,7 +132,7 @@[m [mpublic class DoubleLinkedList<T> implements IList<T> {[m
             //doing the insertion[m
             pretemp.setNext(temp.getNext());[m
             pretemp.setPrevious(temp.getPrevious());[m
[31m-            count++;[m
[32m+[m[32m            count--;[m
             return temp.getValue();[m
         }[m
         else[m
[36m@@ -181,7 +181,7 @@[m [mpublic class DoubleLinkedList<T> implements IList<T> {[m
 			[m
 			else [m
 			{[m
[31m-				DoubleNode<T> temp = start;[m
[32m+[m				[32mDoubleNode<T> temp = end;[m
 				end = end.getPrevious();[m
 				count--;[m
 				return temp.getValue();				[m
[1mdiff --git a/src/edu/uvg/structures/MyList.java b/src/edu/uvg/structures/MyList.java[m
[1mnew file mode 100644[m
[1mindex 0000000..6e22859[m
[1m--- /dev/null[m
[1m+++ b/src/edu/uvg/structures/MyList.java[m
[36m@@ -0,0 +1,12 @@[m
[32m+[m[32m/**[m
[32m+[m[32m *[m[41m [m
[32m+[m[32m */[m
[32m+[m[32mpackage edu.uvg.structures;[m
[32m+[m
[32m+[m[32m/**[m
[32m+[m[32m * @author chama[m
[32m+[m[32m *[m
[32m+[m[32m */[m
[32m+[m[32mpublic abstract class MyList {[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/edu/uvg/structures/MyStack.java b/src/edu/uvg/structures/MyStack.java[m
[1mnew file mode 100644[m
[1mindex 0000000..74d9a2c[m
[1m--- /dev/null[m
[1m+++ b/src/edu/uvg/structures/MyStack.java[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m/**[m
[32m+[m[32m *[m[41m [m
[32m+[m[32m */[m
[32m+[m[32mpackage edu.uvg.structures;[m
[32m+[m
[32m+[m[32m/**[m
[32m+[m[32m * @author chama[m
[32m+[m[32m *[m
[32m+[m[32m */[m
[32m+[m[32mpublic abstract class MyStack {[m
[32m+[m
[32m+[m[41m	[m
[32m+[m[32m}[m
[1mdiff --git a/src/edu/uvg/structures/StackArray.java b/src/edu/uvg/structures/StackArray.java[m
[1mindex 051e60f..f399bf1 100644[m
[1m--- a/src/edu/uvg/structures/StackArray.java[m
[1m+++ b/src/edu/uvg/structures/StackArray.java[m
[36m@@ -43,7 +43,7 @@[m [mpublic class StackArray<T> implements IStack<T> {[m
 [m
 	@Override[m
 	public int count() {[m
[31m-		return coreArray.length;[m
[32m+[m		[32mreturn coreArrayTop + 1;[m
 	}[m
 [m
 	@Override[m
[1mdiff --git a/src/edu/uvg/structures/StackArrayList.java b/src/edu/uvg/structures/StackArrayList.java[m
[1mindex 94aa35c..4edc28c 100644[m
[1m--- a/src/edu/uvg/structures/StackArrayList.java[m
[1m+++ b/src/edu/uvg/structures/StackArrayList.java[m
[36m@@ -4,7 +4,6 @@[m
 package edu.uvg.structures;[m
 [m
 import java.util.ArrayList;[m
[31m-[m
 /**[m
  * @author moises.alonso[m
  *[m
