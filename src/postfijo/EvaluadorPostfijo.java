
package postfijo;

import java.util.ArrayList;

public class EvaluadorPostfijo {

//atributos
    public ArrayList <Integer> pila;  
    
 //constructor
    public EvaluadorPostfijo(){
        this.pila=new ArrayList<Integer>();
    }
    
    
public double EvaluacionPostfijo(String operacion) throws Unchecked{
  ArrayList <Double> pila = new ArrayList <Double>();
  Double numero = 0.0, numero2, resp = 0.0;
  char caracter;
  
  //for para recorrer toda la cadena
  for(int i=0;i<operacion.length();i++){
      caracter=operacion.charAt(i);
      
      //caso de que sea numero
      if(caracter!='+' && caracter!='-' && caracter!='*' && caracter!='/' && caracter!=' '){
          numero=Double.parseDouble((String.valueOf(caracter)));
          pila.add(numero);
          
      }
      else{//caso que sea operador
         numero2=pila.get(pila.size()-1);//peek
         pila.remove(pila.size()-1);//pop
         numero=pila.get(pila.size()-1);
         pila.remove(pila.size()-1);
         switch(caracter){
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
         pila.add(resp);
                   
      }
     
   }
  //para checar si cadena era correcta
  if(pila.size()!=1){
      throw new Unchecked("Cadena en formato incorrecto");
  }
  
  return pila.get(pila.size()-1);//peek
  

  
}    

public static void main(String args[]) throws Unchecked{
    EvaluadorPostfijo e=new EvaluadorPostfijo();
    String elemento="51+";
    
    e.EvaluacionPostfijo(elemento);
     
}

    
    
    
}

