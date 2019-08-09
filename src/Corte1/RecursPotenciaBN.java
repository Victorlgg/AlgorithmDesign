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
public class RecursPotenciaBN {
    
    public double Potencia(double b, double n){
        if(n==0){
            return 1;
            
        }else{
            
                return b*Potencia(b  ,n-1);
               
        }
    
       
    }
    
}
