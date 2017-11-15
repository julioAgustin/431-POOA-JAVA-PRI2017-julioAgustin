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
public class ProductorConsumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ObjetoCompartido c = new ObjetoCompartido();
        (new Thread(new Productor(c))).start();
        (new Thread(new Consumidor(c))).start();
    }
    
}
