package edu.ujcv.progra2;

import java.util.ArrayList;
import java.util.Scanner;

public class clases {

    private String clases;
    private String hora;

    public String getMaestro() {
        return Maestro;
    }

    public void setMaestro(String maestro) {
        Maestro = maestro;
    }

    private String Maestro;

    public clases(String clases, String hora, String Maestro){
        this.clases = clases;
        this.hora = hora;
        this.Maestro = Maestro;
    }
    public clases()
    {

    }

    public static void Lista(ArrayList<clases> b) {

        for (int i = 0; i < b.size(); i++) {
            System.out.println((i+1)+". Clase: " + b.get(i).getClases() + " " + "Hora: " + b.get(i).getHora() + " " + "Maestro: " + b.get(i).getMaestro());
        }
    }
    public static String NumeroDeClase(ArrayList<clases> b, int i) {
        String p ="clase: " + b.get(i).getClases() + " " + "Hora: " + b.get(i).getHora() + " " + "Maestro: " + b.get(i).getMaestro();
        return p;
    }
    public static clases obtenerClases() {

        Scanner sc = new Scanner(System.in);

        System.out.println("ingrese la nueva clase");
        String clase = sc.nextLine();
        System.out.println("ingrese la hora de la clase");
        String hora = sc.nextLine();
        System.out.println("Ingrese el nombre del Maestro");
        String Maestro= sc.nextLine();
        return new clases(clase,hora,Maestro);
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getClases() {
        return clases;
    }

    public void setClases(String clases) {
        this.clases = clases;
    }

    public String toString(){
        return clases+"..........\t"+hora;
    }
}
