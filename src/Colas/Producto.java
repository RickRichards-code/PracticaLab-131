package Colas;

public class Producto {
    private String descripcion;
    private String marca;
    private double precionUnitario;
    private int cantidad;

    public Producto() {
    }

    public void leer() {
        System.out.println("--- ingrese los datos del producto ---");
        System.out.print("Ingrese descripcion: ");
        descripcion = Leer.dato();
        System.out.print("Ingrese marca: ");
        marca = Leer.dato();
        System.out.print("Ingrese precion unitario: ");
        precionUnitario = Leer.datoDouble();
        System.out.print("Ingrese cantidad: ");
        cantidad = Leer.datoInt();
    }
    public void mostrar(){
        System.out.println("--- datos del producto ---");
        System.out.println("descripcion: " + descripcion);
        System.out.println("marca: " + marca);
        System.out.println("precion unitario: " + precionUnitario);
        System.out.println("cantidad: " + cantidad);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecionUnitario() {
        return precionUnitario;
    }

    public void setPrecionUnitario(double precionUnitario) {
        this.precionUnitario = precionUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
    }
}
