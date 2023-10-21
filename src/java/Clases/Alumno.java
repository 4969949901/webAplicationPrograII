
package Clases;

public class Alumno {
    private int codigo;
    private String nombre;
    private String correo;
    private String direccion;
    private int tipo;

    
    public Alumno(int codigo, String nombre, String correo, String direccion, int tipo){
        this.codigo=codigo;
        this.nombre=nombre;
        this.correo=correo;
        this.direccion=direccion;     
        this.tipo=tipo;   
    }
   
    public Alumno(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
        public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
