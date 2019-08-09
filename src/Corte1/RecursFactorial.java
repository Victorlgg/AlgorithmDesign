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
public class RecursFactorial {
    
    public int Factorial(int n){
        if(n==2){
            
            return n;
            
        }else{
            return Factorial(n-1)*n;
        }
        
        
    }
}
