package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class Marcas {
    Conexion cn = new Conexion();   
    
    public void insertar(String Marca) {
        cn.UID("INSERT INTO vehi_marcas(Marca)value ('" + Marca + "')");
    }
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT id_marca,Marca FROM vehi_marcas"));
    }
}
