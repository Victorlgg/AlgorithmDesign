/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package AlgorOrdenamientoC1;

/**
 *
 * @author Joe James en YT
 * //Selecciono un pivocte y dos punteros.
                //comparo los pivotes y si son de diferente tamaño se intercambian
                //si son iguales se intercambian con el pivote
                //Se realiza el mismo procedimiento en los vectores resultantes
                // Worst O(n^2), AVG 0(n log n), depende el pivote que seleccione
                //No seleccionar inicio o fin, -> Random
                //Clase aparte por el numero de metodos
        
 * 
 * 
 */
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    
        //QuickSort debe ser recursivo
    public int[] QuickSort(int[] Vector) {
        
        quickSort(Vector, 0,Vector.length-1);
        return Vector;
    }
    
    private void quickSort(int[]Vector, int low, int high){
        if(low<high+1){
            int p = partition(Vector,low,high);
            quickSort(Vector,low,p-1);
            quickSort(Vector,p+1,high);
        }
    }
    
    private void swap(int[] Vector, int inx1, int inx2){
        int temp= Vector[inx1];
        Vector[inx1]=Vector[inx2];
        Vector[inx2]=temp;
    }
    
    private int getPivot(int low, int high){
    Random rand = new Random();
    return rand.nextInt((high-low)+1)+low;
    }
    
    private int partition(int[] Vector, int low, int high){
        swap(Vector, low, getPivot(low,high));
        int border =low+1;
        for(int i=border;i<=high;i++){
            if(Vector[i]<Vector[low]){
                swap(Vector,i,border++);
            }
        }
        swap(Vector,low,border-1);
        
        return border-1;
    }
    
}
