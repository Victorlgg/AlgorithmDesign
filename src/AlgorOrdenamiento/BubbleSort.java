/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorOrdenamiento;

/**
 *
 * @author Victor
 */
public class BubbleSort {
    
    public int[] Burbuja(String[] Vector) {
        int[] enteros= new int[Vector.length];
        int x=0;
        for(String valor : Vector){
            enteros[x]= Integer.parseInt(valor);
            x++;
        }
        
        for (int i = 0; i < enteros.length; i++) {
            for (int j = 0; j < enteros.length - 1; j++) {
                if ( enteros[j] > enteros[j + 1]) {
                    int aux = enteros[j];
                    enteros[j] = enteros[j + 1];
                    enteros[j + 1] = aux;
                }
            }
        }
        return enteros;
    }
    
}
