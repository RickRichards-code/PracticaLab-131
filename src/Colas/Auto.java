package Colas;

public class Auto {
    private String tipoAuto, codigo;
    private double montoPago;

    public Auto() {
    }

    public void leer() {
        System.out.println("\n--- ingrese datos ---");
        System.out.print("ingrese tipo de Auto: ");
        tipoAuto = Leer.dato();
        System.out.print("ingrese codigo: ");
        codigo = Leer.dato();
        System.out.print("ingrese monto de Pago: ");
        montoPago = Leer.datoDouble();
    }

    public void mostrar() {
        System.out.println("\n--- datos ---");
        System.out.println("tipo de Auto: " + tipoAuto);
        System.out.println("codigo: " + codigo);
        System.out.println("monto de Pago: " + montoPago);
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
