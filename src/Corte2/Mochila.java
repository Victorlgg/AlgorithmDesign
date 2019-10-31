/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

/**
 * http://jorgep.blogspot.com/2010/11/problema-de-la-mochila.html
 *  http://webysw.blogspot.com/2009/05/pro.html
 * @author Victor
 */
public class Mochila {

    double x[];

    public double[] getX() {
        return x;
    }

//    public int[][] Mochila(int[] pesos, int[] beneficios, int capacidad){   
//		//Creamos la matriz de devoluciones    
//		int[][]  matriz_mochila = new int[pesos.length+1][capacidad+1];
//		//Rellenamos la 1ª fila de ceros   
//		for(int i = 0; i <= capacidad; i++)  
//			matriz_mochila[0][i] = 0;    //Rellenamos la 1ª columna de ceros 
//		for(int i = 0; i <= pesos.length; i++)           
//			matriz_mochila[i][0] = 0;  //primera fila de ceros;         
//		for(int j = 1; j <= pesos.length ; j++)          
//			for(int c = 1; c <= capacidad; c++){       
//				if(c <  pesos[j-1] ){           
//					matriz_mochila[j][c] = matriz_mochila[j-1][c];   
//					}else{               
//						if(matriz_mochila[j-1][c] > matriz_mochila[j-1][c-pesos[j-1]]+ beneficios[j-1]){    
//							matriz_mochila[j][c] = matriz_mochila[j-1][c];           
//							}else{                
//								matriz_mochila[j][c] = matriz_mochila[j-1][c-pesos[j-1]]+beneficios[j-1]; 
//								}           
//						}     
//				}       return matriz_mochila;    
//				}
    public static void LlenarMochila(double cap, double[] peso, double[] beneficio, double[] x) {
        double resto = cap;
        for (int i = 0; i < peso.length; ++i) 
            x[i] = 0.0;
        
        for (int i = 0; i < peso.length; ++i) {
            if (peso[i] <= resto) {
                x[i] = 1;
                resto = resto - peso[i];
            } else {
                x[i] = resto / peso[i];
                resto = resto - resto / peso[i];
            }
            i++;
        }
        int a = 0;
        for (double valor : x) {
            System.out.print(valor + " ");
            System.out.print("(" + valor * beneficio[a] + "," + valor * peso[a] + ") ");
//    System.out.print(valor*peso[a]+" ");
            a++;
        }
    }

}
