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

/**
 *
 * @author Victor
 */
public class Archivos {

    ArrayList Valoress = new ArrayList();
    String valores[];

    public void ordenar(String dirArchivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        cadena = datos.readLine();
       
        //System.out.println(cadena.length());
        for (int it = 0; it <= cadena.length()-1; it++) {
            String n = "";
            if (Character.compare(cadena.charAt(it), ',')!=0) {
                n += cadena.charAt(it);
            }
            Valoress.add(n);
        }
        Iterator iterador = Valoress.iterator();

        while (iterador.hasNext()) {
            System.out.print(iterador.next() +" ");
        }

    }
}

    
    


