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
    //FileWriter rutaNueva = null;
    //String Vector[];

    public void ordenar(String dirArchivo) throws FileNotFoundException, IOException, NoSuchElementException {
        QuickSort S = new QuickSort();
        MergeSort M = new MergeSort();
        //String cadena;
        FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        String cadena = datos.readLine();

        datos.close();
        lector.close();
        String n = "";

        String Vectorr[] = cadena.split(", ");

//        Bubblesort
        long startTime = System.nanoTime();
        String[] Vector = Burbuja(Vectorr);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Bubble: " + endTime / (Math.pow(1, -6)));

        for (int i = 0; i < Vector.length; i++) {
            if (i != Vector.length - 1) {
                n += Vector[i] + ",";
            } else {
                n += Vector[i];
            }
            //rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);                
        }
        FileWriter rutaNueva = new FileWriter("./src/Texto/Burbuja.txt");
        rutaNueva.append(n);

//        Quicksort
        startTime = System.nanoTime();
        int[] V = S.QuickSort(Vectorr);
        endTime = System.nanoTime() - startTime;
        System.out.println("Quick: " + endTime / (Math.pow(1, -6)));

        n = "";
        for (int i = 0; i < V.length; i++) {
            
            if (i != V.length - 1) {
                n += V[i] + ",";
            } else {
                n += V[i];
            }
            //rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);                
        }

        rutaNueva = new FileWriter("./src/Texto/Quick.txt");
        rutaNueva.append(n);

        //Mergesort    
        startTime = System.nanoTime();
        int[] Merged = M.mergeSort(Vectorr, 0, Vectorr.length - 1);
        endTime = System.nanoTime() - startTime;
        System.out.println("Merge: " + endTime / (Math.pow(1, -6)));

        n = "";
        for (int i = 0; i < Merged.length; i++) {
            if (i != Merged.length - 1) {
                n += Merged[i] + ",";
            } else {
                n += Merged[i];
            }
            //rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);                
        }
        rutaNueva = new FileWriter("./src/Texto/Merge.txt");
        rutaNueva.append(n);
        rutaNueva.close();

    }

    public String[] Burbuja(String[] Vector) {

        for (int i = 0; i < Vector.length-1; i++) {
            for (int j = 0; j < Vector.length - 1; j++) {
                if (Integer.parseInt(Vector[j]) > Integer.parseInt(Vector[j + 1])) {
                    String aux = Vector[j];
                    Vector[j] = Vector[j + 1];
                    Vector[j + 1] = aux;
                }
            }
        }
        return Vector;
    }

}
