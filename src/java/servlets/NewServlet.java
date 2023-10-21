
package servlets;


import Clases.Alumno;
import Clases.AlumnoController;
import Clases.ConexionBaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
       Alumno alumno;
       AlumnoController registroAlumno;
       Alumno[] alumnosRegistrados;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {response.setContentType("text/html");
        try ( PrintWriter respuesta = response.getWriter()) {  
              respuesta.write("Se muestran datos:      ");
              respuesta.write("codigo , nombre, direccion, correo, tipo");
           registroAlumno=new AlumnoController();
           String control = request.getParameter("control");
           StringBuffer objetoRespuesta = new StringBuffer();
           if(control.toUpperCase().equals("GUARDAR")){
    //se crea el objeto alumnos con los datos recibidos del navegador a traves de la petición HTTP
               alumno=new Alumno(
                Integer.parseInt(request.getParameter("codigo")),
                request.getParameter("nombre"),
                request.getParameter("correo"),
                request.getParameter("direccion"),
                Integer.parseInt(request.getParameter("genero")));                
                registroAlumno.guardarAlumno(alumno);//almacenarlo en BD                 
           }else if(control.toUpperCase().equals("ELIMINAR")){
               int codigoEliminar= Integer.parseInt(request.getParameter("codigo_alumno"));
               registroAlumno.eliminarALumno(codigoEliminar);
           }    
           registroAlumno.getAlumnos(objetoRespuesta);//consultar alumnos en la BD
           respuesta.write(objetoRespuesta.toString()); 
           
        
                      
            
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}