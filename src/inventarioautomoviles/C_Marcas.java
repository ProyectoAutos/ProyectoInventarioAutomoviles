package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class C_Marcas {
    C_Conexion cn = new C_Conexion();   
    
    public void insertar(String Marca) {
        cn.UID("INSERT INTO vehi_marcas(Marca)value ('" + Marca + "')");
    }
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT id_marca,Marca FROM vehi_marcas"));
    }
    public ResultSet ConsultaMarca(String id_Marca) {
        return (cn.getVal("SELECT Marca FROM vehi_marcas where id_Marca='"+id_Marca+"'"));
    }
}
