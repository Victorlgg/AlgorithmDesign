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
public class AlgorithmDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ctrl + shift + c para comentar fast
        
        //Potencia
        Recursividad R = new Recursividad();
        System.out.println(R.Potencia(2, 10));

        
        //Fibonacci

        R.Fibo(0,1);

        
        //Factorial de un numero
        System.out.println(R.Factorial(6));
    }

}
