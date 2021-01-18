/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Random;

/**
 *
 * @author ariel
 */
public class Proceso {
    
    private Random random = new Random();
    private int valor;

    public Proceso(int valor) {
        this.valor = valor;
        this.random = new Random();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
