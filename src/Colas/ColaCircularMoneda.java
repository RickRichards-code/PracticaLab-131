package Colas;

public class ColaCircularMoneda {
    final int max;
    final Moneda v[];
    int ini, fin, cantidadaMonedas;

    public ColaCircularMoneda() {
        max = 100;
        v = new Moneda[max + 1];
        ini = fin = 0;
        cantidadaMonedas = 0;
    }

    void adicionar(Moneda elem) {
        if (cantidadaMonedas >= max) {
            System.out.println("--- La cola esta llena ---");

        } else {
            v[fin] = elem;
            fin = (fin % max) + 1;
            cantidadaMonedas++;
        }
    }

    Moneda eliminar() {
        Moneda m = new Moneda();
        if (cantidadaMonedas < 0) {
            System.out.println("--- La cola esta vacia ---");
        } else {
            m = v[ini];
            ini = (ini % max) + 1;
            cantidadaMonedas--;
        }
        return m;
    }

    public void mostrar() {
        int cont = 0;
        while (cont < cantidadaMonedas) {
            Moneda m = new Moneda();
            m = eliminar();
            m.mostrar();
            adicionar(m);
            cont++;
        }
    }

    Moneda extraeMoneda(String nm) {
        Moneda m = new Moneda();
        int cont = 0;
        while (cont < cantidadaMonedas) {
            Moneda m1 = new Moneda();
            m1 = eliminar();
            if (nm.equals(m1.getNombreMoneda())) {
                m = m1;
            } else {
                adicionar(m1);
            }
            cont++;
        }
        return m;
    }

    void llenar(int cantidad) {
        System.out.println("ingrese la cantidad de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
            Moneda m = new Moneda();
            m.leer();
            adicionar(m);
        }
    }

    void monedas() {
        Moneda dolar = new MonedaDolar();
        Moneda euro = new MonedaEuro();
        Moneda real = new MonedaReal();
        Moneda boliviano = new ModenaBoliviano();
        adicionar(dolar);
        adicionar(euro);
        adicionar(real);
        adicionar(boliviano);

    }

    void convertir(String nom) {


    }


}
