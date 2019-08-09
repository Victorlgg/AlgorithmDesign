/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte1;

import java.util.ArrayList;
import java.util.Iterator;

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
    String Vector[];

    public void ordenar(String dirArchivo) throws FileNotFoundException, IOException, NoSuchElementException {
        String cadena;
        FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        cadena = datos.readLine();

        //System.out.println(cadena.length());
        String n = "";
        for (int it = 0; it < cadena.length(); it++) {

            if (Character.compare(cadena.charAt(it), ',') != 0) {
                n += "" + cadena.charAt(it);
                continue;
            }

            Valores.add(n);

            n = "";
        }

        Iterator iterador = Valores.iterator();
        Vector = new String[Valores.size()];
        System.out.println(Vector.length + " " + Valores.size());
        int i = 0;
//        while (iterador.hasNext()) {
//            System.out.print(iterador.next() + " ");
//        }

        for (Object nombre : Valores) {
            System.out.println(nombre.toString());
            Vector[i] = nombre.toString();
            i++;
        }

        Burbuja(Vector);
    }

    public String[] Burbuja(String[] Vector) {

        for (int i = 0, j = 0; i < Vector.length - 1 && j < Vector.length - 1; i++) {
            if (Integer.parseInt(Vector[i]) > Integer.parseInt(Vector[i + 1])) {
                String aux = Vector[i];
                Vector[i] = Vector[i + 1];
                Vector[i + 1] = aux;
            }
            if (i == Vector.length - 1) {
                j++;
                i = 0;
            }
        }
        for (String valor : Vector) {
            System.out.print(" " + valor);
        }
        return Vector;
    }
}
