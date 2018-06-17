package inventarioautomoviles;
import java.sql.ResultSet;
public class C_Vendedores {
    Conexion cn = new Conexion();    
    
    public void nuevoVendedor(String Nombres,String Apellidos,String Direccion,String DUI,String Nit,String AFP,int NSS,int tel1,int tel2,int tel3){        
        cn.UID("insert into vendedores values('"+Nombres+"','"+Apellidos+"','"+Direccion+"','"+DUI+"','"+Nit+"','"+AFP+"','"+NSS+"','"+tel1+"','"+tel2+"','"+tel3+"')");
    }
    public ResultSet llenarTabla() {
        return (cn.getVal("SELECT * FROM vendedores"));
    }
    public ResultSet contarRegistros() {
        return (cn.getVal("SELECT COUNT(id_vendedor) FROM vendedores"));
    }
    public void editar(String Nombres,String Apellidos,String Direccion,String DUI,String Nit,String AFP,int NSS,int tel1,int tel2,int tel3, String DUI_Viejo){        
        cn.UID("update gerencia set Nombres='"+Nombres+"',Apellidos='"+Apellidos+"',Direccion='"+Direccion+"',DUI='"+DUI+"',Nit='"+Nit+"',AFP='"+AFP+"',NSS='"+NSS+"',Telefono1='"+tel1+"',Telefono2='"+tel2+"',Telefono3='"+tel3+"'where DUI='"+DUI_Viejo+"'");
    }
}
