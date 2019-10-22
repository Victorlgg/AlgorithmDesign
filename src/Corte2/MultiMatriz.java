/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

import java.io.FileNotFoundException;

/** https://github.com/lisalisadong/algorithms-design-and-analysis/blob/master/divide-and-conquer/matrix-multiplication/MatrixMultiplication.java
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
        //C12
            matrixMultiplication(A, B, rowA, colA, rowB, colB + newSize, newSize),
            matrixMultiplication(A, B, rowA, colA+newSize, rowB+ newSize, colB+newSize, newSize),
        0, newSize);

         sumMatrix(C, 
        //C21
            matrixMultiplication(A, B, rowA+ newSize, colA, rowB, colB, newSize),
            matrixMultiplication(A, B, rowA+ newSize, colA+newSize, rowB+ newSize, colB, newSize),
        newSize, 0);
        //C22
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

/*_-------------------------------------------------______________________________________________________________----*/

static int[][] multiply(int[][] matrix1, int[][] matrix2) {
		int size = matrix1.length;
		int[][] product = new int[size][size];
		if (size == 1) {
			product[0][0] = matrix1[0][0] * matrix2[0][0];
		} else if (size % 2 == 0) {
			int [][] a = new int[size/2][size/2];
			int [][] b = new int[size/2][size/2];
			int [][] c = new int[size/2][size/2];
			int [][] d = new int[size/2][size/2];
			int [][] e = new int[size/2][size/2];
			int [][] f = new int[size/2][size/2];
			int [][] g = new int[size/2][size/2];
			int [][] h = new int[size/2][size/2];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (i < size / 2 & j < size / 2) {
						a[i][j] = matrix1[i][j];
						e[i][j] = matrix2[i][j];
					} else if (i < size / 2 && j >= size / 2) {
						b[i][j - size/2] = matrix1[i][j];
						f[i][j - size/2] = matrix2[i][j];
					} else if (i >= size / 2 && j < size / 2) {
						c[i - size/2][j] = matrix1[i][j];
						g[i - size/2][j] = matrix2[i][j];
					} else {
						d[i - size/2][j - size/2] = matrix1[i][j];
						h[i - size/2][j - size/2] = matrix2[i][j];
					}
				}
			}
			int[][] p1 = multiply(a, minus(f, h));
			int[][] p2 = multiply(add(a, b), h);
			int[][] p3 = multiply(add(c, d), e);
			int[][] p4 = multiply(d, minus(g, e));
			int[][] p5 = multiply(add(a, d), add(e, h));
			int[][] p6 = multiply(minus(b, d), add(g, h));
			int[][] p7 = multiply(minus(a, c), add(e, f));
			int[][] c1 = add(minus(add(p5, p4), p2), p6);
			int[][] c2 = add(p1, p2);
			int[][] c3 = add(p3, p4);
			int[][] c4 = minus(add(p1, p5), add(p3, p7));
			for (int i = 0; i < size/2; i++) {
				for (int j = 0; j < size/2; j++) {
					product[i][j] = c1[i][j];
					product[i][j + size/2] = c2[i][j];
					product[i + size/2][j] = c3[i][j];
					product[i + size/2][j + size/2] = c4[i][j];
				}
			}
		} else {
			int[][] copy1 = new int[size + 1][size + 1];
			int[][] copy2 = new int[size + 1][size + 2];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					copy1[i][j] = matrix1[i][j];
					copy2[i][j] = matrix2[i][j];
				}
			}
			int[][] copy3 = multiply(copy1, copy2);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					product[i][j] = copy3[i][j];
				}
			}
		}
		return product;
		
	}

	static int[][] add(int[][] matrix1, int[][] matrix2) {
		int size = matrix1.length;
		int[][] sum = new int[size][size]; 
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return sum;
	}
	
	static int[][] minus(int[][] matrix1, int[][] matrix2) {
		int size = matrix1.length;
		int[][] difference = new int[size][size]; 
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				difference[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		return difference;
	}
	
	static void print(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size; i++) {
    		for (int j = 0; j < size; j++) {
    			System.out.printf("%4d", matrix[i][j]);
    		}
    		System.out.println();
    	}
	}
	
    public static void main(String[] args) throws FileNotFoundException {
    	int[][] first = {
    			{1, 1, 1},
    			{1, 1, 1},
    			{1, 1, 1}
    	};
    	int[][] second = {
    			{1, 2, 3, 4, 5},
    			{1, 1, 1, 1, 1},
    			{1, 1, 1, 1, 1},
    			{5, 4, 3, 2, 1},
    			{1, 1, 1, 1, 1}
    	};
    	int[][] test1 = multiply(first, first);
    	print(test1);
    	print(multiply(second, second));
    }

//    public int[][] calc(int[][] a, int[][] b) {
//
//        int n = a.length;
//        int[][] c = new int[n][n];
//
//        if (n == 1) {
//            c[0][0] = a[0][0] * b[0][0];
//        } else {
//            int sub = a.length / 2;
//            int[][] smalla11 = new int[sub][sub];
//            int[][] smalla12 = new int[sub][sub];
//            int[][] smalla21 = new int[sub][sub];
//            int[][] smalla22 = new int[sub][sub];
//            int[][] smallb11 = new int[sub][sub];
//            int[][] smallb12 = new int[sub][sub];
//            int[][] smallb21 = new int[sub][sub];
//            int[][] smallb22 = new int[sub][sub];
//
//            for (int i = 0; i < sub; i++) {
//                for (int j = 0; j < sub; j++) {
//                    smalla11[i][j] = a[i][j];
//                    smalla12[sub + i][j] = a[sub + i][j];
//                    smalla21[i][sub + j] = a[i][sub + j];
//                    smalla22[sub + i][sub + j] = a[sub + i][sub + j];
//                    smallb11[i][j] = b[i][j];
//                    smallb12[sub + i][j] = b[sub + i][j];
//                    smallb21[i][sub + j] = b[i][sub + j];
//                    smallb22[sub + i][sub + j] = b[sub + i][sub + j];
//                }
//            }
//            c = calc(smalla11, smallb11);
//}
//        return c;
//  
//}
    
}