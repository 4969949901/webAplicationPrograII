
package Clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    
    private String url="jdbc:mysql://127.0.0.1:3306/datouniversidad";//url de MySQL
    private String usuario="root";// usuario de mysql local
    private String clave="H2023sql"; 
    private Connection conexion=null;  
    
    public Connection conectar(){   
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection( url, usuario,clave);
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {   
           ex.printStackTrace();
        }         
        return conexion;        
    }
    
}
