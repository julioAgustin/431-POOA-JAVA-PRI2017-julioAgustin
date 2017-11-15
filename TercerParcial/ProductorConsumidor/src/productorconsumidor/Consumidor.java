/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.Random;

/**
 *
 * @author nilsa.noguera
 */
public class Consumidor implements Runnable{
     private ObjetoCompartido objeto;
   

    public Consumidor(ObjetoCompartido c) {
        objeto = c;
       
    }

   public void run() {
        Random random = new Random();
        for (String msg = objeto.tomarObjeto();
             ! msg.equals("LISTO");
             msg = objeto.tomarObjeto()) {
            System.out.format("MENSAJE RECIBIDO: %s%n", msg);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
    
}
