package Colas;

public class Libro {
    private String nombreLibro;
    private String editorial;
    private String autor;
    private int anio;

    public Libro() {
    }

    public void leer() {
        System.out.println("\n---------- ingrese datos ----------");
        System.out.print("ingrese nombre del libro: ");
        nombreLibro = Leer.dato();
        System.out.print("ingrese editorial: ");
        editorial = Leer.dato();
        System.out.print("ingrese autor: ");
        autor = Leer.dato();
        System.out.print("ingrese anio: ");
        anio = Leer.datoInt();

    }

    public void mostrar() {
        System.out.println("\n---------- datos ----------");
        System.out.println("nombre del libro: " + nombreLibro);
        System.out.println("editorial: " + editorial);
        System.out.println("autor: " + autor);
        System.out.println("anio: " + anio);
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
