/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corte2;

/**
 *
 * @author Victor
 */
public class Objeto {
    double peso;
    double valor;
    double valorPeso;
    boolean tomado;

    public Objeto() {
        this.peso=0;
        this.valor=0;
        this.valorPeso=1;
        this.tomado=false;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPeso() {
        return valorPeso;
    }

    public void setValorPeso(double valorPeso) {
        this.valorPeso = valorPeso;
    }

    public boolean isTomado() {
        return tomado;
    }

    public void setTomado(boolean tomado) {
        this.tomado = tomado;
    }
    
}


