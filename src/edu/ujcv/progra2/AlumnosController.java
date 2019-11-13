package edu.ujcv.progra2;

import java.util.ArrayList;
import java.util.Scanner;

public class AlumnosController {
    private AlumnosView view;
    private AlumnosModel model;
    Scanner sc = new Scanner(System.in);
    ArrayList<clases> Lista1 = new ArrayList<>(10);

    public void AlumnosController() {

    }

    public AlumnosController() {
        view = new AlumnosView();
        model = new AlumnosModel();
    }

    void presentarListaAlumnos() {
        view.verLista(model.getAlumnos());
    }

    void presentMenuObtenerResultado() {
        ArrayList<clases> Lista1 = new ArrayList<>(10);
        Lista1.add(new clases("PROGRAMACION 2", "6:50 - 8:40","Kenneth Vitettoe"));
        Lista1.add(new clases("ESTRUCTURA DE DATOS", "9:50 - 10:40","Kenneth Vitettoe"));
        Lista1.add(new clases("MATEMATICAS", "10:50 - 11:40","Alejandro Arita"));
        Lista1.add(new clases("Ecologia", "11:50 - 12:40","Maria paguada"));
        // obtener opcion
        int opcion;
        do {
            view.presentarMenuAlumnos();
            opcion = leerEntero(sc, "", "Ha ingresado un caracter no valido");
            String Clase1,Clase2,Clase3 = "";
            int Num =0;
            switch (opcion) {
                case 1: {
                    System.out.println("Nombre");
                    String nombre = obtenerNombre();
                    System.out.println("Apellido");
                    String Apellido = obtenerApellido();
                    System.out.println("#cuenta");
                    String cuenta = obtenerNumeroDeCuenta();
                    clases.Lista(Lista1);
                    System.out.println("Clase 1");
//                    Num = leerEntero(sc, "Ingrese una opcion", "Ha ingresado un caracter no valido");
                    do{
                        Num = leerEntero(sc, "Solo puede ingresar un numero del 1 al "+ Lista1.size(), "Ha ingresado un caracter no valido");
                    } while(Num > Lista1.size());
                    Clase1 = clases.NumeroDeClase(Lista1, Num - 1);
                    System.out.println("");
                    clases.Lista(Lista1);
                    System.out.println("Clase 2");
                    do{
                        Num = leerEntero(sc, "Solo puede ingresar un numero del 1 al "+ Lista1.size(), "Ha ingresado un caracter no valido");
                    } while(Num > Lista1.size());
                    Clase2 = clases.NumeroDeClase(Lista1, Num - 1);
                    while(Clase1.equals(Clase2)){
                        System.out.println("No puede matricular dos veces la misma clase ");
                        Num = leerEntero(sc, "Ingrese una opcion", "Ha ingresado un caracter no valido");
                        Clase2 = clases.NumeroDeClase(Lista1, Num - 1);
                    }
                    System.out.println("");
                    clases.Lista(Lista1);
                    System.out.println("Clase 3");
                    do{
                        Num = leerEntero(sc, "Solo puede ingresar un numero del 1 al"+ Lista1.size(), "Ha ingresado un caracter no valido");
                    } while(Num > Lista1.size());
                    Clase3 = clases.NumeroDeClase(Lista1, Num - 1);
                    while(Clase3.equals(Clase1) || Clase3.equals(Clase2) ){
                        System.out.println("No puede matricular dos veces la misma clase ");
                        Num = leerEntero(sc, "Ingrese una opcion", "Ha ingresado un caracter no valido");
                        Clase3 = clases.NumeroDeClase(Lista1, Num - 1);
                    }
                    model.createAlumno(nombre, Apellido, cuenta, Clase1, Clase2, Clase3);

                    break;
                }
                case 2: {
                    presentarListaAlumnos();
                    break;
                }
                case 3:{
                    view.verLista(model.getAlumnos());
                    System.out.println("");
                    System.out.println("Ingrese el indice del alumno que desea elminiar");
                    model.deleteAlumno(sc.nextInt() - 1);
                    break;}
                case 4: {
                    Lista1.add(clases.obtenerClases());
                    break;
                }
                case 5:{
                    clases.Lista(Lista1);
                    int z = leerEntero(sc, "Ingrese una opcion", "Ha ingresado un caracter no valido");
                    z = z-1;
                    Lista1.remove(z);
                    break;}
                case 6:{
                    break;
                }
                default: {
                    System.out.println("Escoja una opcion correcta");
                }
            }
        } while (opcion != 6);

    }

    private String obtenerApellido() {
        return sc.nextLine();
    }

    private String obtenerNumeroDeCuenta() {
        return sc.nextLine();
    }

    private String obtenerNombre() {
        return sc.nextLine();
    }



    public static int leerEntero(Scanner sc,String mensaje, String mensajeError) {
        int retval = 0;
        System.out.println(mensaje);
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println(mensajeError);
        }
        retval = sc.nextInt();
        sc.nextLine();
        return retval;
    }}


