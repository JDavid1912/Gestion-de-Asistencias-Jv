package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private String codigo = "";
    private String grupo = "";
    private String semestre = "";
    private String nombre = "";
    private int creditos = 0;
    public ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();
    public ArrayList<Estudiante> estudiantes = new ArrayList<>();



    public Asignatura(String codigo, String grupo, String semestre, String nombre, int creditos){
        this.codigo = codigo;
        this.grupo = grupo;
        this.semestre = semestre;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Asignatura(){

    }

    //GETTERS Y SETTERS
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public ArrayList<Asistencia> getAsistencias() {
        if (asistencias == null){
            return new ArrayList<>();
        }
        return asistencias;
    }
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Asistencia> getListaAsistencias() {
        return asistencias;
    }

    //Adicionar Estudiante
    public boolean adicionarEstudiante(String Nombres, String identificacion, String TipID ){
        Estudiante nuevo = new Estudiante(Nombres, identificacion, TipID, "0");
        estudiantes.add(nuevo);
        return true;
    }
    //Consultar Estudiante
    public List<Estudiante> consultarEstudiantesAsig() {
        return estudiantes;
    }

    public boolean eliminarEstudiante(String identificacion){

        boolean isEncontrado = false;

        for(int i = 0; i < estudiantes.size(); i ++){
            if (estudiantes.get(i).getIdentificacion().equalsIgnoreCase(identificacion)){
                estudiantes.remove(i);
                isEncontrado = true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Información de la asignatura: \nNombre: "+nombre+"\nCódigo: "+codigo+"\nGrupo: "+grupo+"\nSemestre: "+semestre+"\nCréditos: "+creditos;
    }
    //CRUD de asistencias
    //CREATE

    public boolean generarLista(String fecha, String horaInicio, String horaFinal) {
        Asistencia asistencia = new Asistencia(fecha, horaInicio, horaFinal);

        for (Estudiante est : estudiantes) {
            asistencia.adicionarAsistencia(est.getIdentificacion(), "0");
        }

        asistencias.add(asistencia);
        return true;
    }

    public void mostrarAsistencias() {
        if (asistencias.isEmpty()) {
            System.out.println("No hay asistencias registradas.");
            return;
        }

        for (Asistencia asis : asistencias) {
            System.out.println("Fecha: " + asis.getFecha());
            System.out.println("Hora de inicio: " + asis.getHora_de_inicio());
            System.out.println("Hora final: " + asis.getHora_final());
            System.out.println("Estudiantes:");

            ArrayList<String> codigos = asis.getCodigos();
            ArrayList<String> estados = asis.getEstados();

            for (int i = 0; i < codigos.size(); i++) {
                System.out.println(" - " + codigos.get(i) + ": " + estados.get(i));
            }

        }
    }


    public void registrarAsistencia(String fecha, String horaInicio, String horaFinal,
                                    ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia nueva = new Asistencia(fecha, horaInicio, horaFinal);
        for (int i = 0; i < codigos.size(); i++) {
            nueva.adicionarAsistencia(codigos.get(i), estados.get(i));
        }
        asistencias.add(nueva);
    }
    public void editarEstado(String fecha, String codigoEstudiante, String nuevoEstado) {
        for (Asistencia a : asistencias) {
            if (a.getFecha().equals(fecha)) {
                boolean modificado = a.modificarAsistencia(codigoEstudiante, nuevoEstado);
                if (modificado) {
                    System.out.println("Estado del estudiante " + codigoEstudiante + " actualizado.");
                } else {
                    System.out.println("Estudiante no encontrado en esa fecha.");
                }
                return;
            }
        }
        System.out.println("No se encontró asistencia para esa fecha.");
    }

    public boolean adicionarAsistencia(String fecha, String hora_de_incio, String hora_final, ArrayList<String> codigos, ArrayList<String> estados){
        Asistencia asistencia = new Asistencia(fecha, hora_de_incio, hora_final);
        for(int vc = 0; vc<codigos.size();vc++){
            String codigo = codigos.get(vc);
            String estado = estados.get(vc);
            asistencia.adicionarAsistencia(codigo,estado);
        }
        asistencias.add(asistencia);
        return true;
    }
    //READ
    public Asistencia consultarAsistencia(String fecha, String hora_de_inicio, String hora_final){
        for(int vc = 0; vc<asistencias.size();vc++){
            if(asistencias.get(vc).getFecha().equalsIgnoreCase(fecha) && asistencias.get(vc).getHora_de_inicio().equalsIgnoreCase(hora_de_inicio) && asistencias.get(vc).getHora_final().equalsIgnoreCase(hora_final)){
                return asistencias.get(vc);
            }
        }return null;
    }



    //UPDATE
    public boolean modificarAsistencia(String fecha, String hora_de_inicio, String hora_final, String nuevaFecha, String nuevaHora_de_inicio, String nuevaHora_final, ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia asistencias = this.consultarAsistencia(fecha, hora_de_inicio, hora_final);
        if (asistencias != null) {
            asistencias.setFecha(nuevaFecha);
            asistencias.setHora_de_inicio(nuevaHora_de_inicio);
            asistencias.setHora_final(nuevaHora_final);
            asistencias.setCodigos(codigos);
            asistencias.setEstados(estados);
            return true;
        }
        return false;
    }
}