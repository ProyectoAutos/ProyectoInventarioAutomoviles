/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class C_Versiones {
    Conexion cn = new Conexion();   
    
    public void insertar(int id_modelo, int id_marca,String version, String Color) {
        cn.UID("INSERT INTO vehi_versiones(id_marca,id_modelo,version,color) value ('"+id_marca+"','"+id_modelo+"','"+version+"','"+Color+"')");
    }
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT id_marca,Marca FROM vehi_marcas"));
    }

    public ResultSet mayorRegistro() {
        return (cn.getVal("SELECT MAX(id_modelo) FROM vehi_versiones"));
    }
}
