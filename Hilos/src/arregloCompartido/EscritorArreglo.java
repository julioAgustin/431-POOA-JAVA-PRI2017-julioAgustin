package arregloCompartido;

public class EscritorArreglo implements Runnable {
	
	private final ArregloSimple arregloSimpleCompartido;
	private final int valorInicial;
	
	public EscritorArreglo(int valor, ArregloSimple arreglo) {
		valorInicial = valor;
		arregloSimpleCompartido = arreglo;
	}

	@Override
	public void run() {
		for (int i = valorInicial; i < valorInicial + 3; i++ ) {
			arregloSimpleCompartido.agregar(i);
		}
		
	}

}
