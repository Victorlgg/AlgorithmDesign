/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *  https://github.com/dandev237/mochila-continua/blob/master/Objeto.java
 * @author Victor
 */  
public class LeerExcel {

    static int[][] MatrizAdy;

    public static int[][] getMatrizAdy() {
        return MatrizAdy;
    }

    public LeerExcel() {
    }

    public LeerExcel(File Ruta, int hoja) {
        List cellData = new ArrayList();
        try {
            FileInputStream Archivo = new FileInputStream(Ruta);
            //Leer Excel
            XSSFWorkbook libroExcel = new XSSFWorkbook(Archivo);
            //obtener la hoja que se va leer
            XSSFSheet hojaExcel = libroExcel.getSheetAt(hoja);
            //Obtener todas las filas de la hoja excel
            Iterator<Row> rowIterador = hojaExcel.iterator();
            //Iterador para recorrer los datos
            Row row;
            //Recorrer cada Fila
            while (rowIterador.hasNext()) {
                row = rowIterador.next();
                //Se obtiene las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                List cellTemp = new ArrayList();
                //Se recorre la celda
                while (cellIterator.hasNext()) {
                    //Se obtiene la celda en especifico y se imprime
                    cell = cellIterator.next();
                    cellTemp.add((int) cell.getNumericCellValue());
//                    System.out.print((int)cell.getNumericCellValue()+" ");
                }
//                System.out.println();
                cellData.add(cellTemp);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        agregarMatrizAdy(cellData);
    }

    private void agregarMatrizAdy(List cellDataList) {
        int x = cellDataList.size();
        MatrizAdy = new int[x][x];
        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
//            XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                MatrizAdy[i][j] = (int) cellTempList.get(j);
                //cell.getNumericCellValue(),
//            String stringCellValue = hssfCell.toString();
//                System.out.print(MatrizAdy[i][j] > 9 ? MatrizAdy[i][j] + " " : "0" + MatrizAdy[i][j] + " ");
//                System.out.print( j!=cellTempList.size()-1 ? ""+MatrizAdy[i][j]+",":MatrizAdy[i][j]);
            }
//            System.out.println();
        }

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

    public double[] leerTxt(String dirArchivo) throws FileNotFoundException, IOException{
    FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        String cadena = datos.readLine();
        datos.close();
        lector.close();
        
        String n = "";
        String Vectorr[] = cadena.split(", ", -2);
        double[] B = new double[Vectorr.length];
                int s = 0;
                for (String valor : Vectorr) {
                    B[s] = Double.parseDouble(valor);
                    s++;
                }
                return B;
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
                    D.dijkstra(MatrizAdy, 13);
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
                    //Implementar
                    LeerExcel objmoc = new LeerExcel(f, x);
                    double[] peso= objmoc.leerTxt("./src/ArchivosC2/peso2.txt");
                    double[] beneficio= objmoc.leerTxt("./src/ArchivosC2/beneficio2.txt");
                    int tamano =14;
                    //nuevo objeto con numero de objetos
                    
//                    for(int valor: peso){
//                    System.out.println(valor);
//                    }
                    
                    double Solucion[]={0,0,0};
                    Mochila M = new Mochila();
//                    double Mochila[][]= M.Mochila(peso, beneficio,tamano );
//                    for(int i=0;i<Mochila.length;i++){
//                        System.out.println();
//                        for(int j=0;j<Mochila.length;j++)
//                            System.out.print(Mochila[i][j]);
//                    }
                    M.LlenarMochila(tamano, peso, beneficio, Solucion);
                    break;
                case 3:
                    System.exit(0);
                    break;

            }

        }
    }
}
