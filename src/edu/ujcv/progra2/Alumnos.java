package edu.ujcv.progra2;

//pojo
public class Alumnos {
    private String name;
    private String Apellido;
    private String NumeroDeCuenta;
    private String Clase1;
    private String Clase2;
    private String Clase3;


    public String getClase1() {
        return Clase1;
    }

    public void setClase1(String clase1) {
        this.Clase1 = clase1;

    }
    public String getClase2() {
        return Clase2;
    }

    public void setClase2(String clase2) {
        this.Clase2 = clase2;

    }
    public String getClase3() {
        return Clase3;
    }

    public void setClase3(String clase3) {
        this.Clase3 = clase3;

    }


    public String getNumeroDeCuenta() {
        return NumeroDeCuenta;
    }

    public void setCuenta(String numeroDeCuenta) {
        NumeroDeCuenta = numeroDeCuenta;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public Alumnos(String name, String Apellido, String NumeroDeCuenta,String Clase1,String Clase2,String Clase3){
        this.name = name;
        this.Apellido = Apellido;
        this.NumeroDeCuenta = NumeroDeCuenta;
        this.Clase1 = Clase1;
        this.Clase2 = Clase2;
        this.Clase3 = Clase3;
    }

    public Alumnos()
    {

    }

    public String toString(){
        return name+",\t"+ Apellido+",\t"+NumeroDeCuenta+",   "+ Clase1+",\t"+ Clase2+",\t"+Clase3;
    }


}
