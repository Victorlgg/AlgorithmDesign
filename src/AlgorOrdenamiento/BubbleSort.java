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
    
    public int[] Burbuja(int[] Vector) {
        
           
        for (int i = 0; i < Vector.length; i++) {
            for (int j = 0; j < Vector.length - 1; j++) {
                if ( Vector[j] > Vector[j + 1]) {
                    int aux = Vector[j];
                    Vector[j] = Vector[j + 1];
                    Vector[j + 1] = aux;
                }
            }
        }
        return Vector;
    }
    
}
