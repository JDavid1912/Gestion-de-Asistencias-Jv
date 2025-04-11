package Modelo;

public class Estudiante {
    private String Nombre = "";
    private String Identificacion = "";
    private String TipoID = "";
    private String Estado;



    public Estudiante(String nombre, String identificacion, String TipoID, String estado ){
        this.Nombre = nombre;
        this.Identificacion = identificacion;
        this.TipoID = TipoID;
        this.Estado = estado;
    }

    //Constructora sin parámetros
    public Estudiante(){
    }

    //Getters and Setters
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        Nombre= Nombre;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.Identificacion = identificacion;
    }
    public String getTipoID() {
        return TipoID;
    }
    public void setTipoID(String TipoID) {
        this.TipoID = TipoID;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre + ", Identificación: " + Identificacion;
    }

}