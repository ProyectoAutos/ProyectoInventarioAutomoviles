
package inventarioautomoviles;

import java.sql.ResultSet;
public class C_Clientes {
    C_Conexion cn = new C_Conexion();  
    public void nuevoCliente(String id_cliente,String Nombres,String Apellidos,String Direccion,String DUI,String Nit,String Passport,int tel1,int tel2,int tel3,String HistorialCrediticio){        
      cn.UID("insert into clientes values('"+ id_cliente+"','"+Nombres+"','"+Apellidos+"','"+Direccion+"','"+DUI+"','"+Nit+"','"+Passport+"','"+tel1+"','"+tel2+"','"+tel3+"','"+HistorialCrediticio+"')");
    }
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT * FROM clientes"));
    }
    public ResultSet contarRegistros() {
        return (cn.getVal("SELECT COUNT(id_cliente) FROM clientes"));
    }
}
