package hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjecutorTareas {
    public static void main(String args[ ]){
        
    
    System.out.println("Creador de subprocesos");
        TareaImprimir tarea1 = new TareaImprimir("tarea1");
        TareaImprimir tarea2 = new TareaImprimir("tarea2");
        TareaImprimir tarea3 = new TareaImprimir("tarea3");
        System.out.println("Iniciando Excecutor.");
        ExecutorService ejecutorSubprocesos = Executors.newCachedThreadPool();
        ejecutorSubprocesos.execute(tarea1);
        ejecutorSubprocesos.execute(tarea2);
        ejecutorSubprocesos.execute(tarea3);
        
        ejecutorSubprocesos.shutdown();
        System.out.println("Tareas iniciadas, main terminada.\n");
        System.out.println("Ejecutor de tareas terminado.");
        
   }
}
