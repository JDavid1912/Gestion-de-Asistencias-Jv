package Controlador;

import Modelo.Asignatura;
import Modelo.Asistencia;
import Modelo.Departamento;
import Modelo.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class Elcontrolador {
    private Departamento departamento = null;
    //Constructora sin parámetro
    public Elcontrolador() {
        this.departamento = Departamento.singleton();
    }
    //GETTERS and SETTERS
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


    //CREATE
    public boolean nombrarDepartamento(String nombre) {
        departamento.setNombre(nombre);
        return true;
    }
    //READ
    public String consultarNombreDepartamento(){
        return departamento.getNombre();
    }


    public Estudiante consultarEstFacultad(String identificacion){
        return departamento.ConsultarEstudianteFacultad(identificacion);
    }

    public boolean modificarEstFacultad(String identificacion, String Nuevo_nombre, String Nuevo_Tipo){
        return departamento.modificarEstFacultad(identificacion, Nuevo_nombre, Nuevo_Tipo);
    }



    //UPDATE
    public boolean modificarDepartamento(String nuevo_nombre){

        departamento.setNombre(nuevo_nombre);
        return true;
    }


    //CRUD para Asignatura
    //CREATE
    public boolean agregarAsignatura(String nombre, String creditos, String codigo, String grupo, String semestre){
        departamento.agregarAsignatura(nombre, Integer.parseInt(creditos), codigo, grupo, semestre);
        return true;
    }
    //READ
    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre){
        return departamento.consultarAsignatura(codigo, grupo, semestre);
    }
    //UPDATE
    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, String creditos){
        departamento.modificarAsignatura(codigo, grupo, semestre, nombre, Integer.parseInt(creditos));
        return true;
    }

    //DELETE
    public boolean eliminarAsignatura(String codigo, String grupo, String semestre){
        departamento.eliminarAsignatura(codigo,grupo,semestre);
        return true;
    }

    //CRUD para Asistencia

    public boolean adicionarAsistencia(String codigo, String grupo, String semestre, String fecha, String horaInicio, String horaFinal, ArrayList<String> codigosEstudiantes, ArrayList<String> estados){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura != null){
            return asignatura.adicionarAsistencia(fecha, horaInicio, horaFinal, codigosEstudiantes, estados);
        }
        return false;
    }

    public Asistencia consultarAsistencia(String codigo, String grupo, String semestre, String fecha, String horaInicio, String horaFinal){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura != null){
            return asignatura.consultarAsistencia(fecha, horaInicio, horaFinal);
        }
        return null;
    }

    public boolean modificarAsistencia(String codigo, String grupo, String semestre, String fecha, String hora_de_inicio, String hora_final, String nuevaFecha, String nuevaHora_de_inicio, String nuevaHora_final, ArrayList<String> codigos, ArrayList<String> estados){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura!=null){
            boolean resultado = asignatura.modificarAsistencia(fecha,hora_de_inicio,hora_final,nuevaFecha,nuevaHora_de_inicio,nuevaHora_final,codigos,estados);
            return resultado;
        }
        return false;
    }





    public boolean agregarEstudiante(String codigo, String grupo, String semestre, String codigoEst, String nombres, String tipoDC){
        Asignatura asig = departamento.consultarAsignatura(codigo, grupo, semestre);
        if (asig != null) {
            return asig.adicionarEstudiante(nombres, codigoEst, tipoDC);

        } else {
            System.out.println(" Asignatura no encontrada.");
            return false;
        }
    }

    public boolean eliminarEstudiante(String codigo, String grupo, String semestre, String identificacion){
        Asignatura asig = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asig != null){
            asig.eliminarEstudiante(identificacion);
            return true;
        }else{
            return false;
        }
    }

    public List<Estudiante> consultarEstudianteAsignatura(String codigo, String grupo, String semestre){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);

        if(asignatura!= null){
            return asignatura.consultarEstudiantesAsig();
        }
        return null;
    }



    public boolean AgregarEstudianteFacultad(String nombre, String identificacion, String tipoId){
        departamento.agregarEstudianteFacultad(nombre, identificacion, tipoId);
        return true;
    }


    public void crearListaVacia(String codigo, String semestre, String grupo, String fecha, String horaInicio, String horaFinal){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);

        asignatura.generarLista(fecha, horaInicio, horaFinal);

    }
}