
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
  Mipila pila = new Mipila();
  Double numero = 0.0, numero2, resp = 0.0;
  char caracter;
  
  //for para recorrer toda la cadena
  for(int i=0;i<operacion.length();i++){
      caracter=operacion.charAt(i);
      
      //caso de que sea numero
      if(caracter!='+' && caracter!='-' && caracter!='*' && caracter!='/' && caracter!=' '){
          numero=Double.parseDouble((String.valueOf(caracter)));
          pila.push(numero);
          
      } else{
          if(pila.isEmpty()){
              throw new Unchecked("Formato incorrecto");
          }
      //caso que sea operador
         numero2=(Double)pila.pop();
         numero=(Double)pila.pop();
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
    String elemento="5 1 + 3 - 3 -";
    
    e.EvaluacionPostfijo(elemento);
     
}

    hola
    
    
}

