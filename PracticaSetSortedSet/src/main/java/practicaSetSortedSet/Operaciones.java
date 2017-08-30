package practicaSetSortedSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Operaciones {
	
	private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	private Set<Hotel> listaHoteles = new HashSet<Hotel>();
	private SortedSet<Hotel> listaOrdenHoteles = new TreeSet<Hotel>();
	private Boolean flagStep = false;
	
	public void menu() throws NumberFormatException, IOException{
		int opcion = 0;
		
		while (opcion != 3){
			System.out.println("******************");
			System.out.println("Opciones del menú.");
			System.out.println("1. Mostrar lista de hoteles: ");
			System.out.println("2. Mostrar hoteles disponibles según zona: ");
			System.out.println("3. Salir.");
		opcion = Integer.parseInt(entrada.readLine());
		
		switch(opcion){
		case 1:
			mostrarListaHoteles();
			break;
			
		case 2:
			mostrarHotelesZona();
			break;
			
		case 3:
			break;
		}
			
		}
		
	}
	
	private void mostrarListaHoteles() throws IOException {
		
		
		
		if (flagStep == false){
			
			Hotel hotel = new Hotel(1, "Hotel Guaraní", "Montaña", 8500);
			listaHoteles.add(hotel);
			listaOrdenHoteles.add(hotel);
			hotel = new Hotel(2, "Hotel Sheraton", "Montaña", 9000);
			listaHoteles.add(hotel);
			listaOrdenHoteles.add(hotel);
			hotel = new Hotel(3, "Hotel San Diego", "Playa", 7500);
			listaHoteles.add(hotel);
			listaOrdenHoteles.add(hotel);
			hotel = new Hotel(4, "Hotel Asunción Palace", "Playa", 10000);
			listaHoteles.add(hotel);
			listaOrdenHoteles.add(hotel);
			hotel = new Hotel(5, "Hotel Trivago", "Rural", 6500);
			listaHoteles.add(hotel);
			listaOrdenHoteles.add(hotel);
			hotel = new Hotel(6, "Hotel San Derlis", "Rural", 9300);
			listaHoteles.add(hotel);
			listaOrdenHoteles.add(hotel);
		
			flagStep = true;
		}
		
		System.out.println("Los hoteles existentes son : ");
		for(Hotel hotel : listaHoteles){
			System.out.printf("* %d %s %s %d\n", hotel.getCodigoHotel(), hotel.getNombre(), hotel.getZona(), hotel.getPrecio());
			
		}
	
	}
	
	private void mostrarHotelesZona() throws IOException{
		
		System.out.println("\n");
		System.out.println("¿En qué zona busca el hotel?: ");
		String zona = entrada.readLine();
		
		for (Hotel hotel : listaOrdenHoteles) {
			if (hotel.getZona().equalsIgnoreCase(zona)){
				System.out.printf("* %d %s %s %d\n", hotel.getCodigoHotel(), hotel.getNombre(), hotel.getZona(), hotel.getPrecio());
			}
		}
	}
	
	public static void main(String[] args) {
		
		
	}

}
