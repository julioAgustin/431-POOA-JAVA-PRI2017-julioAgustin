/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

import java.util.Random;

/**
 *
 * @author HP
 */
public class Productor implements Runnable{
     private ObjetoCompartido objeto;
    

    public Productor(ObjetoCompartido c) {
        objeto = c;
      
    }

      public void run() {
        String informacion[] = {
            "Clases Sábado por la tarde",
            "El miércoles es el examen",
            "Esta terminando el año",
            "Por fin vacaciones"
        };
        Random random = new Random();
 
        for (int i = 0;
             i < informacion.length;
             i++) {
            objeto.put(informacion[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        objeto.put("LISTO");
    }
}
