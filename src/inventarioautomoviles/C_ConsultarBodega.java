package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class C_ConsultarBodega {    
    Conexion cn = new Conexion();
    public ResultSet llenarTablaMarcaModelo() {
        return (cn.getVal("SELECT vehi_marcas.id_marca, vehi_marcas.Marca, vehi_modelos.id_modelo, vehi_modelos.Modelo FROM (vehi_marcas INNER JOIN vehi_modelos ON vehi_marcas.id_marca = vehi_modelos.id_marca) ORDER BY id_marca asc,id_modelo asc"));
    }
    public ResultSet llenarTablaMarcaModeloVersion() {
        return (cn.getVal("SELECT vehi_marcas.id_marca,vehi_marcas.Marca,vehi_modelos.id_modelo,vehi_modelos.Modelo,vehi_versiones.id_Version,vehi_versiones.Version,vehi_versiones.Color FROM ( vehi_marcas INNER JOIN vehi_modelos ON vehi_modelos.id_marca=vehi_marcas.id_marca INNER JOIN vehi_versiones ON vehi_versiones.id_marca=vehi_marcas.id_marca) ORDER BY id_marca asc,id_modelo asc,id_version asc"));
    }
}
