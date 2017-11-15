/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor;

import java.io.*;
import java.net.*;

 
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int PUERTO= 8080;
        String error= "no hay operando";
        Socket socket= null;
        ServerSocket serverSocket=null;
        String[]lista;
        String resultado= null;
       
        try{
            serverSocket = new ServerSocket(PUERTO);
        }catch(Exception e){
            System.err.println("Error al crear el socket");
            return;
        }
        while(true){
            try{
            System.out.println("Calculadora");
            socket=serverSocket.accept();
            System.out.println("Esperando operaciones a realizar...");
            
            DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                
            String valor = entrada.readUTF();
            if(valor.indexOf("+")!=-1){
                lista= valor.split("\\+");
                Operaciones operar = new Operaciones(lista[0], lista[1]);
                System.out.print("la suma de "+valor+" es... ");
                resultado= String.valueOf(operar.suma());
               
            }else if (valor.indexOf("-")!=-1){
                lista= valor.split("\\-");
                Operaciones operar = new Operaciones(lista[0], lista[1]);
                System.out.print("la resta de "+valor+" es... ");
                resultado= String.valueOf(operar.resta());
            }else if (valor.indexOf("*")!=-1){
                lista= valor.split("\\*");
                Operaciones operar = new Operaciones(lista[0], lista[1]);
                System.out.print("la multiplicacion de "+valor+" es... ");
                resultado= String.valueOf(operar.multiplicacion());
            }else if (valor.indexOf("/")!=-1){
                lista= valor.split("\\/");
                Operaciones operar = new Operaciones(lista[0], lista[1]);
                System.out.print("la division de "+valor+" es... ");
                resultado= String.valueOf(operar.division());
            }
            else{
                System.out.println(error);
            }
                System.out.print(resultado);
                
                salida.writeUTF(resultado);
                System.out.print("\n enviando respuesta...");
                salida.flush();
                System.out.println("OK\n");
                
                try{
                    socket.close();
                }catch(IOException ex){
                    
                }
            
            }catch(Exception e){
                    System.err.println("cerrando la conexion del socket...");
                    if(socket!=null){
                    try{
                    socket.close();
                    }catch(IOException eX){
                    
                    }
                    }
                  }  
        }
         }
    
    }
    

