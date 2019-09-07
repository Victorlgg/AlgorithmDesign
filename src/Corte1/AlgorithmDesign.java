/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class AlgorithmDesign {

    public static void casas(int size) {
        int casas = size;
        int suma1 = 0;
        int suma2 = 0;
        int posicion = 0;
        for (int i = 2; i < casas; i++) {
            posicion = i;
            suma1 = 0;
            suma2 = 0;
            //i-1 diferente resultado
            //6 y 35 vs 3 y 14
            for (int x = i - 1; x > 0; x--) {
                suma1 += x;
            }

            for (int j = i + 1; j <= casas; j++) {
                suma2 += j;
                if (suma2 == suma1) {
                    System.out.println("Suma:" + suma2 + ",  " + i);
                }
                if (suma2 > suma1) {
                    break;
                }
            }
            System.out.print(i % 10000 == 0 ? posicion + "\n" : "");
        }

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("1.Leer y ordenar archivo con burbuja"
                + "\n2.Métodos de ordenamiento."
                + "\n3.Sumar Casas"
                + "\n4.Maximos y minimos Divide y vencerás" //Segundo corte
                + "\n5.Multiplicar matrices Divide y vencerás" //Segundo Corte
        );
        int x = sc.nextInt();

        switch (x) {
            case 1:
                Archivos Arc = new Archivos();
                Arc.ordenar("./src/Texto/cincoMil.txt", 4);
                
                break;
            case 2:
                 Arc = new Archivos();
                System.out.println("1.Bubble 2.Quick, 3.Merge");
                System.out.println("Mil");
                Arc.ordenar("./src/Texto/Mil.txt", 1);
                Arc.ordenar("./src/Texto/Mil.txt", 2);
                Arc.ordenar("./src/Texto/Mil.txt", 3);

                System.out.println("Cinco mil");
                Arc.ordenar("./src/Texto/cincoMil.txt", 1);
                Arc.ordenar("./src/Texto/cincoMil.txt", 2);
                Arc.ordenar("./src/Texto/cincoMil.txt", 3);

                System.out.println("Diez mil");
                Arc.ordenar("./src/Texto/diezMil.txt", 1);
                Arc.ordenar("./src/Texto/diezMil.txt", 2);
                Arc.ordenar("./src/Texto/diezMil.txt", 3);
//        
                System.out.println("25 mil");
                Arc.ordenar("./src/Texto/ventiCincoMil.txt", 1);
                Arc.ordenar("./src/Texto/ventiCincoMil.txt", 2);
                Arc.ordenar("./src/Texto/ventiCincoMil.txt", 3);

                System.out.println("50 mil");
                Arc.ordenar("./src/Texto/cincuentaMil.txt", 1);
                Arc.ordenar("./src/Texto/cincuentaMil.txt", 2);
                Arc.ordenar("./src/Texto/cincuentaMil.txt", 3);

                System.out.println("75 mil");
                Arc.ordenar("./src/Texto/setentaCincoMil.txt", 1);
                Arc.ordenar("./src/Texto/setentaCincoMil.txt", 2);
                Arc.ordenar("./src/Texto/setentaCincoMil.txt", 3);

                System.out.println("Cien mil");
                Arc.ordenar("./src/Texto/cienMil.txt", 1);
                Arc.ordenar("./src/Texto/cienMil.txt", 2);
                Arc.ordenar("./src/Texto/cienMil.txt", 3);
//        System.out.println("Millon");
//        Arc.ordenar("./src/Texto/Millon.txt",1);
//        Arc.ordenar("./src/Texto/Millon.txt",2);
//        Arc.ordenar("./src/Texto/Millon.txt",3);
                    //Analisis de gráficas en Latex, explicacion de los metodos

                break;
            case 3:
                //Casas
                int size = sc.nextInt();
                casas(size);
                break;
               
            case 4:
                //DYV Maximo y minimo lista ordenada  -_> SEGUNDO CORTEEEAREQRA
                break;
                
            case 5: 
                //DYV  Multiplicar matrices  _--->SEGUNDO CORTEEEAREQRA
                break;
        }

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
        //Tambien estan los algoritmos quick y mergesort
        
        
        //https://es.stackoverflow.com/questions/26596/como-convertir-una-imagen-a-un-array-de-bytes-en-java

    }

}
