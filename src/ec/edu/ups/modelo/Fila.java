/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 */
public class Fila {

    private List<Cliente> fila;
    private List<Cliente> enEspera;
    private Random random;
    private boolean isLibre;
    private final int INICIO_X = 18;
    private final int INICIO_Y = 24;
    private int tiempo;

    public Fila(List<Cliente> clientes) {
        enEspera = new ArrayList<>();
        isLibre = true;
        fila = clientes;
        random = new Random();
    }

    public synchronized void ingresarEnFila(Cliente cliente) {

        if (isLibre) {
            for (int i = 0; i < 10; i++) {
                try {
                    this.wait((random.nextInt(20) + 3) * 10000);
                    Cliente clienteUltimo = fila.get(fila.size() - 1);

                    if (clienteUltimo.getIcono().getX() <= 578) {
                        cliente.getIcono().setLocation(clienteUltimo.getIcono().getX() - 94, clienteUltimo.getIcono().getY());
                    } else {
                        cliente.getIcono().setLocation(clienteUltimo.getIcono().getX(), clienteUltimo.getIcono().getY() - 94);
                    }

                    fila.add(cliente);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public synchronized void irAlCajero(int distancia) {

        tiempo = (random.nextInt(4) + 2) * 1000;
        Cliente primeroEnFila = getPrimeraPosicion();

        if (primeroEnFila != null) {
            primeroEnFila.setDistancia(distancia);
            primeroEnFila.setTiempo(tiempo);
            new Thread(primeroEnFila).start();
            primeroEnFila.realizarDeposito();
            fila.remove(primeroEnFila);
            enEspera.add(primeroEnFila);
        }

        int aux = 1;

        for (Cliente cliente : fila) {
            cliente.setDistancia(94);
            cliente.setTiempo(tiempo);
            cliente.setPosicionEnFila(aux);
            aux++;
            new Thread(cliente).start();
        }
    }

    public Cliente getPrimeraPosicion() {
        return fila.stream().filter(c -> c.getPosicionEnFila() == 1).findFirst().orElse(null);
    }

}
