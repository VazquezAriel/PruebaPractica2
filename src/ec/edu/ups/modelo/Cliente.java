/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ariel
 */
public class Cliente extends Thread{
    
    private final int MAX_X = 578;
    private final int MAX_Y = 246;
    private int posicionEnFila;
    private int tiempo;
    private int distancia;
    private int id;
    private int saldo;
    private List<Proceso> procesos;
    private Random random;
    private JLabel icono;
    private JTextField saldoInterfaz;

    public Cliente(int id, JLabel icono, JTextField saldoInterfaz, int posicionEnFila) {
        this.id = id;
        this.saldo = 100;
        this.procesos = new ArrayList<>();
        this.random = new Random();
        this.icono = icono;
        this.saldoInterfaz = saldoInterfaz;
        this.posicionEnFila = posicionEnFila;
        generarProcesos();
    }

    public int getPosicionEnFila() {
        return posicionEnFila;
    }

    public void setPosicionEnFila(int posicionEnFila) {
        this.posicionEnFila = posicionEnFila;
    }
   
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public JLabel getIcono() {
        return icono;
    }

    public void setIcono(JLabel icono) {
        this.icono = icono;
    }

    public JTextField getSaldoInterfaz() {
        return saldoInterfaz;
    }

    public void setSaldoInterfaz(JTextField saldoInterfaz) {
        this.saldoInterfaz = saldoInterfaz;
    }
    
    public final void generarProcesos() {
        
        for (int i = 0; i < 4; i++) {
            Proceso proceso = new Proceso(100);
            procesos.add(proceso);
        }
        
        for (int i = 0; i < 2; i++) {
            Proceso proceso = new Proceso(50);
            procesos.add(proceso);
        }
        
        for (int i = 0; i < 6; i++) {
            Proceso proceso = new Proceso(20);
            procesos.add(proceso);
        }
        
        for (int i = 0; i < 4; i++) {
            Proceso proceso = new Proceso(-100);
            procesos.add(proceso);
        }
        
        for (int i = 0; i < 2; i++) {
            Proceso proceso = new Proceso(-50);
            procesos.add(proceso);
        }
        
        for (int i = 0; i < 6; i++) {
            Proceso proceso = new Proceso(-20);
            procesos.add(proceso);
        }
        
    }
    public Proceso obtenerProcesoAleatorio() {
        if (!procesos.isEmpty()) {
            List<Proceso> aux = new ArrayList<>();
            procesos.forEach(proceso -> aux.add(proceso));
            Proceso proceso = aux.get(random.nextInt(aux.size()));
            procesos.remove(proceso);
            return proceso;
        }
        return null;
    }
    
    public void realizarDeposito() {
        this.saldo = this.saldo + obtenerProcesoAleatorio().getValor();
        saldoInterfaz.setText("$ " + this.saldo);
    }
    
    @Override
    public void run() {
        try {
            int tiempoAux = tiempo/distancia;
                    
            for (int i = 0; i < distancia; i++) {
                Thread.sleep(tiempoAux);
                
                if (icono.getX() <= MAX_X) {
                    icono.setLocation(icono.getX() + 2, icono.getY()); 
                } else {
                    icono.setLocation(icono.getX(), icono.getY() + 2);
                }
                i++;
            }
            
            
        } catch (InterruptedException ex) {
            ex.getMessage();
        }

    }
}
