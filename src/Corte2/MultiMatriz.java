/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

/**
 *https://stackoverflow.com/questions/21496538/square-matrix-multiply-recursive-in-java-using-divide-and-conquer
 * @author BOG-A313-E-012
 */
public class MultiMatriz {
public static int[][] matrixMultiplicationFinal(int[][] A, int[][] B){

    return  matrixMultiplication(
            A, B, 0, 0, 
            0,0, A.length);

}


public static int[][] matrixMultiplication(
        int[][] A, int[][] B, int rowA, int colA, 
        int rowB, int colB, int size){

    int[][] C= new int[size][size];

    if(size==1)
        C[0][0]= A[rowA][colA]*B[rowB][colB];

    else{

        int newSize= size/2;
        //C11
         sumMatrix(C, 

            matrixMultiplication(A, B, rowA, colA, rowB, colB, newSize),
            matrixMultiplication(A, B, rowA, colA+newSize, rowB+ newSize, colB, newSize),
        0, 0);

         sumMatrix(C, 

            matrixMultiplication(A, B, rowA, colA, rowB, colB + newSize, newSize),
            matrixMultiplication(A, B, rowA, colA+newSize, rowB+ newSize, colB+newSize, newSize),
        0, newSize);

         sumMatrix(C, 

            matrixMultiplication(A, B, rowA+ newSize, colA, rowB, colB, newSize),
            matrixMultiplication(A, B, rowA+ newSize, colA+newSize, rowB+ newSize, colB, newSize),
        newSize, 0);

         sumMatrix(C, 

            matrixMultiplication(A, B, rowA+ newSize, colA, rowB, colB+newSize, newSize),
            matrixMultiplication(A, B, rowA+ newSize, colA+newSize, rowB+ newSize, colB+newSize, newSize),
        newSize, newSize);
    }
//    System.out.println(C);
    return C;

}


private static void sumMatrix(int[][] C, int[][]A, int[][]B,int rowC, int colC){
    int n=A.length;
    for(int i =0; i<n; i++){
        for(int j=0; j<n; j++)  
            C[i+rowC][j+colC]=A[i][j]+B[i][j];
    }

}    
}
