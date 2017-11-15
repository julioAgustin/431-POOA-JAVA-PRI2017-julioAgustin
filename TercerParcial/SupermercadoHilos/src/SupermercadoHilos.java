/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno-202
 */
public class SupermercadoHilos {
    
    public static void main (String[] args){
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1,3,5,1,1});
        long tiempoInicial = System.currentTimeMillis();
        Cajera cajera1 = new Cajera("Cajera 1", cliente1, tiempoInicial);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2, tiempoInicial);
        
        // Con implements Runnable
        new Thread(cajera1).start();
        new Thread(cajera2).start();
        
        //Con extends Thread
        //cajera1.start();
        //cajera2.start();
    }
    
    
    
    
    
}
