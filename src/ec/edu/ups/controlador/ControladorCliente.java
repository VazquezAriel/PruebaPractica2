/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ariel
 */
public class ControladorCliente {
    
    private List<Cliente> clientes;
    private List<Cliente> enLaFila;
    private List<Cliente> fueraDeFila;
    private Random random;

    public ControladorCliente(List<Cliente> clientes) {
        this.clientes = clientes;
        random = new Random();
    }
    
    public void ingresarEnFila() {
        
    }
    
    public void irAlCajero(Cliente cliente) {
        
        
    }
     
}
