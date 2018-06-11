package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class Marcas_Modelo_Versiones {    
    Conexion cn = new Conexion();
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT vehi_marcas.Marca, vehi_modelos.Modelo, vehi_versiones.Version FROM ((vehi_marcas INNER JOIN vehi_modelos ON vehi_marcas.id_marca = vehi_modelos.id_marca) INNER JOIN Vehi_versiones ON vehi_modelos.id_modelo=vehi_versiones.id_modelo) ORDER BY id_marca asc,id_modelo asc,id_version asc"));
    }
}
