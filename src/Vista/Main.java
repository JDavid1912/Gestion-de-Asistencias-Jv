package Vista;

import Controlador.Elcontrolador;
import Modelo.Asignatura;
import Modelo.Asistencia;
import Modelo.Departamento;
import Modelo.Estudiante;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Elcontrolador ControlvAR = new Elcontrolador();
        String opcion = "";
        String nombre = "";


        while (!opcion.equals("15")) {
            System.out.println("--------------------------------------------------------");
            System.out.println("Bienvenido");
            System.out.println("Menu Principal");
            System.out.println("\n Seleccione una opción");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Consultar nombre del departamento");
            System.out.println("2. Modificar nombre del departamento");
            System.out.println("3.Agregar estudiante a departamento");
            System.out.println("4.Consultar estudiante por departamento");
            System.out.println("5. Modificar estudiante por departamento");
            System.out.println("6. Adicionar Asignatura");
            System.out.println("7. Consultar Asignatura");
            System.out.println("8. Modificar Asignatura");//Listo
            System.out.println("9. Registrar Estudiante en Asignatura");
            System.out.println("10. Consultar Estudiante en Asignatura");
            System.out.println("11. Crear Lista de Asistencia");
            System.out.println("12. Llenar Asistencias");//Devuelve los arreglos,pide la asignatura:3,la fecha,la hora de inicio,la hora final
            System.out.println("13. Modificar Asistencias");//Devuelve los arreglos ASISTENCIA 2,pide la asignatura:3,la fecha,la hora de inicio,la hora final
            System.out.println("14. Lista Asistencia");//Devuelve los arreglos ASISTENCIA 2,pide la asignatura:3,la fecha,la hora de inicio,la hora final
            System.out.println("15. Salir");//Asitencia 2 ,Asignatura 3
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextLine();


            if (opcion.equals("1")) {
                System.out.println("::::::::::Consultar nombre del departamento::::::::::::");
                nombre = ControlvAR.consultarNombreDepartamento();
                System.out.println("Nombre del departamento: " + Departamento.singleton().getNombre());

            } else if (opcion.equals("2")) {
                System.out.println("::::::::::Modificar nombre del departamento::::::::::::");
                System.out.println("Ingrese el nuevo nombre del departamento");
                nombre = entrada.nextLine();
                ControlvAR.modificarDepartamento(nombre);

            } else if (opcion.equals("3")) {
                System.out.println("::::::::::Agregar Estudiantes A Facultad:::::::::::::");

                System.out.println("Ingresa los nombres: ");
                String nombres = entrada.nextLine();

                System.out.println("Ingrese la identificacion: ");
                String identificacion = entrada.nextLine();

                System.out.println("Ingrese el tipo de ID: ");
                String tipoID = entrada.nextLine();


                ControlvAR.AgregarEstudianteFacultad(nombres, identificacion, tipoID);

            } else if (opcion.equals("4")) {
                System.out.println("::::::::::Consultar Estudiantes por departamento::::::::::::");

                System.out.println("Ingresa el documento del estudiante a consultar");
                String com = entrada.nextLine();

                System.out.println(ControlvAR.consultarEstFacultad(com));

            } else if (opcion.equals("5")) {
                System.out.println("::::::::::Modificar Estudiantes por departamento::::::::::::");


                System.out.println("Ingresa el codigo del estudiante a modificar");
                String codigo = entrada.nextLine();

                Estudiante estudiante = ControlvAR.consultarEstFacultad(codigo);

                if (estudiante != null) {
                    System.out.println("Ingresa el nuevo nombre del estudiante ");
                    String nuevoname = entrada.nextLine();

                    System.out.println("Ingresa el nuevo tipo de documento del estudiante ");
                    String nuevo_tipo = entrada.nextLine();

                    ControlvAR.modificarEstFacultad(codigo, nuevoname, nuevo_tipo);
                } else {
                    System.out.println("No se encontro al estudiante, intenta de nuevo ");
                }


            } else if (opcion.equals("6")) {
                System.out.println("::::::::::Agregar Asignatura::::::::::::");
                System.out.print("Ingrese el nombre: ");
                String name = entrada.nextLine();
                System.out.print("Ingrese los créditos: ");
                String creditos = entrada.nextLine();
                System.out.print("Ingrese el código: ");
                String codigo = entrada.nextLine();
                System.out.print("Ingrese el Grupo: ");
                String grupo = entrada.nextLine();
                System.out.print("Ingrese el Semestre: ");
                String semestre = entrada.nextLine();
                ControlvAR.agregarAsignatura(name, creditos, codigo, grupo, semestre);
                System.out.println("La asignatura fue agregada con éxito");

            } else if (opcion.equals("7")) {
                System.out.println("::::::::::Consultar Asignatura::::::::::::");
                System.out.print("Ingrese el código: ");
                String Consulta = entrada.nextLine();
                System.out.print("Ingrese el Grupo: ");
                String grupoConsulta = entrada.nextLine();
                System.out.print("Ingrese el Semestre: ");
                String semConsulta = entrada.nextLine();
                Asignatura encontrada = ControlvAR.consultarAsignatura(Consulta, grupoConsulta, semConsulta);
                if (encontrada != null) {
                    System.out.println("Asignatura encontrada:");
                    System.out.println(encontrada);
                } else {
                    System.out.println("Asignatura no encontrada.");
                }

            } else if (opcion.equals("8")) {
                System.out.println("::::::::::Modificar Asignatura::::::::::::");
                System.out.print("Ingrese el código: ");
                String codModi = entrada.nextLine();
                System.out.print("Ingrese el grupo: ");
                String grupoModi = entrada.nextLine();
                System.out.print("Ingrese el Semestre: ");
                String semModi = entrada.nextLine();
                System.out.print("Ingrese el Nuevo Nombre: ");
                String nuevoNombre = entrada.nextLine();
                System.out.print("Ingrese los nuevos Créditos: ");
                String nuevosCreditos = entrada.nextLine();
                ControlvAR.modificarAsignatura(codModi, grupoModi, semModi, nuevoNombre, nuevosCreditos);
                System.out.println("La asignatura se modificó con éxito");


            } else if (opcion.equals("9")) {
                System.out.println("::::::::::Agregar Estudiante a Asignatura::::::::::::");
                System.out.println("Ingresa el codigo del estudiante a agregar, recuerda que debe estar registrado en facultad");
                String codigo = entrada.nextLine();

                Estudiante est = ControlvAR.consultarEstFacultad(codigo);
                if (est != null) {
                    System.out.println("Ingresa el grupo de la asignatura");
                    String grupo = entrada.nextLine();

                    System.out.println("Ingresa el semestre de la asignatura");
                    String semestre = entrada.nextLine();

                    System.out.println("Ingresa el codigo de la asignatura");
                    String codigoA = entrada.nextLine();

                    String nombres = est.getNombre();
                    String tipoDC = est.getTipoID();

                    ControlvAR.agregarEstudiante(codigoA, grupo, semestre, codigo, nombres, tipoDC);

                } else {
                    System.out.println("El estudiante no se encuentra registrado en la facultad. ");
                }


            } else if (opcion.equals("10")) {
                System.out.println("::::::::::Consultar Estudiante en Asignatura::::::::::::");
                System.out.println("Ingresa el codigo de la asignatura: ");
                String codigo = entrada.nextLine();

                System.out.println("Ingresa el semestre de la asignatura: ");
                String semestre = entrada.nextLine();

                System.out.println("Ingresa el grupo de la asignatura: ");
                String grupo = entrada.nextLine();

                System.out.println(ControlvAR.consultarEstudianteAsignatura(codigo, grupo, semestre));

            } else if (opcion.equals("11")) {
                System.out.println("::::::::::Crear Lista de Asistencia::::::::::::");

                System.out.println("Ingresa el codigo de la materia: ");
                String codigo = entrada.nextLine();

                System.out.println("Ingresa el grupo de la materia: ");
                String grupo = entrada.nextLine();

                System.out.println("Ingresa el semestre ");
                String semestre = entrada.nextLine();

                Asignatura asignatura = ControlvAR.consultarAsignatura(codigo, grupo, semestre);

                if (asignatura != null) {

                    System.out.println("Ingresa la fecha DD/MM/AAAA");
                    String fecha = entrada.nextLine();

                    System.out.println("Ingresa la hora de inicio");
                    String horainicio = entrada.nextLine();

                    System.out.println("Ingresa la hora final ");
                    String horafinal = entrada.nextLine();

                    ControlvAR.crearListaVacia(codigo, semestre, grupo, fecha, horainicio, horafinal);

                } else {
                    System.out.println("La asignatura no existe, no es posible crear lista de asistencia");
                }

            } else if (opcion.equals("12")) {

                System.out.println("===== REGISTRAR ASISTENCIA =====");

                System.out.print("Ingrese el código de la asignatura: ");
                String codigo = entrada.nextLine();

                System.out.print("Ingrese el semestre: ");
                String semestre = entrada.nextLine();

                System.out.print("Ingrese el grupo: ");
                String grupo = entrada.nextLine();

                Asignatura asignatura = ControlvAR.consultarAsignatura(codigo, grupo, semestre);

                if (asignatura != null) {
                    System.out.print("Ingrese la fecha de asistencia (DD/MM/AAAA): ");
                    String fecha = entrada.nextLine();


                    ArrayList<Asistencia> asistencias = asignatura.getListaAsistencias();
                    boolean encontrada = false;

                    for (Asistencia asistencia : asistencias) {
                        if (asistencia.getFecha().equals(fecha)) {
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        System.out.print("Ingrese la hora de inicio (HH:mm): ");
                        String horaInicio =entrada.nextLine();

                        System.out.print("Ingrese la hora final (HH:mm): ");
                        String horaFinal = entrada.nextLine();


                        ArrayList<String> codigos = new ArrayList<>();
                        ArrayList<String> estados = new ArrayList<>();

                        for (Estudiante estudiante : asignatura.getEstudiantes()) {
                            System.out.println("Estudiante: " + estudiante.getNombre() + " (" + estudiante.getIdentificacion() + ")");
                            System.out.print("Ingrese estado (0: Presente, 1: Tarde, 2: No llegó): ");
                            String estado = entrada.nextLine();

                            codigos.add(estudiante.getIdentificacion());
                            estados.add(estado);
                        }


                        asignatura.registrarAsistencia(fecha, horaInicio, horaFinal, codigos, estados);
                        System.out.println("Asistencia registrada correctamente.");
                    } else {
                        System.out.println("Ya existe una lista de asistencia para esa fecha.");
                    }

                } else {
                    System.out.println("Asignatura no encontrada.");
                }


            } else if (opcion.equals("13")) {

                System.out.println("::::::::::Modificar Asistencias::::::::::::");

                System.out.println("Ingrese el código de la asignatura: ");
                String codigo = entrada.nextLine();

                System.out.println("Ingrese el semestre: ");
                String semestre = entrada.nextLine();

                System.out.println("Ingrese el grupo: ");
                String grupo = entrada.nextLine();

                Asignatura asignatura = ControlvAR.consultarAsignatura(codigo, grupo, semestre);

                if (asignatura != null) {
                    System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
                    String fecha = entrada.nextLine();

                    System.out.println("Ingrese el código del estudiante a modificar: ");
                    String codigoEstudiante = entrada.nextLine();

                    System.out.println("Ingrese el nuevo estado (0: Ausente, 1: Presente,  2: Llego tarde): ");
                    String nuevoEstado = entrada.nextLine();

                    asignatura.editarEstado(fecha, codigoEstudiante, nuevoEstado);
                }

            } else if (opcion.equals("14")) {
                System.out.println("::::::::::Consultar Asistencias::::::::::::");

                System.out.println("Ingresa el codigo de la asignatura");
                String codigo = entrada.nextLine();

                System.out.println("Ingresa el semestre");
                String semestre = entrada.nextLine();

                System.out.println("Ingresa el grupo");
                String grupo = entrada.nextLine();

                Asignatura asig = ControlvAR.consultarAsignatura(codigo, grupo, semestre);

                if (asig != null) {
                    asig.mostrarAsistencias();
                } else {
                    System.out.println("La asignatura no existe");
                }

            } else if (opcion.equals("15")) {
                System.out.println("Saliendo del Sistema....");
            }else {
                System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
}


