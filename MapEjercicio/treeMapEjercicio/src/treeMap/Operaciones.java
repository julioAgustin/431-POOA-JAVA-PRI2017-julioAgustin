package treeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Operaciones {
	private Map<String, Producto> listaProductos = new Hashtable<String, Producto>();
	private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	private Queue<Producto> cola = new PriorityQueue<Producto>(); 
	
	public void menu() throws IOException {
		int opcion = 0;
		
		while(opcion != 7) {
			System.out.println("Escoja una de las opciones del menú...");
			System.out.println("1. Agregar producto.");
			System.out.println("2. Modificar todos los datos de un producto.");
			System.out.println("3. Eliminar un producto por medio de código de producto.");
			System.out.println("4. Mostrar los productos de la colección ordenado por precio unitario.");
			System.out.println("5. Mostrar los productos de la colección como en el mapa.");
			System.out.println("6. El mayor año de fabricación guardada en la colección.");
			System.out.println("7. Salir.");
			opcion = Integer.parseInt(entrada.readLine());
			switch (opcion){
			case 1:
				agregarProducto();
				break;
			case 2:
				modificarDatosProducto();
				break;
			case 3:
				eliminarProducto();
				break;
			case 4:
				mostrarProductosPrecioUnitario();
				break;
			case 5:
				mostrarProductosMap();
				break;
			case 6:
				mayorAñoFabricacion();
				break;
			case 7:
				break;
				
			}
			
		}
	}
	
	private void agregarProducto() throws IOException {
		try {
			System.out.println("Ingrese los datos del producto: ");
			System.out.println("Código de producto: ");
			String codProducto = entrada.readLine();
			if (listaProductos.containsKey(codProducto)) {
				System.out.println("El producto ya existe");
				return;
			}
			System.out.println("Nombre del producto: ");
			String nombre = entrada.readLine();
			System.out.println("Nombre del fabricante: ");
			String fabricante = entrada.readLine();
			System.out.println("Año de fabricación: ");
			Integer anhoFabricacion = Integer.parseInt(entrada.readLine());
			System.out.println("Precio unitario: ");
			Integer precioUnitario = Integer.parseInt(entrada.readLine());
			System.out.println("Cantidad: ");
			Integer cantidad = Integer.parseInt(entrada.readLine());
			listaProductos.put(codProducto, new Producto(codProducto, nombre, fabricante, anhoFabricacion, 
					precioUnitario, cantidad));
			System.out.println("¡¡¡Producto agregado!!!");
			
		}catch (InputMismatchException e) {
			System.out.println("El tipo de dato no es el correcto");
		}
	}

	private void modificarDatosProducto() throws IOException {
		try {
			
		System.out.println("Ingrese el código del producto a modificar: ");
		String codProducto = entrada.readLine();
		Set<String> lista = listaProductos.keySet();
		Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
		if (listaProductos.containsKey(codProducto)) {
			System.out.println("Nombre del producto: ");
			String nombre = entrada.readLine();
			System.out.println("Nombre del fabricante: ");
			String fabricante = entrada.readLine();
			System.out.println("Año de fabricación: ");
			Integer anhoFabricacion = Integer.parseInt(entrada.readLine());
			System.out.println("Precio unitario: ");
			Integer precioUnitario = Integer.parseInt(entrada.readLine());
			System.out.println("Cantidad: ");
			Integer cantidad = Integer.parseInt(entrada.readLine());
			Producto productoViejo = listaProductos.get(codProducto);
			Producto productoNuevo = new Producto(codProducto, nombre, fabricante, anhoFabricacion, 
					precioUnitario, cantidad);
			listaProductos.replace(codProducto, productoViejo, productoNuevo);
			System.out.println("¡¡¡Producto actualizado!!!");
			return;	
		}
		
        }
       
        System.out.println("El código del producto no existe.");
		
       
	   }catch(InputMismatchException e) {
			System.out.println("El tipo de dato no es el correcto");
		   
	   }
	}
	
	private void eliminarProducto() throws IOException {
		try {
			System.out.println("Ingrese el código del producto a eliminar: ");
			String codigoProducto = entrada.readLine();
			Set<String> lista = listaProductos.keySet();
			Iterator<String> it = lista.iterator();
            while (it.hasNext()) {
               
                if (listaProductos.containsKey(codigoProducto)) {
                	 String indice = it.next();
                        listaProductos.remove(indice);
                        System.out.println("Se ha eliminado el producto...");
                        return;
                    }

                }
            System.out.println("El código del producto no existe.");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void mostrarProductosPrecioUnitario() throws IOException {
		
			String codigoProducto;
			System.out.println("Ordenar producto...");
			Set<String> lista = listaProductos.keySet();
			Iterator<String> it = lista.iterator();
            while (it.hasNext()) {
               codigoProducto = it.next();
                if (listaProductos.containsKey(codigoProducto)) {
                	 Producto productoActual = listaProductos.get(codigoProducto);
                	 cola.add(productoActual);
                    }

                }
            while (!cola.isEmpty()) {
            	for (Producto productoActual : cola) {
            		System.out.printf("%s \n", productoActual.toString());
            	}
            }
		}
	
	private void mostrarProductosMap() throws IOException {
		
	}
	
	private void mayorAñoFabricacion() throws IOException {
		int tope = listaProductos.size();
		int indice = 0;
		Integer[] vectorAnho = new Integer[tope];
		String codigoProducto;
		Set<String> lista = listaProductos.keySet();
		Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
        	codigoProducto = it.next();
        	 if (listaProductos.containsKey(codigoProducto)) {
        		 Producto productoActual = listaProductos.get(codigoProducto) ;
        		 vectorAnho[indice] = productoActual.getAnhoFabricacion();
        	 }
        	 indice ++;
        }
        Integer maximo =  maximo(vectorAnho[]);
        System.out.println("El mayor año de fabricación es: " + maximo);
	}
	
	public static < T extends Comparable < T>> T maximo(T[] x){
		T max = x[0];
        for (int i = 1; i <x.length; i ++) {
        	if (x[i].compareTo(max) > 0 ) {
        		max = x[i];
        	}
        		
        }
		return max;
	}
}
