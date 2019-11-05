/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

import static Corte2.LeerExcel.MatrizAdy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class PrincipalC2 {

    public PrincipalC2() {
        
    }
   
    
    public static void MultiplicarMatriz(int[][] Matriz1, int[][] Matriz2) {
        MultiMatriz M = new MultiMatriz();
//    for(int i=0;i<MatrizAdy.length;i++){
//           for(int j=0;j<MatrizAdy.length;j++){
//            
//            System.out.print(MatrizAdy[i][j]>=10 && MatrizAdy[i][j]<100 ? "["+MatrizAdy[i][j]+"]":"");
//            System.out.print(MatrizAdy[i][j]<10? "[0"+MatrizAdy[i][j]+"]":"");
//               
//             }
//           System.out.println();
//        }
        int Multiplicacion[][] = M.matrixMultiplicationFinal(Matriz1, Matriz2);
        for (int i = 0; i < Multiplicacion.length; i++) {
            for (int j = 0; j < Multiplicacion.length; j++) {
                System.out.print(Multiplicacion[i][j] >= 100 ? "[" + Multiplicacion[i][j] + "]" : "");
                System.out.print(Multiplicacion[i][j] > 10 && Multiplicacion[i][j] < 100 ? "[0" + Multiplicacion[i][j] + "]" : "");
                System.out.print(Multiplicacion[i][j] < 9 ? "[00" + Multiplicacion[i][j] + "]" : "");
            }
            System.out.println();
        }
    }

    public static void MultiplicarMatrizCuadrada(int[][] MatrizAdy) {
        MultiMatriz M = new MultiMatriz();
        int[][] Mcuadrada = M.multiply(MatrizAdy, MatrizAdy);
        for (int i = 0; i < Mcuadrada.length; i++) {
            for (int j = 0; j < Mcuadrada.length; j++) {
                System.out.print(Mcuadrada[i][j] >= 100 ? "[" + Mcuadrada[i][j] + "]" : "");
                System.out.print(Mcuadrada[i][j] > 10 && Mcuadrada[i][j] < 100 ? "[0" + Mcuadrada[i][j] + "]" : "");
                System.out.print(Mcuadrada[i][j] < 9 ? "[00" + Mcuadrada[i][j] + "]" : "");
            }
            System.out.println();
        }

    }

    
    
    
    
    
    public double[][] Burbuja(double[] Vector, double [] beneficio) {
        
           double Objeto[][]= new double[Vector.length][2];
        for (int i = 0; i < Vector.length; i++) {
            for (int j = 0; j < Vector.length - 1; j++) {
                if ( Vector[j] > Vector[j + 1]) {
                    double aux = Vector[j];
                    Vector[j] = Vector[j + 1];
                    Vector[j + 1] = aux;
                          
                    Objeto[j][0]=Vector[j+1];
                    Objeto[j+1][0]=aux;
                    double auxx=beneficio[j];
                    Objeto[j][1]=beneficio[j+1];
                    Objeto[j+1][1]=auxx;
                }
            }
        }
        return Objeto;
    }
    
    public void LlenarMochila(int matriz[]) throws IOException{
        //Implementar
//                    PrincipalC2 objmoc = new PrincipalC2();
                    
//                    int tamano =20;
                    
//                    double[][]Objetos=objmoc.Burbuja(peso, beneficio);
//                    for(int i=0;i<Objetos.length;i++){                    
//                        System.out.println(Objetos[i][0]+""+Objetos[i][1]);
//                    }
                    
                    
                    //nuevo objeto con numero de objetos
                    
//                    for(int valor: peso){
//                    System.out.println(valor);
//                    }
                    
//                    double Solucion[]={0,0,0};//Cantidad de elementos
//                    Mochila M = new Mochila();
//                    double Mochila[][]= M.Mochila(peso, beneficio,tamano );
//                    for(int i=0;i<Mochila.length;i++){
//                        System.out.println();
//                        for(int j=0;j<Mochila.length;j++)
//                            System.out.print(Mochila[i][j]);
//                    }
//                    M.LlenarMochila(tamano, peso, beneficio, Solucion);
//                    for(int i=0,j=peso.length-1;i<peso.length && j>=0;i++,j--){
//                        
//                            double auxP= peso[i];
//                            double auxB =beneficio[i];
//                            peso[i]=peso[j];
//                            beneficio[i]=beneficio[j];
//                            peso[j]=auxP;
//                            beneficio[j]=auxB;
//                        if(i==j){
//                        break;
//                        }
//                    }
//                    M.LlenarMochila(tamano, peso, beneficio, Solucion);
    }
    
    
    
   public static void main(String[] args) throws IOException {
        File f = new File("./src/ArchivosC2/MatrizGrafo.xlsx");
        if (f.exists()) {
            System.out.println("0.Matriz Adyacencia(Dijsktra), 1.Multiplicar Matrices 2.Mochila 3.salir");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
//            LeerExcel obj2 = new LeerExcel();
            

            switch (x) {
                case 0:
                    LeerExcel obj = new LeerExcel(f, x);
                    Dijkstra D = new Dijkstra();
                    System.out.println("Ingrese el punto de origen.");
                    int origen = sc.nextInt()-1;
                    D.dijkstra(MatrizAdy, origen);
                    //Matriz y fuente
                    //Agregar Destino
                    break;
                case 1:
                    LeerExcel M1 = new LeerExcel(f, 1);
                    System.out.println("--------------");
                    LeerExcel M2 = new LeerExcel(f, 2);
//                    M1.getMatrizAdy();
                    MultiplicarMatriz(M1.getMatrizAdy(),M2.getMatrizAdy());
                    System.out.println("--------------");
                    MultiplicarMatrizCuadrada(MatrizAdy);
                    //Entenderla Bien
                    //Hacer que pueda ser por excel o escrita
                    break;
                case 2: //mochila
//                    MochilaC mochila = new MochilaC();
                    System.out.println("Ingrese el peso maximo");
                    double PesoMax = sc.nextDouble();//Double.parseDouble(JOptionPane.showInputDialog("¿Peso maximo de la mochila?"));
                    MochilaC.mein(PesoMax);

                    break;
                case 3:
                    System.exit(0);
                    break;

            }

        }
    }
    
   
   
}
