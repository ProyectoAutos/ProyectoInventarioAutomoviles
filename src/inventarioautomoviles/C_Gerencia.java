package inventarioautomoviles;

import java.sql.ResultSet;

/**
 *
 * @author Javier
 */
public class C_Gerencia {
    C_Conexion cn = new C_Conexion();
    
    public void insertar(String Nombre,String Direccion,String Email,int Registro,String Nit,int tel, int fax){        
        cn.UID("insert into gerencia values('"+Nombre+"','"+Direccion+"','"+Email+"','"+Registro+"','"+Nit+"','"+tel+"','"+fax+"')");
    }
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT * FROM gerencia"));
    }
    public ResultSet contarRegistros() {
        return (cn.getVal("SELECT COUNT(Nit_g) FROM gerencia"));
    }
    public void editar(String Nombre,String Direccion,String Email,int Registro,int tel, int fax,String Nit_Viejo){        
        cn.UID("update gerencia set NombresEmpresa='"+Nombre+"',Direccion='"+Direccion+"',Email='"+Email+"',Registro='"+Registro+"',Telefono='"+tel+"',Fax='"+fax+"' where nit_g='"+Nit_Viejo+"'");
    }
    public ResultSet NombredeEmpresa() {
        return (cn.getVal("select nombresempresa FROM gerencia"));
    }
}
