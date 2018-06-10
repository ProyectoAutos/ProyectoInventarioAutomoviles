package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class Marcas_Modelos {    
    Conexion cn = new Conexion();
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT vehi_marcas.id_marca, vehi_marcas.Marca, vehi_modelos.id_modelo, vehi_modelos.Modelo FROM (vehi_marcas INNER JOIN vehi_modelos ON vehi_marcas.id_marca = vehi_modelos.id_marca) ORDER BY id_marca asc,id_modelo asc"));
    }
}
