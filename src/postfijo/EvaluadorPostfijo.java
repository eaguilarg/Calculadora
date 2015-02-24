
package postfijo;

import java.util.ArrayList;
import java.util.Scanner;

public class EvaluadorPostfijo {

//atributos
    public ArrayList <Integer> pila;  
    
 //constructor
    public EvaluadorPostfijo(){
        this.pila=new ArrayList<>();
    }
    
 /*public String convierteTokens(String exp){
     ArrayList <String> A=new ArrayList();
     String s=""; 
     Character c;
     for(int i=0;i<exp.length();i++){
         c=exp.charAt(i);
         if(isDigit(c) || c=='.')
             s+=c+"";
         else{
             if(s!=""){
                 A.add(s);
                 s="";
             }
             if(isOperator(c))
                 A.add(c+"");
         }
     }
 }   
    */
    
public double EvaluacionPostfijo(String operacion) throws Unchecked{
  Pila pila = new  Pila();
  Double  numero , numero2, resp = null;
  char operador;
  Scanner lectura = new Scanner(operacion);
  String lector;
  //for para recorrer toda la cadena
  while(lectura.hasNext()){
      lector=lectura.next();
      operador=lector.charAt(0);
      
      //caso de que sea numero
      if(operador!='+' && operador!='-' && operador!='*' && operador!='/'){
          pila.push(Double.parseDouble(lector));
          
      } else{
          if(pila.isEmpty()){
              throw new Unchecked("Formato incorrecto");
          }
      //caso que sea operador
         numero2=(Double)pila.pop();
         numero=(Double)pila.pop();
         switch(operador){
             case '+':
                 resp=numero+numero2;
                 break;
             case '-':
                 resp=numero-numero2;
                 break;
             case '*':
                 resp=numero*numero2;
             case '/':
                 if(numero2!=0)
                     resp=numero/numero2;
                 else
                     throw new Unchecked("No se puede dividir entre cero");
                                  
         }
         pila.push(resp);
                   
      }
     
   }
  //para checar si cadena era correcta
  if(pila.size()!=1){
      throw new Unchecked("Formato incorrecto");
  }
  
  return (Double)pila.peek();
  
}    

public static void main(String args[]) throws Unchecked{
    EvaluadorPostfijo e=new EvaluadorPostfijo();
    String operador = "1 8 * 2 * 4 -";  
    String cadena="7 1 + 2 * 4 + ";

    System.out.print("= " + e.EvaluacionPostfijo(cadena)); 

    
    
     
}


    
    
}

