/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nilsa.noguera
 */
public class Cajera implements Runnable{
    private String nombre;
    private Cliente cliente;
    private long tiempoInicial;

    public Cajera(String nombre, Cliente cliente, long tiempoInicial) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoInicial = tiempoInicial;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

           public void run(){
        
		System.out.println("La cajera " + this.nombre + 
				" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + 
				" EN EL TIEMPO: " + (System.currentTimeMillis() - this.tiempoInicial) / 1000	+
				"seg");

		for (int i = 0; i < cliente.getCarroCompra().length; i++) { 
				this.esperarXsegundos(cliente.getCarroCompra()[i]); 
				System.out.println("Procesado el producto " + (i + 1) +  
				" ->Tiempo: " + (System.currentTimeMillis() - this.tiempoInicial) / 1000 + 
				"seg");
		}

		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " + 
				cliente.getNombre() + " EN EL TIEMPO: " + 
				(System.currentTimeMillis() - this.tiempoInicial) / 1000 + "seg");

	}


	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
