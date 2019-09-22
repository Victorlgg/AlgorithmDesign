/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorOrdenamientoC1;

/**
 *
 * @author http://puntocomnoesunlenguaje.blogspot.com/2014/10/java-mergesort.html
 */
public class MergeSort {
    
    //MergeSort debe ser recursivo
    //Dividir el array a la mitad y esa mitad ordenarla
    ///Luego compararlos y crear el array ordenado
    //each list sorted si llega a 1
    //Divide and conquer
    //Log n merge steps O(n log n)
    public int[] mergeSort(int[] Vector, int Inicio, int Final) {

        if (Inicio < Final) {
            int m = (Inicio + Final) / 2;
            mergeSort(Vector, Inicio, m);
            mergeSort(Vector, m + 1, Final);
            mezclar(Vector, Inicio, m, Final);
        }

        return Vector;
    }

    public static void mezclar(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }
}
