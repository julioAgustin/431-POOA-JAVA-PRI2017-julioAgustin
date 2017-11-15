/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author nilsa.noguera
 */
public class ObjetoCompartido {
       
    private String mensaje;
   
    private boolean estaVacio = true;
 
    public synchronized String tomarObjeto() {
       
        while (estaVacio) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
       
        estaVacio = true;
       
        notifyAll();
        return mensaje;
    }
 
    public synchronized void put(String msg) {
       
        while (!estaVacio) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        
        estaVacio = false;
       
        this.mensaje = msg;
     
        notifyAll();
    }
}
