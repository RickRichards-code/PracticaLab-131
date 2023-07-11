package Colas;

import Pilas.Leer;

public class Persona {
    private String nombre;
    private int edad, ci;

    public Persona() {
    }

    public void leer() {
        System.out.println("\n--- ingrese datos ---");
        System.out.print("ingrese nombre: ");
        nombre = Leer.dato();
        System.out.print("ingrese edad: ");
        edad = Leer.datoInt();
        System.out.print("ingrese ci: ");
        ci = Leer.datoInt();
    }

    public void mostrar() {
        System.out.println("\n--- datos ---");
        System.out.println("nombre: " + nombre);
        System.out.println("edad: " + edad);
        System.out.println("ci: " + ci);
    }
}
