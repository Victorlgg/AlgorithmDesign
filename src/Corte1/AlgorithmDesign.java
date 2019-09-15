/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte1;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class AlgorithmDesign {

    public static String casas(int size) {
        int casas = size;
        int sumIzquierda = 0;
        int sumDerecha = 0;
        String resultado="";
        for (int posicion = 2; posicion < casas; posicion++) {
            sumIzquierda+=posicion-1;
            sumDerecha = 0;
//            System.out.println(sumIzquierda+" d"+sumDerecha);
//            for (int recorrerIzq = posicion - 1; recorrerIzq > 0; recorrerIzq--) { 
//                sumIzquierda += recorrerIzq; }
            for (int recorrerDer = posicion + 1; recorrerDer <= casas; recorrerDer++) { 
                sumDerecha += recorrerDer;
                if (sumDerecha == sumIzquierda) { resultado+=("Posicion:" +posicion+ ", total:" + sumDerecha+"\n"); }
                if (sumDerecha > sumIzquierda)  { break; }
            }
            System.out.print(posicion % 10000 == 0 ? posicion+" ": "");
            System.out.print(posicion % 100000 == 0 ? "\n" : "");
        }
        return resultado;
    }

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
        
//        System.out.println(
//                + "\n4.Maximos y minimos Divide y vencerás" //Segundo corte
//                + "\n5.Multiplicar matrices Divide y vencerás" //Segundo Corte
//        );
//        int x = sc.nextInt();
        while(true){
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el método que desea utilizar:"
                + "\n1.Leer y ordenar archivo con burbuja"
                       + "\n2.Métodos de ordenamiento."
                       + "\n3.Sumar Casas"
                       + "\n0.Salir"
                        ));

        switch (x) {
            case 1:
                Archivos Arc = new Archivos();
                Arc.ordenar("./src/Texto/cincoMil.txt", 4);
                break;
                
            case 2:
                 Arc = new Archivos();
                 String Tiempo="";
                System.out.println("1.Bubble 2.Quick, 3.Merge");
                
                System.out.println("Mil");                         Arc.ordenar("./src/Texto/Mil.txt", 1);
                Arc.ordenar("./src/Texto/Mil.txt", 2);             Arc.ordenar("./src/Texto/Mil.txt", 3);

                System.out.println("Cinco mil");                   Arc.ordenar("./src/Texto/cincoMil.txt", 1);
                Arc.ordenar("./src/Texto/cincoMil.txt", 2);        Arc.ordenar("./src/Texto/cincoMil.txt", 3);

                System.out.println("Diez mil");                    Arc.ordenar("./src/Texto/diezMil.txt", 1);
                Arc.ordenar("./src/Texto/diezMil.txt", 2);         Arc.ordenar("./src/Texto/diezMil.txt", 3);
//        
                System.out.println("25 mil");                      Arc.ordenar("./src/Texto/ventiCincoMil.txt", 1);
                Arc.ordenar("./src/Texto/ventiCincoMil.txt", 2);   Arc.ordenar("./src/Texto/ventiCincoMil.txt", 3);

                System.out.println("50 mil");                      Arc.ordenar("./src/Texto/cincuentaMil.txt", 1);
                Arc.ordenar("./src/Texto/cincuentaMil.txt", 2);    Arc.ordenar("./src/Texto/cincuentaMil.txt", 3);

                System.out.println("75 mil");                      Arc.ordenar("./src/Texto/setentaCincoMil.txt", 1);
                Arc.ordenar("./src/Texto/setentaCincoMil.txt", 2); Arc.ordenar("./src/Texto/setentaCincoMil.txt", 3);

                System.out.println("Cien mil");                    Arc.ordenar("./src/Texto/cienMil.txt", 1);
                Arc.ordenar("./src/Texto/cienMil.txt", 2);         Arc.ordenar("./src/Texto/cienMil.txt", 3);
                
//        System.out.println("Millon"); //Latex Overleaf v69 gmail
//        Arc.ordenar("./src/Texto/Millon.txt",1); Arc.ordenar("./src/Texto/Millon.txt",2);
//        Arc.ordenar("./src/Texto/Millon.txt",3); //Analisis de gráficas en Latex, explicacion de los metodos

                break;
                
            case 3://Casas

                int size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de casas"));
                String Houses =casas(size);
                JOptionPane.showMessageDialog(null,Houses);
                break;
               
            case 0:
                System.exit(0);
                //DYV Maximo y minimo lista ordenada  -_> SEGUNDO CORTEEEAREQRA
                break;
                
            case 5: 
                //DYV  Multiplicar matrices  _--->SEGUNDO CORTEEEAREQRA
                break;
        }//end switch
        }//end while
        }//end main
}//end clase
