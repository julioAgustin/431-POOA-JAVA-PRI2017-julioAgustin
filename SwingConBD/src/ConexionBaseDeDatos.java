
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author alumno-204
 */
public class ConexionBaseDeDatos {
    private Connection baseDeDatos = null;
    private String driverBD = "org.postgresql.Driver";
    private String host = "jdbc:postgresql://localhost:5432/prueba";
    private String usuario = "postgres";
    private String pass = "@lumno123";
    
    // para agregar alguna libreria (este caso para la conexion a base de datos postgres que seria jdbc postgreslq)
    // ir a Bibliotecas, click derecho "agregar biblioteca" y se selecciona Driver JDBC PostgreSQL
    
    public Connection conectarBD() throws SQLException{
        try {
            // el forName busca el driver y carga el mismo (carga al driver manager)
            Class.forName(driverBD);
            // el driverManager busca la libreria y permite realizar la conexion
            baseDeDatos = DriverManager.getConnection(host, usuario, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return baseDeDatos;
    }
    
    public void cerrarBD() throws SQLException{
        if(baseDeDatos != null){
            baseDeDatos.close();
        } 
    }
    
    public boolean insertarBD(String producto, String fabricante, Integer cantidad) throws SQLException{
        String sql = "INSERT INTO public.productos(descripcion, fabricante, cantidad) VALUES (?, ?, ?);";
        PreparedStatement st = baseDeDatos.prepareStatement(sql);
        
        st.setString(1, producto);
        st.setString(2, fabricante);
        st.setInt(3, cantidad);
        // el executeUpdate retorna el numero de registros que se inserto
        int cantidadRegistros = st.executeUpdate();
        st.close();
        // si la cantidad de resgitros es 0 quiere decir que no se inserto nada
        if(cantidadRegistros == 0){
            return false;
        }
        
        return true;
    }
    
    public ResultSet obtenerDatos(String sql, String valores) throws SQLException{
        // la sentencia se pasa por parametro
        // se pasa desde Productos.java para poder reutilizar la sentencia en Productos.java
        PreparedStatement st = baseDeDatos.prepareStatement(sql);
        if(valores != null && !valores.isEmpty()) {
            String [] valorObtenido = valores.split("-");
            for (int i = 0; i < valorObtenido.length; i++) {
                st.setString(i+1, valorObtenido[i]);
            }
        }
        return st.executeQuery();
    }
    
    public void eliminarDatos(Integer id) throws SQLException{
        String sql = "DELETE FROM public.productos WHERE id_producto = ?";
        PreparedStatement st = baseDeDatos.prepareStatement(sql);
        st.setInt(1, id);
        st.executeUpdate();
    }
    
}
