package edu.ujcv.progra2;

import java.util.ArrayList;

public class AlumnosView {

    void presentarMenuAlumnos(){
        System.out.println(" Menu Alumnos!");
        System.out.println("1.Matricular");
        System.out.println("2.Ver alumnos Matriculados");
        System.out.println("3.Eliminar alumno Matriculados");
        System.out.println("4.agregar clase");
        System.out.println("5.Eliminar clase");
        System.out.println("6.salir");
    }


    void verLista(ArrayList<Alumnos> alumnos){
        System.out.println("\t\tAlumnos:");
        System.out.println("#,\tnombre, \tApellido, \tNumeroDeCuenta, \tClase1, \tClase2, \tClase3");
        int i = 1;
        for (Alumnos alumno : alumnos){
            System.out.println(""+(i++)+"\t"+alumno);
        }
    }
}
