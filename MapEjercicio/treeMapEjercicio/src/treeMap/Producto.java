package treeMap;

public class Producto implements Comparable<Producto> {
	
	private String nombre;
	private String fabricante;
	private Integer anhoFabricacion;
	private Integer precioUnitario;
	private Integer cantidad;
	
	public Producto() {
		
	}
	
	public Producto(String codProducto, String nombre, String fabricante, Integer anhoFabricacion,
			Integer precioUnitario, Integer cantidad) {
		super();
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.anhoFabricacion = anhoFabricacion;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getAnhoFabricacion() {
		return anhoFabricacion;
	}

	public void setAnhoFabricacion(Integer anhoFabricacion) {
		this.anhoFabricacion = anhoFabricacion;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static void main(String[] args) {
		

	}

	@Override
	public int compareTo(Producto p) {
		if(this.getPrecioUnitario().compareTo(p.getPrecioUnitario())== 0){
			return 0;
		}else if(this.getPrecioUnitario().compareTo(p.getPrecioUnitario())> 0){
			return -1;
		}
			return 1;
	}
		

	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		
		return super.hashCode();
	}

	@Override
	public String toString() {
		
		return super.toString();
	}
	

}
