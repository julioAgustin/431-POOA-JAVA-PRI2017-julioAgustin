/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicataller0;

/**
 *
 * @author user
 */
class Producto implements Comparable<Producto>{
   private String nombre;
   private String fabricante;
   private Integer anhoFabricacion;
   private Integer precioUnitario;
   private Integer cantidad;

    public Producto(String nombre, String fabricante, Integer anhoFabricacion, Integer precioUnitario, Integer cantidad) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.anhoFabricacion = anhoFabricacion;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }
    
    public Producto()
    {}
   
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
   
 
 public Integer totales(){/*metodo para clacular el precio por cantidad*/
     Integer total;
     total = this.getCantidad()*this.getPrecioUnitario();
     return total;
 }   

    @Override
    public String toString() {
        return "Producto (" 
                + " nombre = " 
                + this.getNombre() 
                + ", fabricante = " 
                + this.getFabricante()
                + ", anhoFabricacion = " 
                + this.getAnhoFabricacion()
                + ", precioUnitario = " 
                + this.getPrecioUnitario()
                + ", cantidad = " 
                + this.getCantidad()
                  + ", totales = " 
                + this.totales()
                + ')';
    }

    @Override
    public int compareTo(Producto o) {
        if (this.getPrecioUnitario() < o.getPrecioUnitario() ){
            return 1;
        }
        if (this.getPrecioUnitario() > o.getPrecioUnitario()){
            return -1;
        }
            return 0;
    }
 
 
    
    
    
    
    
    
    
    
    
}
