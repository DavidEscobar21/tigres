package edu.ujcv.progra2;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;




public class Main {

    public static void main(String[] args) throws IOException {
       AlumnosController ac= new AlumnosController();
       ac.presentMenuObtenerResultado();


    }

    public static <T>void initArray(T[]array, T elemento){
        for (int i = 0; i < array.length; i++) {
            array[i] = elemento;
        }
    }

    public static <T>T[] concatArray(T[] array, T[] array2){
        T[] retval = (T[])new Object[array.length + array2.length];

        int midpoint = 0;

        //System.arraycopy(array,0,retval,0,array.length);
        //System.arraycopy(array2,0,retval,array.length,array2.length);
        for (int i = 0; i < array.length; i++) {
            retval[i] = array[i];
            midpoint++;
        }

        for (int i = 0; i <array2.length ; i++) {

            retval[midpoint+i] = array2[i];

        }

        return retval;

    }
    public static <T>T[] intercalar(T[] a1, T[] a2){
        T[] retval = (T[])new Object[a1.length+ a2.length];

        int min = Math.min(a1.length,a2.length);
        for (int i = 0 ; i < min ; i++) {
            retval[i*2] = a1[i];
            retval[i*2+1] = a2[i];
        }
        if(a1.length< a2.length){
            System.arraycopy(a2,a1.length,retval,a1.length * 2, a2.length - a1.length);
        }else
        {
            System.arraycopy(a1,a2.length,retval,a2.length * 2,a1.length - a2.length);
        }
        return retval;
    }

    public static <T>void printArray(T[] a){

        if(a == null)
            return;

        for (int i = 0; i < a.length; i++) {
            if(i == a.length -1)
                System.out.print(a[i]);
            else
                System.out.print(a[i]+", ");
        }
        System.out.println();
    }

    public static <T>T[] separar(T[] a1, T[] a2){
        int tamano= 0;

        for (int i = 0; i < a1.length; i++) {
            boolean cuento = true;
            for (int j = i; j < a2.length ; j++) {
                if(a1[i] == a2[j]){
                    cuento = false;
                    break;
                }
            }
            if(cuento && i < a2.length) tamano++;

        }

        T[] retval = (T[])new Object[tamano];

        for (int i = 0, k = 0; i < a1.length; i++) {
            boolean agrego = true;
            for (int j = i; j < a2.length ; j++) {
                if(a1[i] == a2[j]){
                    agrego = false;
                    break;
                }
            }
            if(agrego && i < a2.length) retval[k++] = a1[i];

        }



        return  retval;
    }



}

