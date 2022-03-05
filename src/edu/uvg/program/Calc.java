/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdt2;
//////////////////////////////////////////////
//	Universidad del Valle de Guatemala 
//	Algoritmos y estructuras de datos|Seccion 10
//		Daniel Armando Valdez Reyes|21240
//
//	Fecha: 4 de Marzo del 2022
///////////////////////////////////////////////
/**
 *
 * @author danar
 */
public class PosfixCalc implements IPosfixCalc {
    /**
     * Pila que guarda los datos del posfix
     */
    private StackArrayList<String> posfix;
    /**
     * Clase que se encarga de evaluar el posfix
     */
    public PosfixCalc() {
        this.posfix = new StackArrayList<String>();
    }
    /**
     * Metodo que evalua el valor que tiene el posfix mediante el uso de una pila
     * @param expresion texto en formato posfix
     * @return valor que evaluo del posfix
     */
    public float Evaluate(String expresion){
        String[] separator=expresion.split("");
        String operators="";
        boolean passed=false;
        //Filtras el contenido del texto segun el tipo de caracte de psfix que tiene
        if(separator.length>5){
            for(int i = separator.length-1; i>=0;i-- ){
                String element=separator[i];
                if(element.equals("+")|element.equals("-")|element.equals("*")|element.equals("/")){
                    operators=operators+element;
                }else if(element.equals("0")|element.equals("1")|element.equals("2")|element.equals("3")|element.equals("4")|element.equals("5")|element.equals("6")|element.equals("7")|element.equals("8")|element.equals("9")){
                    posfix.push(element);
                }
            }
        }
        String[] operatorsList= operators.split("");
        
        
        for(int i = operatorsList.length-1; i>=0;i-- ){
            float digit1=Integer.parseFloat(posfix.peek());
            posfix.pull();
            float digit2= Integer.parseFloat(posfix.peek());
            posfix.pull();
            float result=0;
            switch(operatorsList[i]){
                case "+":
                    result=digit1+digit2;
                    posfix.push(result+"");
                    break;
                case "-":
                    result=digit1-digit2;
                    posfix.push(result+"");
                    break;
                case "*":
                    result=digit1*digit2;
                    posfix.push(result+"");
                    break;
                case "/":
                    result=digit1/digit2;
                    posfix.push(result+"");
                    break;
            }
        }
        
        return Integer.parseFloat(posfix.peek());
        
    }
    
}
