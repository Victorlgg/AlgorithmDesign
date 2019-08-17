/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte1;

import AlgorOrdenamiento.*;
import java.util.ArrayList;
//import java.util.Iterator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.NoSuchElementException;

/**
 *
 * @author Victor
 */
public class Archivos {

    ArrayList Valores = new ArrayList();
    FileWriter rutaNueva = null;
    //String Vector[];
    long startTime;
    long endTime;
    public void ordenar(String dirArchivo, int opcion) throws FileNotFoundException, IOException, NoSuchElementException {
        QuickSort S = new QuickSort();
        MergeSort M = new MergeSort();
        BubbleSort BS = new BubbleSort();
        FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        String cadena = datos.readLine();
        datos.close();
        lector.close();
        
        String n = "";

        String Vectorr[] = cadena.split(", ", -2);

        switch (opcion) {
            case 1:

//        Bubblesort
                int[] B = new int[Vectorr.length];
                int s = 0;
                for (String valor : Vectorr) {
                    B[s] = Integer.parseInt(valor);
                    s++;
                }
                startTime = System.nanoTime();
                B = BS.Burbuja(B);
                endTime = System.nanoTime() - startTime;
                System.out.println("Bubble: " + endTime / (Math.pow(10, 6)) +" ms");

//                for (int i = 0; i < Vector.length; i++) {
//                    if (i != Vector.length - 1) {
//                        n += Vector[i] + ",";
//                    } else {
//                        n += Vector[i];
//                    }
//                    //rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);                
//                }
//                rutaNueva = new FileWriter("./src/Texto/Burbuja.txt");
//                //rutaNueva.append(n);
//                rutaNueva.close();
                break;

            case 2:
                //        Quicksort
                int[] V = new int[Vectorr.length];
                int l = 0;
                for (String valor : Vectorr) {
                    V[l] = Integer.parseInt(valor);
                    l++;
                }
                startTime = System.nanoTime();
                V = S.QuickSort(V);
                endTime = System.nanoTime() - startTime;
                System.out.println("Quick: " + endTime / (Math.pow(10, 6))+" ms");

//                n = "";
//                for (int i = 0; i < V.length; i++) {
//
//                    if (i != V.length - 1) {
//                        n += V[i] + ",";
//                    } else {
//                        n += V[i];
//                    }
//                    //rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);                
//                }

//                rutaNueva = new FileWriter("./src/Texto/Quick.txt");
//                //rutaNueva.append(n);
//                rutaNueva.close();
                break;

            case 3:
                //Mergesort    
                int[] Merged = new int[Vectorr.length];
                int x = 0;
                for (String valor : Vectorr) {
                    Merged[x] = Integer.parseInt(valor);
                    x++;
                }
                startTime = System.nanoTime();
                Merged = M.mergeSort(Merged, 0, Merged.length - 1);
                endTime = System.nanoTime() - startTime;
                System.out.println("Merge: " + endTime / (Math.pow(10, 6)) +" ms");

//                n = "";
//                for (int i = 0; i < Merged.length; i++) {
//                    if (i != Merged.length - 1) {
//                        n += Merged[i] + ",";
//                    } else {
//                        n += Merged[i];
//                    }
                    //rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);                
//                }
                //rutaNueva = new FileWriter("./src/Texto/Merge.txt");
                //rutaNueva.append(n);
//                rutaNueva.close();
                break;
        }

    }

//    public String[] Burbuja(String[] Vector) {
//
//        for (int i = 0; i < Vector.length - 1; i++) {
//            for (int j = 0; j < Vector.length - 1; j++) {
//                if (Integer.parseInt(Vector[j]) > Integer.parseInt(Vector[j + 1])) {
//                    String aux = Vector[j];
//                    Vector[j] = Vector[j + 1];
//                    Vector[j + 1] = aux;
//                }
//            }
//        }
//        return Vector;
//    }

}
