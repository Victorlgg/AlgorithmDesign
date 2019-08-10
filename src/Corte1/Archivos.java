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
    FileWriter rutaNueva = null;
    String Vector[];

    public void ordenar(String dirArchivo) throws FileNotFoundException, IOException, NoSuchElementException {
        String cadena;
        FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        cadena = datos.readLine();
        datos.close();
        //System.out.println(cadena.length());
        String n = "";
        for (int it = 0; it < cadena.length(); it++) {
            if(Character.compare(cadena.charAt(it), ' ')==0){
                continue;
            }
            if (Character.compare(cadena.charAt(it), ',') != 0) {
                n += "" + cadena.charAt(it);
                if (it != cadena.length() - 1) {
                    continue;
                }
            }

            Valores.add(n);

            n = "";
        }

        //Iterator iterador = Valores.iterator();
        Vector = new String[Valores.size()];
        System.out.println(Vector.length + " " + Valores.size());
        int x = 0;
        for (Object nombre : Valores) {
            System.out.print( x%50==0 ? nombre.toString()+"\n": nombre.toString()+", ");
            Vector[x] = nombre.toString();
            x++;
        }

        rutaNueva = new FileWriter("./src/Texto/hola2.txt");
        Vector = Burbuja(Vector);
        
        for (int i = 0; i < Vector.length; i++) {
                rutaNueva.append(i!=Vector.length-1 ? Vector[i]+",": Vector[i]);
                
                
            }
            rutaNueva.close();
    }   

    public String[] Burbuja(String[] Vector) {

        for (int i = 0; i < Vector.length ; i++) {
            for (int j = 0; j < Vector.length - 1; j++) {
                 if(Integer.parseInt(Vector[j]) > Integer.parseInt(Vector[j+1])){
                     String aux=Vector[j];
                     Vector[j]= Vector[j+1];
                     Vector[j+1] = aux;
                 }   
            }
        }

//        for (String valor : Vector) {
//            System.out.print(" " + valor);
//        }
        return Vector;
    }
}
