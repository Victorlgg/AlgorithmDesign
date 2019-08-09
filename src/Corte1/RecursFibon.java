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
public class RecursFibon {
    
    public int Fibo(int a, int b){
        System.out.println(a);
    if(a>2000){
        return 0;
    }else{
        return Fibo(b,a+b);
    }
        
        
    }
    
}
