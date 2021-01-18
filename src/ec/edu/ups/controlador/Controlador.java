/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ariel
 */
public class Controlador {
    
    private List<Cliente> clientes;
    private List<Cliente> enLaFila;
    private List<Cliente> fueraDeFila;
    private Random random;
    
    private Controlador() {
        clientes = new ArrayList<>();
        enLaFila = new ArrayList<>();
        fueraDeFila = new ArrayList<>();
        random = new Random();
    }
    
    public static Controlador getInstance() {
        return ControladorHolder.INSTANCE;
    }
    
    private static class ControladorHolder {
        private static final Controlador INSTANCE = new Controlador();
    }
    
    
}
