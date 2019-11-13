package edu.ujcv.progra2;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;

//Representa el modelo.

public class AlumnosModel {
    private ArrayList<Alumnos> alumnos;
    private int contador = 0;


    public ArrayList<Alumnos> getAlumnos(){
        return alumnos;
    }

    AlumnosModel(){
        alumnos = new ArrayList<>();
        try {
            leerArchivo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void  leerArchivo() throws IOException {
        File file = new File("superData.csv");
        FileReader fileReader = new FileReader(file);

        CsvPreference.Builder builder = new CsvPreference.Builder('\'',',',"\n");
        CsvBeanReader beanReader = new CsvBeanReader(fileReader,CsvPreference.STANDARD_PREFERENCE);

        final String[] header = beanReader.getHeader(true);
        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // name
                new NotNull(), // apellido
                new NotNull(), // #cuenta
                new NotNull(), // Clase1
                new NotNull(), // Clase2
                new NotNull(), // Clase3

        };


        Alumnos alumno = null;

        while ((alumno = beanReader.read(Alumnos.class,header,processors))
                != null){
            alumnos.add(alumno);
        }

        for (int i = 0; i < contador; i++) {
            alumnos.add(alumno);
        }
        beanReader.close();
        fileReader.close();
        file = null;
    }

    public void escribirArchivo(String fileName, ArrayList<Alumnos> alumnos, boolean append){
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";
        String FILE_HEADER = "Name,Apellido,Cuenta,Clase1,Clase2,Clase3";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName,append);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Alumnos alumno : alumnos) {
                fileWriter.append(alumno.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(alumno.getApellido());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(alumno.getNumeroDeCuenta());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(alumno.getClase1());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(alumno.getClase2());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(alumno.getClase3());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }


        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }


    public void createAlumno(String nombre, String Apellido, String NumeroDeCuenta,String Clase1,String Clase2,String Clase3){
        alumnos.add(new Alumnos(nombre,Apellido,NumeroDeCuenta,Clase1,Clase2,Clase3));
        escribirArchivo("superData.csv",alumnos,false);
    }

    public void updateAlumno(int index,String nombre,String apellido,String NumeroDeCuenta){

    }

    public ArrayList<Alumnos> readAlumos(int start, int end){
        return null;
    }

    public Alumnos readAlumno(int index){
        return null;
    }

    public void deleteAlumno(int index){
        System.out.println("Eliminado el alumno "+alumnos.get(index).getName());
        alumnos.remove(index);
        System.out.println("Alumno exitosamente");
        escribirArchivo("superData.csv",alumnos,false);
    }

    public void persist(){
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
