/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor;
import java.io.*;
import java.net.*;

public class Cliente {
public Cliente(){
    
}

    private static BufferedReader stdin1 = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedReader stdin2 = new BufferedReader(new InputStreamReader(System.in));
   
    public static void main(String[] args) throws IOException {
        
        
        String IP="localhost";
        int PUERTO=8080;
        String sigue="s";
        while(sigue.equals("s")){
            try{
                System.out.println("Calculadora\n");
                System.out.print("Operacion a realizar\n");
                System.out.print("num1+num2;num1-num2;num1*num2;num1/num2\n");
                System.out.print("----->");
                String valor =stdin2.readLine();
                
                String resultado = realizar_operacion(IP,PUERTO,valor);
                System.out.println("El resultado es:"+resultado);
                
            }catch(Exception e){
                System.out.println(e);
            }
       System.out.print("\ndesea realizar otra operacion(s/n)");
       sigue= stdin1.readLine();
       System.out.print("\n");
            
        }
        System.out.println("Bye");
        
        
    }
        static String realizar_operacion(String host, int puerto, String valor){
            String respuesta = null;
            try{
                Socket socketEn = new Socket(host,puerto);
                
                DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(socketEn.getOutputStream()));
                DataInputStream entrada = new DataInputStream(new BufferedInputStream(socketEn.getInputStream()));
                salida.writeUTF(valor);
                salida.flush();
                
                respuesta = entrada.readUTF();
                
                try{
                    socketEn.close();
                }catch (Exception ex){
                    
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return respuesta;
        }
    }

