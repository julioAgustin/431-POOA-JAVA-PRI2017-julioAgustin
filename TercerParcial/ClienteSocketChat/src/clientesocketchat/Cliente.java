/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientesocketchat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nilsa
 */
public class Cliente {
     private Socket socketCliente;

    private InputStream inputStream;
    private OutputStream outputStream;

    private DataInputStream entradaDatos;
    private DataOutputStream SalidaDatos;

    private boolean opcion = true;

     private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    private String escribir;
    public void conexion(int numeroPuerto, String ipMaquina) {
        try {
            socketCliente = new Socket(ipMaquina, numeroPuerto);
            Thread hilo1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (opcion) {
                        escucharDatos(socketCliente);
                        System.out.print("CLIENTE: ");
                    }
                }
            });
            hilo1.start();
            while (opcion) {
                escribir = entrada.readLine();
              
                if (!escribir.equals("SERVIDOR: fin")) {
                    enviarDatos("CLIENTE: " + escribir);
                } else {
                    opcion = false;
                    cerrarTodo();
                }
            }

        } catch (Exception ex) {
            System.out.println("ERROR AL ABRIR LOS SOCKETS CLIENTE " + ex.getMessage());
        }
    }
    public void escucharDatos(Socket socket) {
      
         try {
             inputStream = socket.getInputStream();
             entradaDatos = new DataInputStream(inputStream);
             System.out.println(entradaDatos.readUTF());
         } catch (IOException ex) {
             Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    public void enviarDatos(String datos) {
     
         try {
             outputStream = socketCliente.getOutputStream();
             SalidaDatos = new DataOutputStream(outputStream);
             SalidaDatos.writeUTF(datos);
             SalidaDatos.flush();
         } catch (IOException ex) {
             Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
         }
       

    }
    public void cerrarTodo() {
        try {
            SalidaDatos.close();
            entradaDatos.close();
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
