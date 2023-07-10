package Colas;

public class Estudiante {
    private String nombre;
    private char genero;
    private int edad;
    private int ci;

    public Estudiante() {
    }

    public void leer() {
        System.out.println("\n--- ingrese datos ---");
        System.out.print("ingrese nombre: ");
        nombre = Leer.dato();
        System.out.print("ingrese genero: ");
        genero = Leer.datoChar();
        System.out.print("ingrese edad: ");
        edad = Leer.datoInt();
        System.out.print("ingrese ci: ");
        ci = Leer.datoInt();
    }

    public void mostrar() {
        System.out.println("\n--- datos ---");
        System.out.println("nombre: " + nombre);
        System.out.println("genero: " + genero);
        System.out.println("edad: " + edad);
        System.out.println("ci: " + ci);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
