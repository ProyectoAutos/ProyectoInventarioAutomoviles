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
public class Modelos {
    Conexion cn = new Conexion();   
    
    public void insertar(int id_modelo, int id_marca,String modelo) {
        cn.UID("INSERT INTO vehi_modelos(id_modelo,id_marca,modelo) value ('"+id_modelo+"','"+id_marca+"','"+modelo+"')");
    }
    public ResultSet contarRegistros() {
        return (cn.getVal("SELECT COUNT(id_modelo) FROM vehi_modelos"));
    }

    public ResultSet mayorRegistroDondeMarcaEs(int id_marca) {
        return (cn.getVal("SELECT MAX(id_modelo) FROM vehi_modelos where id_marca='"+id_marca+"'"));
    }
    
    public ResultSet mayorRegistro() {
        return (cn.getVal("SELECT MAX(id_modelo) FROM vehi_modelos"));
    }
    
    public ResultSet llenarTabla(int id_marca) {
        return (cn.getVal("SELECT id_modelo,modelo FROM vehi_modelos where id_marca='"+id_marca+"'"));
    }
    public ResultSet llenaridMarcasConModelos() {
        return (cn.getVal("SELECT distinct id_marca FROM vehi_modelos"));
    }
    
}
