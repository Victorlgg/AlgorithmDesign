/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte1;

/**
 *
 * @author Victor
 */
public class Recursividad {
    
    //Potencia
    public double Potencia(double b, double n){
        if(n==0){
            return 1;       
        }else{            
                return b*Potencia(b  ,n-1);               
        }
}
    
    public int Fibo(int a, int b){
        //System.out.println(a);
    if(a>2000){
        return 0;
    }else{
        return Fibo(b,a+b);
    }
        
        
    }
    
    //Factorial
    
    public int Factorial(int n){
        if(n==2){
            
            return n;
            
        }else{
            return Factorial(n-1)*n;
        }
        
        
    }
 
    
    
    
    
    
    
}
