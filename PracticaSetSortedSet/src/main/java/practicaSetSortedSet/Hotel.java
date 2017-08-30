package practicaSetSortedSet;

import java.io.IOException;
import java.util.Objects;

public class Hotel implements Comparable<Hotel> {
	
	private Integer codigoHotel;
	private String nombre;
	private String zona;
	private Integer precio;
	
	public Hotel(){
		
	}

	public Hotel(Integer codigoHotel, String nombre, String zona, Integer precio) {
		super();
		this.codigoHotel = codigoHotel;
		this.nombre = nombre;
		this.zona = zona;
		this.precio = precio;
	}

	

	public Integer getCodigoHotel() {
		return codigoHotel;
	}

	public void setCodigoHotel(Integer codigoHotel) {
		this.codigoHotel = codigoHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	
	
	public static void main(String[] args) {
		Operaciones operaciones = new Operaciones();
		try {
			operaciones.menu();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
    public String toString () {
        return "Codigo Hotel: " + codigoHotel + " Nombre: " + nombre + " Zona: " + zona + " Precio: " + precio + "\n";
    }

    @Override
    public int compareTo(Hotel t) {
        return this.precio - t.precio;
    }
    
    @Override
    public int hashCode() {
        return codigoHotel + nombre.hashCode() + zona.hashCode() + precio.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Hotel other = (Hotel) obj;
        if (!this.precio.equals(other.precio)) {
            return false;
        }
        
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        
        if (!this.zona.equals(other.zona)) {
            return false;
        }
        
        return true;
    }
}
