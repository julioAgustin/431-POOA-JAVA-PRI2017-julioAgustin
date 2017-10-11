package practicataller0;

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

/**
 *
 * @author user
 */
class Operar {

    private Map<Integer, Producto> mlistproductos = new Hashtable<Integer, Producto>();
    private Queue<Producto> colapriorida = new PriorityQueue<Producto>();
    private Hashtable<String, Producto> hproducto = new Hashtable<String, Producto>();
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public void menu() throws IOException {
        int opcion = 0;
        while (opcion != 8) {
            /* try {*/
            System.out.println("--ESCOJA UNA OPCION--");
            System.out.println("1-> AGREGAR PRODUCTO");
            System.out.println("2-> MODIFICAR DATO PRODUCTO");
            System.out.println("3-> ELIMINAR PRODUCTO");
            System.out.println("4-> MOSTRAR lISTA DE PRODUCTOS");
            System.out.println("5-> Mayor Año de fabricacion");
            System.out.println("6-> Imprimir Productos Ord p Precio");
            System.out.println("7-> SALIR");
            opcion = Integer.parseInt(entrada.readLine());
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    modificarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    imprimirListaNormal();
                    break;
                case 5:
                    mayorFabric();
                    break;
                case 6:
                    mostrarProductoPrecioUnitario();
                    break;
                //case 7:
                //    listarPolizas();
                //    break;
                case 7:
                    Salir();
                    break;
                default:
                    System.out.println("Error codigo invalido");
                    break;
            }
        }
    }

    private void agregarProducto() throws IOException {
        try {
            System.out.println("Ingrese los datos PRODUCTO: ");
            System.out.print("CODIGO: ");
            Integer codProducto = Integer.parseInt(entrada.readLine());
            if (mlistproductos.containsKey(codProducto)) {
                System.out.println("YA EXISTE EL PRODUCTO ");
                return;
            }
//            System.out.print("NOMBRE de Producto: ");
//            String nombre = entrada.readLine();
//            System.out.print("FABRICANTE: ");
//            String fabricante = entrada.readLine();
//            System.out.print("AÑO de FABRICACION: ");
//            Integer anhoFabricacion = Integer.parseInt(entrada.readLine());
//            System.out.print("PRECIO UNITARIO: ");
//            Integer precioUnitario = Integer.parseInt(entrada.readLine());
//            System.out.print("CANTIDAD: ");
//            Integer cantidad = Integer.parseInt(entrada.readLine());
//            mlistproductos.put(codProducto,new Producto(
//                                nombre,fabricante,
//                                anhoFabricacion,
//                                precioUnitario,cantidad));
            Producto p = crear();
            mlistproductos.put(codProducto, p);

            System.out.println("Se ha agregado el Producto");
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("El tipo de dato no es el correcto");
        }
    }

    private void modificarProducto() throws IOException {
        System.out.println("Ingrese CODIGO de Producto: ");
        System.out.print("CODIGO: ");
        Integer codProducto = Integer.parseInt(entrada.readLine());
        Set<Integer> listI = mlistproductos.keySet();
        Iterator<Integer> iter = listI.iterator();
        /**
         * ****************************************************
         */
        while (iter.hasNext()) {
            if (mlistproductos.containsKey(codProducto)) {
                Integer indic = iter.next();
                Producto productoViejo = mlistproductos.get(indic);
                Producto productoNuevo = crear();
                mlistproductos.replace(indic, productoViejo, productoNuevo);
            }
        }

    }

    private void eliminarProducto() throws IOException {

        Integer codProducto;
        System.out.print("\n ***** MODIFICANDO PRODUCTOS ***** \n");
        System.out.print("\nCódigo Producto: ");
        codProducto = Integer.parseInt(entrada.readLine());
        Set<Integer> lista = mlistproductos.keySet();
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            if (mlistproductos.containsKey(codProducto)) {
                it.remove();
                break;
            }
        }

    }

    private void mostrarProductoPrecioUnitario() {
        System.out.print("\n ***** MOSTRANDO PRODUCTOS ORDENADOS***** \n");
        Set<Integer> listI = mlistproductos.keySet();
        Iterator<Integer> iter = listI.iterator();
        Integer codProductoIndice;
        while (iter.hasNext()) {
            //obtener la clave dle mapa
            codProductoIndice = iter.next();
            // obtener el objeto relacionado por la clave
            Producto e = mlistproductos.get(codProductoIndice);
            //añadiendo a la cola
            colapriorida.add(e);
        }

        
        while(!colapriorida.isEmpty()){
            Producto a = colapriorida.remove();
            System.out.printf("%s \n ",a.toString());;
            
        }
    }

    private  void mayorFabric() {
        int tamanhoMapa=mlistproductos.size();
        Integer[] mayorFabric = null;
        Set<Integer> listI = mlistproductos.keySet();
        Iterator<Integer> iter = listI.iterator();
        Integer codProducto;
        int indice=0;
        for (int i = 0; i <tamanhoMapa; i++) {
            mayorFabric[indice]= 0;
        }
        
        while (iter.hasNext()) {
            if(indice <tamanhoMapa){
            codProducto = iter.next();
            Producto productoActual =  mlistproductos.get(codProducto);
            mayorFabric[indice]= productoActual.getAnhoFabricacion();
            }
            indice++;
        }
        Integer maximo=maximo(mayorFabric);
        System.out.println("El año de mayor fabricación es"+maximo);
    }

    private void Salir() {
        System.out.println("*****FIN DEL PROGRAMA*****");
    }

    private void imprimirListaNormal() {
        System.out.print("\n ***** MOSTRANDO PRODUCTOS ***** \n");
        Set<Integer> listI = mlistproductos.keySet();
        Iterator<Integer> iter = listI.iterator();
        Integer codProducto;
        while (iter.hasNext()) {
            codProducto = iter.next();
            Producto productoActual = mlistproductos.get(codProducto);
            System.out.printf("%d, %s \n ", codProducto, productoActual.toString());
        }

    }

    private Producto crear() throws IOException {
        System.out.print("NOMBRE de Producto: ");
        String nombre = entrada.readLine();
        System.out.print("FABRICANTE: ");
        String fabricante = entrada.readLine();
        System.out.print("AÑO de FABRICACION: ");
        Integer anhoFabricacion = Integer.parseInt(entrada.readLine());
        System.out.print("PRECIO UNITARIO: ");
        Integer precioUnitario = Integer.parseInt(entrada.readLine());
        System.out.print("CANTIDAD: ");
        Integer cantidad = Integer.parseInt(entrada.readLine());
        return new Producto(
                nombre, fabricante,
                anhoFabricacion,
                precioUnitario, cantidad);
    } 
    
    public static <T extends Comparable<T>> T maximo(T []x){
        T max = x[0];
        for (int i = 0; i < x.length; i++) {
           if(x[i].compareTo(max) > 0){
               max=x[i]; 
           }
            
        }
        return max;
        
    }
}
