/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

import Corte2.Objeto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class MochilaC {

    Objeto objetos[];
    double solucion[];

    public MochilaC(){}
    
    public MochilaC(int size){
    this.objetos= new Objeto[size];
    this.solucion= new double[size];
    }
    
    public int SeleccionVoraz() {
        //Estrategia del mayor valor/peso
        double mayor = -1;
        int indice = -1, j=0;

        for (j = 0; j < objetos.length; j++) {
//            System.out.println("tomado: "+objetos[j].tomado+" mayor"+mayor+" valorPeso"+objetos[j].getValorPeso() );
            if (!objetos[j].tomado && (mayor < objetos[j].valorPeso)) {
                
                mayor = objetos[j].valorPeso;
                indice = j;
            }
        }
        return indice;
    }

    public double valorTotal() {
        double valor = 0;

        for (int i = 0; i < objetos.length; i++) {
            valor = valor + objetos[i].valor * solucion[i];
        }

        return valor;
    }

//    public static void main(String args[]) throws IOException {
        public static void mein(double pesoMaximo) throws IOException{
        LeerExcel n = new LeerExcel();
        double[] pesos= n.leerTxt("./src/ArchivosC2/peso.txt");
        double[] beneficio= n.leerTxt("./src/ArchivosC2/beneficio.txt");
        
        MochilaC m = new MochilaC(pesos.length);
        for(int x=0;x<pesos.length;x++){
        System.out.println("["+pesos[x]+ "]["+beneficio[x]+"]");
        }
        
        double PesoMax=pesoMaximo, suma = 0;
        int i;
        for (i = 0; i < m.objetos.length; i++) {
            m.objetos[i]=new Objeto();
//            m.objetos[i].setPeso(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso del objeto " + i)));
//            System.out.println(pesos[i]);
            m.objetos[i].setPeso(pesos[i]);
//            m.objetos[i].valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor del objeto" + i));
            m.objetos[i].valor= beneficio[i];
            m.objetos[i].valorPeso = m.objetos[i].valor / m.objetos[i].peso;
            m.objetos[i].tomado = false;
        }

//        PesoMax = Double.parseDouble(JOptionPane.showInputDialog("¿Peso maximo de la mochila?"));

        while (suma < PesoMax) {
            i = m.SeleccionVoraz();
            if ((suma + m.objetos[i].peso) < PesoMax) {
                m.solucion[i] = 1;
                suma = suma + m.objetos[i].peso;
                m.objetos[i].tomado = true;
            } else {
                m.solucion[i] = (PesoMax - suma) / m.objetos[i].peso;
                suma = PesoMax; //corregir error al multiplicar por fraccion
            }
        }

        System.out.println("El valor maximo obtenido es: " +m.valorTotal());
        System.out.println("y el vector solución es: ");
        for(i=0;i<m.solucion.length;i++){
        System.out.print("["+m.solucion[i]+"]");
//        System.out.print("["+pesos[i]+"]");
//        System.out.print("["+beneficio[i]+"]");
        System.out.print(" "+m.solucion[i]*beneficio[i]+" ");
        }
    }
    
    //Aparte del codigo para leer txt
    
    
    
    

}
