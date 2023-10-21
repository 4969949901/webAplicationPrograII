
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoController {
    Alumno[] tablaALumno;
    int indiceArray;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }       
    
    public String guardarAlumno(Alumno alumno){        
        String sql = "INSERT INTO datouniversidad.alumno(numero_carne, nombre, correo, direccion, genero) ";
             sql += " VALUES(?,?,?,?,?)";              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, alumno.getCodigo());
            statement.setString(2, alumno.getNombre());
            statement.setString(3, alumno.getCorreo());
            statement.setString(4, alumno.getDireccion());
            statement.setInt(5, alumno.getTipo());
                int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    public void getAlumnos(StringBuffer respuesta){   
        String sql="SELECT datouniversidad.alumno.numero_carne, alumno.nombre, alumno.correo, alumno.direccion, genero.descripcion FROM alumno, genero WHERE alumno.genero_idgenero=genero.idgenero ORDER BY nombre asc";
        try{
        abrirConexion();
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if(result!=null){
                while (result.next()){
                respuesta.append("<tr>");//crear la fila y la etique td son las columnas
                respuesta.append("<td >").append(result.getString("numero_carne")).append("</td>");
                respuesta.append("<td >").append(result.getString("nombre")).append("</td>");
                respuesta.append("<td >").append(result.getString("direccion")).append("</td>");
                respuesta.append("<td >").append(result.getString("correo")).append("</td>");
                respuesta.append("<td >").append(result.getString("descripcion")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("genero"))
                        .append("\"  onclick=\"eliminarAlumno(this.id);\">")
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }           
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public String eliminarALumno(int carne){        
        String sql = "DELETE FROM alumno WHERE numero_carne="+carne;              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    // *** FUNCIONALIDAD PARA TRABAJAR CON ARRAYS ***
    public AlumnoController(){// Construcctor para trabar con arrays
        this.tablaALumno = new Alumno[100];
        this.indiceArray=0;
    }
    
     public void guardarAlumnoEnArray(Alumno alumno){
        this.tablaALumno[this.indiceArray]=alumno;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Alumno[] getAlumnosFromArray(){
        return this.tablaALumno;
    }
    
}
