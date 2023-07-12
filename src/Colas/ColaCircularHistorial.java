package Colas;

public class ColaCircularHistorial {
    private int max = 150;
    private Historial v[] = new Historial[max + 1];
    private int ini, fin;

    ColaCircularHistorial() {
        ini = fin = 0;
    }

    int nroelem() {
        return ((max + fin - ini) % max);
    }

    boolean esvacia() {
        if (nroelem() == 0) {
            return (true);
        }
        return (false);
    }

    boolean esllena() {
        if (nroelem() == max - 1) {
            return (true);
        }
        return (false);
    }

    void adicionar(Historial elem) {
        if (!esllena()) {
            fin = (fin + 1) % max;
            v[fin] = elem;
        } else {
            System.out.println("Cola circular llena");
        }
    }

    Historial eliminar() {
        Historial elem = new Historial();
        if (!esvacia()) {
            ini = (ini + 1) % max;
            elem = v[ini];
            if (nroelem() == 0) {
                ini = fin = 0;
            }
        } else {
            System.out.println("Cola circular vacia");
        }
        return (elem);
    }

    void mostrarCola() {
        if (esvacia()) {
            System.out.println("Cola vacia ");
        } else {
            System.out.println("\n--- Datos Cola Circular ---");
            ColaCircularHistorial aux = new ColaCircularHistorial();
            while (!esvacia()) {
                Historial elem = eliminar();
                aux.adicionar(elem);
                elem.mostrar();
            }
            vaciar(aux);
        }
    }

    // llenar cola
    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 1; i <= n; i++) {
            Historial elem = new Historial();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(ColaCircularHistorial a) {
        while (!a.esvacia())
            adicionar(a.eliminar());
    }

    // a)
    void generarHistorial(ColaCircularPaciente codigos) {
        ColaCircularHistorial aux = new ColaCircularHistorial();
        while (!codigos.esvacia()) {
            String cod = codigos.eliminar().getCodigo();
            System.out.println("ingrese el costo del trauma para el paciente con codigo: " + cod);
            int t = Leer.datoInt();
            System.out.println("ingrese el costo del ginecologia para el paciente con codigo: " + cod);
            int g = Leer.datoInt();
            System.out.println("ingrese el costo del cirugia para el paciente con codigo: " + cod);
            int c = Leer.datoInt();
            System.out.println("ingrese el costo del dermatologia para el paciente con codigo: " + cod);
            int d = Leer.datoInt();
            Historial h = new Historial(cod, t, g, c, d);
            aux.adicionar(h);
        }
        vaciar(aux);
    }

    // funcion que genera un numero ramdom entre 0 y 1000
    int generarNumero() {
        int num = (int) (Math.random() * 1000);
        return num;
    }


    // incisos b, c, d, e
    void incisosBCDE() {
        int t = 0, g = 0, c = 0, d = 0, count = 0, total = 0;
        int t1 = 0, g1 = 0, c1 = 0, d1 = 0;
        ColaCircularHistorial aux = new ColaCircularHistorial();
        while (!esvacia()) {
            Historial e = eliminar();
            t = t + e.getTrauma();
            t1++;
            g = g + e.getGinecologia();
            g1++;
            c = c + e.getCirugia();
            c1++;
            d = d + e.getDermatologia();
            d1++;
            total = total + t + g + c + d;
            count++;
            aux.adicionar(e);
        }
        System.out.println("\n--- mostrar por especialidad la cantidad que son atendidos y el ingreso que se registra ---");
        System.out.println("cantidad de atentidos: trauma: " + t1 + " | ginecologia: " + g1 + " | cirugia: " + c1 + " | dermatologia: " + d1);
        System.out.println("ingresoso: trauma: " + t + " | ginecologia: " + g + " | cirugia: " + c + " | dermatologia: " + d);

        System.out.println("\n--- mostrar el total de ingresos en todas las especialidades ---");
        System.out.println("total ingresos: " + total);

        System.out.println("\n--- mostrar la especialidad que mas ingresos genera ---");
        int maximo = maximo(t, g, c, d);
        if (maximo == t) {
            System.out.println("trauma");
        } else if (maximo == g) {
            System.out.println("ginecologia");
        } else if (maximo == c) {
            System.out.println("cirugia");
        } else if (maximo == d) {
            System.out.println("dermatologia");
        }

        System.out.println("\n--- mostrar la especialidad que menos ingresos genera ---");
        int minimo = minimo(t, g, c, d);
        if (minimo == t) {
            System.out.println("trauma");
        } else if (minimo == g) {
            System.out.println("ginecologia");
        } else if (minimo == c) {
            System.out.println("cirugia");
        } else if (minimo == d) {
            System.out.println("dermatologia");
        }
    }

    // funcnion maximo de 4 numeros
    int maximo(int a, int b, int c, int d) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }
        return max;
    }

    int minimo(int a, int b, int c, int d) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        if (d < min) {
            min = d;
        }
        return min;
    }

    // inciso g
    /// mostrar la especialidad que menos consultas tiene
    void especialidadMenosConsultas() {
        System.out.println("\n---- mostrar la especialidad que menos consultas tiene ----");
        ColaCircularHistorial h = new ColaCircularHistorial();
        int t = 0, g = 0, c = 0, d = 0;
        while (!esvacia()) {
            Historial e = eliminar();
            if (e.getTrauma() == 0)
                t++;
            if (e.getGinecologia() == 0)
                g++;
            if (e.getCirugia() == 0)
                c++;
            if (e.getDermatologia() == 0)
                d++;
            h.adicionar(e);
        }
        vaciar(h);
        System.out.println("\n--- mostrar la especialidad que mas ingresos genera ---");
        int maximo = maximo(t, g, c, d);
        if (maximo == t) {
            System.out.println("trauma, es la especialidad que menos consultas tiene");
        } else if (maximo == g) {
            System.out.println("ginecologia, es la especialidad que menos consultas tiene");
        } else if (maximo == c) {
            System.out.println("cirugia, es la especialidad que menos consultas tiene");
        } else if (maximo == d) {
            System.out.println("dermatologia, es la especialidad que menos consultas tiene");
        }
    }


}