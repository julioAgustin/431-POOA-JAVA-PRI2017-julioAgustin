package arregloCompartido;

import java.util.Random;

public class ArregloSimple {
    private final int arreglo[];
    private int indiceEscritura = 0;
    private final static Random generador = new Random();
    
    public ArregloSimple(int tamanio){
        arreglo = new int[tamanio];
    }
    public void agregar(int valor){
        int posicion = indiceEscritura;
        try{
            Thread.sleep(generador.nextInt(500));
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        arreglo [posicion] = valor;
        System.out.printf("%s escribio %2d en elemento %d.\n",
                Thread.currentThread().getName(), valor, posicion);
        indiceEscritura ++;
        System.out.printf("Siguiente indice de escritura: %d\n", indiceEscritura);
            
    }
    public String toString(){
        String cadenaArreglo = "\nContenido de ArregloSimple: \n";
        for (int i = 0; i < arreglo.length; i++ ){
            cadenaArreglo += arreglo[i] + " ";
        }
        return cadenaArreglo;
    }
}
