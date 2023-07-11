package Colas;

import javax.crypto.spec.PSource;

public class ColaCircularProducto {
    final int max;
    final Producto v[];
    int ini, fin, cantidadProducto;

    public ColaCircularProducto() {
        max = 100;
        v = new Producto[max];
        ini = fin = cantidadProducto = 0;
    }

    public void adicionar(Producto elem) {
        if (cantidadProducto >= max) {
            System.out.println("--- La cola esta llena ---");

        } else {
            v[fin] = elem;

            fin = (fin % max) + 1;
            cantidadProducto++;
        }
    }

    Producto eliminar() {
        Producto m = new Producto();
        if (cantidadProducto < 0) {
            System.out.println("--- La cola esta vacia ---");
        } else {

            m = v[ini];
            ini = (ini % max) + 1;
            cantidadProducto--;
        }
        return m;
    }

    public void mostrar() {
        int i = ini;
        while (i != fin) {
            v[i].mostrar();
            i = (i % max) + 1;
        }
    }

    public Producto extraerDescripcion(String n) {
        Producto p = new Producto();
        int cont = 0;
        while (cont < cantidadProducto) {
            Producto p1 = new Producto();
            p1 = eliminar();
            if (p1.getDescripcion().equals(n)) {
                p = p1;
            } else {
                adicionar(p1);
            }
            cont++;
        }
        return p;
    }

    void llenar() {
        System.out.println("ingrese la cantidad de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
            Producto p = new Producto();
            p.leer();
            adicionar(p);
        }
    }

    void comprarProducto() {
        System.out.print("ingrese la cantidad de productos a comprar: ");
        int n = Leer.datoInt();
        int sum = 0;
        double boliviano = 1;
        double realBrasilenio = 1.40;
        double dolar = 6.76;
        double euro = 7.52;
        for (int i = 0; i < n; i++) {
            Producto p = new Producto();
            p.leer();
            sum += p.getPrecionUnitario() * p.getCantidad(); // precio base en bolivianos
            adicionar(p);
        }
        System.out.println("en que moneda quiere pagar: (1) dolar (2) euro (3) real brasilenio (4) boliviano");
        String nom = null;
        double cambio = 0, venta = 0, compra = 0, total = 0;

        ColaCircularMoneda c = new ColaCircularMoneda();
        c.monedas();
        switch (Leer.datoInt()) {
            case 1:
                total = sum * dolar;
                System.out.println("El precio total es: " + sum * dolar + " dolares");
                nom = "dolar";
                cambio = 6.96;
                compra = 7.08;
                venta = 6.76;
                break;
            case 2:
                total = sum * euro;
                System.out.println("El precio total es: " + sum * euro + " euros");
                nom = "euro";
                cambio = 7.50;
                compra = 7.42;
                venta = 7.52;
                break;
            case 3:
                total = sum * realBrasilenio;
                System.out.println("El precio total es: " + sum * realBrasilenio + " reales");
                nom = "real brasilenio";
                cambio = 1.60;
                compra = 1.50;
                venta = 1.40;
                break;
            case 4:
                total = sum * boliviano;
                System.out.println("El precio total es: " + sum * boliviano + " bolivianos");
                nom = "boliviano";
                cambio = 1;
                compra = 1;
                venta = 1;
                break;
        }
        System.out.print("ingrese el dinero disponible en la moneda que escogio: ");
        int dinero = Leer.datoInt();
        if (dinero >= total) {
            System.out.println("--- Su compra fue exitosa ---");
            System.out.println("--- Su vuelto es de: " + (dinero - total) + " ---");
            System.out.println("--- Su vuelto en " + nom + " es de: " + (dinero - total) * cambio + " ---");
        } else {
            System.out.println("tiene otro dinero en otra moneda?...");
            String nom2 = Leer.dato();
            System.out.println("si es asi, ingrese la cantidad de " + nom2 + " que tiene: ");
            int dinero2 = Leer.datoInt();
            convertir(nom2,  nom, dinero2);

            Moneda m = new Moneda();
            if (dinero2 + dinero >= total) {
                System.out.println("--- Su compra fue exitosa ---");
                System.out.println("--- Su vuelto es de: " + (dinero2 + dinero - total) + " ---");
                System.out.println("--- Su vuelto en " + nom + " es de: " + (dinero2 + dinero - total) * cambio + " ---");
            }else {
                System.out.println("--- no se puede completar la compra ---");
            }
        }
    }

    int convertir(String nom, String convert, double dinero) {
        Moneda b = new ModenaBoliviano();
        Moneda r = new MonedaReal();
        Moneda d = new MonedaDolar();
        Moneda e = new MonedaEuro();
        int c = 0;
        if (!(nom.equals("Boliviano"))) {
            if (convert.equals("dolar"))
                dinero = dinero * 6.86;
            else if (convert.equals("euro"))
                dinero = dinero * 7.52;
            else if (convert.equals("real"))
                dinero = dinero * 1.40;
        }
        return c;
    }

}
