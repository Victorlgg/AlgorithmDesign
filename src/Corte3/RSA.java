/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
    
/**
 *
 * @author Guia de Del Alex Narvaez Programming
 */
public class RSA {

    static private BigInteger phi_n, d, e, n, p, q;

    BigInteger encriptar(String mensaje) throws IOException {
        byte[] bytes = mensaje.getBytes();
        String valores = "";
        for (byte value : bytes) {
            valores += value;
        }
        BigInteger message = new BigInteger(valores);
        return message.modPow(this.e, this.n);
    }

    void desencriptar(BigInteger cifrado) {
        BigInteger a = cifrado.modPow(this.d, this.n);//return encrypted.modPow(privateKey, modulus);
        String mensaje = a.toString();
        for (int i = 0; i < mensaje.length(); i += 2) {
            char c = (char) Integer.parseInt((mensaje.substring(i, i + 2)));
            if (c == 0) {
                break;
            }
            System.out.print(c);
        }
    }
    
//n=p*q , phi_n=(p-1)(q-1) , d=inv(e) mod n
    public static void main(String[] argsa) throws IOException {
        e = new BigInteger("65537");//65537 //publickey
        Scanner sc = new Scanner(System.in);
        System.out.println("Valor de p,q y luego el mensaje");
        p = new BigInteger(sc.nextBigInteger().toString());
//    System.out.println("Valor de q");
        BigInteger q = sc.nextBigInteger();
//    BigInteger cifrado = sc.nextBigInteger();//Si se quiere recibir por consola
        n = new BigInteger(p.multiply(q).toString());//n=p*q , modulus=p*q
        phi_n = p.subtract(BigInteger.valueOf(1));//phi_n -> O
        phi_n = phi_n.multiply(q.subtract(BigInteger.valueOf(1)));

        d = e.modInverse(phi_n); //private key

        RSA RS = new RSA();
        String mensaje = RS.leerTxt("./src/ArchivosC3/texto.txt");
        BigInteger cifrado = RS.encriptar(mensaje);
        BigInteger cifrado1 = new BigInteger(RS.leerTxt("./src/ArchivosC3/MensajeENC1.txt"));
        BigInteger cifrado2 = new BigInteger(RS.leerTxt("./src/ArchivosC3/MensajeENC2.txt"));
        RS.desencriptar(cifrado);
        System.out.println();
        RS.desencriptar(cifrado1);
        System.out.println();
        RS.desencriptar(cifrado2);

    }

    public String leerTxt(String dirArchivo) throws FileNotFoundException, IOException {
        FileReader lector = new FileReader(dirArchivo);
        BufferedReader datos = new BufferedReader(lector);
        String cadena = datos.readLine();
        datos.close();
        lector.close();
        return cadena;
    }

}
/*
30762542250301270692051460539586166927291732754961
29927402397991286489627837734179186385188296382227
424236952206057066872700453503661773567827006571091351397488406910437574827532103275742945321419387
*/
