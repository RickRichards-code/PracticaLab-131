package Colas;

public class Historial {
    private String codigoPaciente;
    private int trauma, ginecologia, cirugia, dermatologia;

    public Historial() {
    }

    public Historial(String codigoPaciente, int trauma, int ginecologia, int cirugia, int dermatologia) {
        this.codigoPaciente = codigoPaciente;
        this.trauma = trauma;
        this.ginecologia = ginecologia;
        this.cirugia = cirugia;
        this.dermatologia = dermatologia;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public int getTrauma() {
        return trauma;
    }

    public void setTrauma(int trauma) {
        this.trauma = trauma;
    }

    public int getGinecologia() {
        return ginecologia;
    }

    public void setGinecologia(int ginecologia) {
        this.ginecologia = ginecologia;
    }

    public int getCirugia() {
        return cirugia;
    }

    public void setCirugia(int cirugia) {
        this.cirugia = cirugia;
    }

    public int getDermatologia() {
        return dermatologia;
    }

    public void setDermatologia(int dermatologia) {
        this.dermatologia = dermatologia;
    }

    void mostrar() {
        System.out.println("--- Datos del Historial ---");
        System.out.println("Codigo: " + codigoPaciente);
        System.out.println("Trauma: " + trauma);
        System.out.println("Ginecologia: " + ginecologia);
        System.out.println("Cirugia: " + cirugia);
        System.out.println("Dermatologia: " + dermatologia);
    }

    void leer() {
        System.out.println("--- leer datos del historial ---");
        System.out.print("Codigo: ");
        codigoPaciente = Leer.dato();
        System.out.print("Trauma: ");
        trauma = Leer.datoInt();
        System.out.print("Ginecologia: ");
        ginecologia = Leer.datoInt();
        System.out.print("Cirugia: ");
        cirugia = Leer.datoInt();
        System.out.print("Dermatologia: ");
        dermatologia = Leer.datoInt();
    }

}
