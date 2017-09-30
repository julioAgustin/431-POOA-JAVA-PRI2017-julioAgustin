package hilos;

public class CreadorSubproceso {
    
    public static void main (String[] args){
        System.out.println("Creador de subprocesos");
        Thread subproceso1 = new Thread (new TareaImprimir("tarea1"));
        Thread subproceso2 = new Thread (new TareaImprimir("tarea2"));
        Thread subproceso3 = new Thread (new TareaImprimir("tarea3"));
        System.out.println("Subprocesos creados, indicando tareas.");
        subproceso1.start();
        subproceso2.start();
        subproceso3.start();
        
        System.out.println("Tareas iniciadas, main terminada.\n");
    }
    
}
