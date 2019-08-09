/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte1;

import java.io.IOException;

/**
 *
 * @author Victor
 */
public class AlgorithmDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Ctrl + shift + c para comentar fast
        
//        //Ejercicios Recursividad
//        Recursividad R = new Recursividad();
//        //Potencia
//        System.out.println(R.Potencia(2, 10));
//        //Fibonacci
//        R.Fibo(0,1);
//        //Factorial de un numero
//        System.out.println(R.Factorial(6));
        
        //Taller 2
        //Leer en un archivo posiciones donde cada valor está separado por una coma
        //guardarlos en un array y ordenarlos por medio de bubblesort y 
        //escribirlo ordenado en otro archivo
        
        Archivos Arc = new Archivos();
        Arc.ordenar("./src/Texto/hola.txt");
    }

}
