package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	private static final String HOST = "m203-24";
	private static final int PUERTO = 5050;
	Scanner entrada = new Scanner(System.in);
	public void inicializarCliente() {
		PrintWriter salida = null;
		Socket socket = null;
		try {
			socket = new Socket(HOST, PUERTO);
			salida = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("Ingrese el mensaje a enviar: ");
			String mensaje = entrada.nextLine();
			salida.write(mensaje);
			salida.flush();
			System.out.println(mensaje);
			
		}catch (IOException ex){
			ex.printStackTrace();
			
		}finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (salida != null) {
					salida.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
				
	}
	
	public static void main(String[] args) {
		Cliente c= new Cliente();
		c.inicializarCliente();

	}

}
