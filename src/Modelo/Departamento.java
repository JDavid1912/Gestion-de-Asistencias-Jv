package Modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private static ArrayList<Asignatura> asignaturas = null;
    private static Departamento instancia = null;
    private static ArrayList<Estudiante> estudiantes = null;

    public Departamento() {
        this.asignaturas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public Departamento(String nombre, ArrayList<Asignatura> asignaturas){
        this.nombre = "Ingenieria de Sistemas";
        this.asignaturas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Asignatura> getAsignaturas() {
        if (asignaturas == null){
            asignaturas = new ArrayList<>();
        }
        return asignaturas;
    }

    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }


    public void agregarEstudianteFacultad(String nombres, String identificacion, String tipoId){

        Estudiante estudiante = new Estudiante(nombres, identificacion, tipoId, "0");

        estudiantes.add(estudiante);
    }

    public Estudiante ConsultarEstudianteFacultad(String identificacion){
        for(Estudiante este : estudiantes){
            if(este.getIdentificacion().equalsIgnoreCase(identificacion)){
                return este;
            }
        }
        return null;
    }

    public boolean modificarEstFacultad(String identificacion, String nEWNombre, String nuevoTipoID){

        for(Estudiante e: estudiantes){
            if(e.getIdentificacion().equalsIgnoreCase(identificacion)){
                e.setNombre(nEWNombre);
                e.setTipoID(nuevoTipoID);
                return true;
            }
        }
        return false;

    }


    public boolean agregarAsignatura(String nombre, int creditos, String codigo, String grupo, String semestre) {
        Asignatura asignatura = new Asignatura(codigo, grupo, semestre, nombre, creditos);
        return getAsignaturas().add(asignatura);
    }

    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre){
        for (Asignatura a : asignaturas){
            if (a.getCodigo().equals(codigo) && a.getGrupo().equals(grupo) && a.getSemestre().equals(semestre)){
                return a;
            }
        }
        return null;
    }


    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Asignatura asignatura = this.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);
            return true;
        }
        return false;
    }


    public boolean eliminarAsignatura(String codigo, String grupo, String semestre) {
        for (int vc = 0; vc < asignaturas.size(); vc++) {
            Asignatura copia = asignaturas.get(vc);
            if (copia.getCodigo().equalsIgnoreCase(codigo) && copia.getGrupo().equalsIgnoreCase(grupo) && copia.getSemestre().equalsIgnoreCase(semestre)) {
                asignaturas.remove(vc);
                return true;
            }
        }
        return false;
    }
}
