/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte3;

/**
 *
 * @author BOG-A307-E-006
 */
public class RSA2 {

    String letras[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public int Euclides(int a, int b) {

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public long[] euclidesExtendido(long a, long b) {
        long[] resp = new long[3];
        long x = 0, y = 0, d = 0;

        if (b == 0) {
            resp[0] = a;
            resp[1] = 1;
            resp[2] = 0;
        } else {
            long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
            long q = 0, r = 0;

            while (b > 0) {
                q = (a / b);
                r = a - q * b;
                x = x2 - q * x1;
                y = y2 - q * y1;
                a = b;
                b = r;
                x2 = x1;
                x1 = x;
                y2 = y1;
                y1 = y;
            }

            resp[0] = a;
            resp[1] = x2;
            resp[2] = y2;
        }

        return resp;
    }

    public void obtenerInverso(int a, int m) {
        int c1 = 1;
        int c2 = -(m / a); //coeficiente de a y b respectivamente
        int t1 = 0;
        int t2 = 1; //coeficientes penultima corrida
        int r = m % a; //residuo, asignamos 1 como condicion de entrada 
        int x = a, y = r, c;
        while (r != 0) {
            c = x / y;//cociente
            r = x % y;//residuo
//guardamos valores temporales de los coeficientes
//multiplicamos los coeficiente por -1*cociente de la division
            c1 *= -c;
            c2 *= -c;
//sumamos la corrida anterior
            c1 += t1;
            c2 += t2;
//actualizamos corrida anterior
            t1 = -(c1 - t1) / c;
            t2 = -(c2 - t2) / c;
            x = y;
            y = r;
        }
        if (x == 1)//residuo anterior es 1 , son primos relativos y el inverso existe
        {
            System.out.println("" + t2);
        } else {
            System.out.println("No hay inverso");
        }
    }

    public static void main(String[] args) {

        RSA2 R = new RSA2();
        //  primos suficientemente grandes p q p!=q //Test de primalidad
        //EJ p=11 y q =23
        int p = 11, q = 23;
        //n = p*q  cuerpo de trabajo n
        int n = p * q;
        
        // O = (p-1)*(q-1) Indicador de Euler
        //0=220 n=253
        int O = (p - 1) * (q - 1);
        //RSA-CLAVES
        //se busca numero e impar, que no tenga multiplos comunes con O
        //aleatorio e tal que 1<e<O MCD(O,e)=1
        //ej 3: //coprimo
        int e = 3;
        //MCD(220.3))1 //maximo comun divisor   es 1
        System.out.println(R.Euclides(e, O));
        R.obtenerInverso(O, e);
        long m[] = R.euclidesExtendido((long) O, (long) e);
        for (long valor : m) {
            System.out.print(valor + " ");
        }
        //Se calcula exponente privado de RSA2 d= inv(e,0); d = inv(3,220) = 147
        // Algoritmo de euclides para hallar d segun wiki
        
        
        //Clave publica (e,n)(3,253) ¿privada(d,n)(147,253) 
        //Cifrado C = M.exp(e) Mod(n)
        //Descifrado C.exp(d) mod (n) = M
        //Array letra a numero A=0 Z=25

    }

}
