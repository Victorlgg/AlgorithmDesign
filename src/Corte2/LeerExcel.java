/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Victor
 */
public class LeerExcel {
    int[][] MatrizAdy;
    
    public LeerExcel(File Ruta){
    List cellData = new ArrayList();
    
        try {
            FileInputStream Archivo = new FileInputStream(Ruta);
            //Leer Excel
            XSSFWorkbook libroExcel = new XSSFWorkbook(Archivo);
            //obtener la hoja que se va leer
            XSSFSheet hojaExcel = libroExcel.getSheetAt(0);
            //Obtener todas las filas de la hoja excel
            Iterator<Row> rowIterador = hojaExcel.iterator();
            
            Row row;
            //Recorrer cada Fila
            while(rowIterador.hasNext()){
                row=rowIterador.next();
                //Se obtiene las celdas por fila
                Iterator<Cell> cellIterator= row.cellIterator();
                Cell cell;
                List cellTemp = new ArrayList();
                //Se recorre la celda
                while(cellIterator.hasNext()){
                    //Se obtiene la celda en especifico y se imprime
                    cell = cellIterator.next();
                    cellTemp.add((int)cell.getNumericCellValue());
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
    
    private void agregarMatrizAdy(List cellDataList){
        int x = cellDataList.size();
        MatrizAdy = new int[x][x];
        for(int i=0;i<cellDataList.size();i++){
            List cellTempList = (List) cellDataList.get(i);
            for(int j=0; j<cellTempList.size();j++){
//            XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
             MatrizAdy[i][j]=(int) cellTempList.get(j);
            //cell.getNumericCellValue(),
//            String stringCellValue = hssfCell.toString();
            System.out.print(MatrizAdy[i][j]>9 ? MatrizAdy[i][j]+" ":"0"+MatrizAdy[i][j]+" ");
//                System.out.print( j!=cellTempList.size()-1 ? ""+MatrizAdy[i][j]+",":MatrizAdy[i][j]);
            }
            System.out.println();
        }
        MultiplicarMatriz(MatrizAdy);
    }
    
    public void MultiplicarMatriz(int[][] MatrizAdy){
    MultiMatriz M = new MultiMatriz();
    for(int i=0;i<MatrizAdy.length;i++){
           for(int j=0;j<MatrizAdy.length;j++){
            
            System.out.print(MatrizAdy[i][j]>=10 && MatrizAdy[i][j]<100 ? "["+MatrizAdy[i][j]+"]":"");
            System.out.print(MatrizAdy[i][j]<10? "[0"+MatrizAdy[i][j]+"]":"");
               
             }
           System.out.println();
        }
    
        int Multiplicacion[][] = M.matrixMultiplicationFinal(MatrizAdy, MatrizAdy);
        for(int i=0;i<Multiplicacion.length;i++){
           for(int j=0;j<Multiplicacion.length;j++){
            System.out.print(Multiplicacion[i][j]>=100 ? "["+Multiplicacion[i][j]+"]":"");
            System.out.print(Multiplicacion[i][j]>10 && Multiplicacion[i][j]<100 ? "[0"+Multiplicacion[i][j]+"]":"");
            System.out.print(Multiplicacion[i][j]<9? "[00"+Multiplicacion[i][j]+"]":"");
               
             }
           System.out.println();
        }
    }
    
    public static void main(String [] args){
        File f = new File("./src/ArchivosC2/MatrizGrafo.xlsx");
        if(f.exists()){
            LeerExcel obj = new LeerExcel(f);
        }
    }
}
