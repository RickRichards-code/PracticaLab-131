package Colas;

public class Moneda {
    private String nombreMoneda;
    private double tipoCambio;
    private double cambioVenta;
    private double cambioCompra;

    public Moneda(String nombreMoneda, double tipoCambio, double cambioVenta, double cambioCompra) {
        this.nombreMoneda = nombreMoneda;
        this.tipoCambio = tipoCambio;
        this.cambioVenta = cambioVenta;
        this.cambioCompra = cambioCompra;
    }

    public Moneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
        this.tipoCambio = 0;
        this.cambioVenta = 0;
        this.cambioCompra = 0;
    }

    public Moneda() {
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public double getCambioVenta() {
        return cambioVenta;
    }

    public void setCambioVenta(double cambioVenta) {
        this.cambioVenta = cambioVenta;
    }

    public double getCambioCompra() {
        return cambioCompra;
    }

    public void setCambioCompra(double cambioCompra) {
        this.cambioCompra = cambioCompra;
    }

    void leer(){
        System.out.println("--- ingrese los datos de la moneda ---");
        System.out.println("ingrese nombre de la moneda");
        nombreMoneda = Leer.dato();
        System.out.println("ingrese tipo de cambio");
        tipoCambio = Leer.datoDouble();
        System.out.println("ingrese cambio de venta");
        cambioVenta = Leer.datoDouble();
        System.out.println("ingrese cambio de compra");
        cambioCompra = Leer.datoDouble();
    }
    void mostrar(){
        System.out.println("--- datos de la moneda ---");
        System.out.println("nombre de la moneda: " + nombreMoneda);
        System.out.println("tipo de cambio: " + tipoCambio);
        System.out.println("cambio de venta: " + cambioVenta);
        System.out.println("cambio de compra: " + cambioCompra);
    }


}
