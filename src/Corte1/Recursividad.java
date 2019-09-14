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
 
    
        

        //Taller 2
        //Leer en un archivo posiciones donde cada valor está separado por una coma
        //guardarlos en un array y ordenarlos por medio de bubblesort y 
        //escribirlo ordenado en otro archivo
        //Tambien estan los algoritmos quick y mergesort
        
        
        //https://es.stackoverflow.com/questions/26596/como-convertir-una-imagen-a-un-array-de-bytes-en-java
        //https://www.tutorialspoint.com/How-to-convert-Image-to-Byte-Array-in-java
        
        //Ctrl + shift + c para comentar fast
//        //Ejercicios Recursividad
//        Recursividad R = new Recursividad();
//        //Potencia
//        System.out.println(R.Potencia(2, 10));
//        //Fibonacci
//        R.Fibo(0,1);
//        //Factorial de un numero
//        System.out.println(R.Factorial(6));
    
    
    
    
    
}
