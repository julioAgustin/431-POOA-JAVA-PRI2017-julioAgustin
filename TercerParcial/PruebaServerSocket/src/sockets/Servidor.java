package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Servidor {
	private final int PUERTO = 5050;
	private ServerSocket serverSocket;
	private Executor poolConexiones = null;
	private final int CANT_MAX_THREADS = 10;
	
	public Servidor() {
		this.poolConexiones = Executors.newFixedThreadPool(CANT_MAX_THREADS);
	}
	
	public void inicializarServidor() {
		try {
			serverSocket = new ServerSocket(PUERTO);
				while (true) {
					System.out.println("Esperando una conexión");
					final Socket conexion = serverSocket.accept();
					Runnable r = new Runnable() {
						@Override
						public void run() {
							manejarConexion(conexion);
							
						}
					
				};
				poolConexiones.execute(r);
				}
				
				} catch(IOException ex){
				  ex.printStackTrace();
		}
	}	
	
	private void manejarConexion (Socket conexion) {
		BufferedReader entrada = null;
		PrintWriter salida = null;
		try {
			entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String mensaje = entrada.readLine();
			System.out.println("Mensaje recibido: " + mensaje);
			
			
			salida = new PrintWriter(conexion.getOutputStream(), true);
			System.out.println("Ingrese el mensaje a enviar: ");
			String mensajeSalida = entrada.readLine();
			salida.write(mensajeSalida);
			salida.flush();
			System.out.println(mensajeSalida);
			
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				conexion.close();
				if (entrada != null) {
					entrada.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Servidor server = new Servidor();
		server.inicializarServidor();
	}

}
