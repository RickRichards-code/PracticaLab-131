package Colas;

public class Paciente {
    private String nombre, sexo, codigo;
    private int edad;

    public Paciente() {
    }

    public Paciente(String nombre, String sexo, String codigo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.codigo = codigo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    void mostrar() {
        System.out.println("--- Datos del paciente ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Sexo: " + sexo);
        System.out.println("Codigo: " + codigo);
        System.out.println("Edad: " + edad);
    }
    void leer(){
        System.out.println("Ingrese los datos del paciente");
        System.out.print("Nombre: ");
        nombre = Leer.dato();
        System.out.print("Sexo: ");
        sexo = Leer.dato();
        System.out.print("Codigo: ");
        codigo = Leer.dato();
        System.out.print("Edad: ");
        edad = Leer.datoInt();
    }
}
