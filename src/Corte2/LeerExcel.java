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

    public double[] leerTxt(String dirArchivo) throws FileNotFoundException, IOException{
    FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        String cadena = datos.readLine();
        datos.close();
        lector.close();
        
        String n = "";
        String Vectorr[] = cadena.split(", ");
        double[] B = new double[Vectorr.length];
                int s = 0;
                for (String valor : Vectorr) {
                    B[s] = Double.parseDouble(valor);
                    s++;
                }
                return B;
    }
    
    
}
