
package postfijo;
import java.util.ArrayList;
public class Pila <T>implements Mipila <T>  {

//atributos
    ArrayList <T> a=new ArrayList <T>();
    
//constructor
    public Pila(){
        
    }
    

 
 public T peek() {
     return a.get(a.size()-1);
 }
 public void push(T elemento){
     a.add(elemento);
        
 }
 public T pop(){
      T resp= peek();
      a.remove(a.size()-1);
      return resp;
 }
 
 public boolean isEmpty(){
       
     return a.isEmpty();
 }
 
 public int size(){
     return a.size();
 }
 
 
 public static void main(String[] args){
     Pila<Character> p=new Pila();
    String elemento="((()))";
 
    
   for(int i=0;i<elemento.length();i++){
     if(elemento.charAt(i)=='(')
        p.push(elemento.charAt(i));
        if(elemento.charAt(i)==')')
            p.pop();
    
    }
     if(p.isEmpty()==true)
         System.out.println("bien");
     else
         System.out.println("mal");
     
     
     //palindrome
     String palindrome="anitalavalatina";
     String n;
     boolean resp;
     for(int i=0;i<palindrome.length();i++)
         p.push(palindrome.charAt(i));

     StringBuilder Nuevo=new StringBuilder();
     for(int i=0;i<palindrome.length();i++)
        Nuevo.append(p.pop());
     
     System.out.println(Nuevo.toString());
     n=Nuevo.toString();
     
     if(palindrome.equals(n)){
         
         System.out.println("Si es palindrome");
     }
     else{
         
         System.out.println("No es palindrome");
     }
     
     
 }

    
 
    
    
    
    
    
}
