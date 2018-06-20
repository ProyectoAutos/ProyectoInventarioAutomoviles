/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioautomoviles;

import java.sql.ResultSet;

public class C_Venta {
    C_Conexion cn = new C_Conexion();

    public void BorrarTablaVentas(){
        cn.UID("DROP TABLE IF EXISTS ventas");
    }
    public void EscribirNITGerencial(String NIT_G) {
        cn.UID("ALTER TABLE ventas ALTER COLUMN NIT_G SET DEFAULT '"+NIT_G+"'");
    }
    public ResultSet mayorRegistro() {
        return (cn.getVal("SELECT MAX(id_venta) FROM ventas"));
    }
    public void insertar(String id_Venta,String id_version,String id_cliente,String id_vendedor,String fecha,String giro,String cond_pago,String Observaciones) {
        cn.UID("INSERT INTO marcas (id_Venta,id_version,id_cliente,id_vendedor,fecha,giro,cond_pago,Observaciones) value('"+id_Venta+"','"+id_version+"','"+id_cliente+"','"+id_vendedor+"','"+fecha+"','"+giro+"','"+cond_pago+"','"+Observaciones+"')");
    }
}
