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
        System.out.println("Mil");
        Arc.ordenar("./src/Texto/Mil.txt",1);
        Arc.ordenar("./src/Texto/Mil.txt",2);
        Arc.ordenar("./src/Texto/Mil.txt",3);
        
        System.out.println("Diez mil");
        Arc.ordenar("./src/Texto/diezMil.txt",1);
        Arc.ordenar("./src/Texto/diezMil.txt",2);
        Arc.ordenar("./src/Texto/diezMil.txt",3);
        
        System.out.println("Cien mil");
        Arc.ordenar("./src/Texto/cienMil.txt",1);
        Arc.ordenar("./src/Texto/cienMil.txt",2);
        Arc.ordenar("./src/Texto/cienMil.txt",3);
        
        System.out.println("Millon");
        Arc.ordenar("./src/Texto/Millon.txt",1);
        Arc.ordenar("./src/Texto/Millon.txt",2);
        Arc.ordenar("./src/Texto/Millon.txt",3);
        
    }

}
