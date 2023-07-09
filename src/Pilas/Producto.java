package Pilas;

public class Producto {
    private String nombre, codigo;
    private double precio;

    public Producto() {
    }

    public void leer() {
        System.out.println("\n--- ingrese datos ---");
        System.out.print("ingrese nombre:");nombre = Leer.dato();
        System.out.print("ingrese codigo:");codigo = Leer.dato();
        System.out.print("ingrese precio:");precio = Leer.datoDouble();
    }

    public void mostrar() {
        System.out.println("\n--- datos ---");
        System.out.println("nombre: " + nombre);
        System.out.println("codigo: " + codigo);
        System.out.println("precio: " + precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
