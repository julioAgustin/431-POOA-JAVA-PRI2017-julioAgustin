/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientesocketchat;

/**
 *
 * @author Nilsa
 */
public class ClienteSocketChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Cliente cliente = new Cliente();
        cliente.conexion(5555, "localhost");

    }
    
}
