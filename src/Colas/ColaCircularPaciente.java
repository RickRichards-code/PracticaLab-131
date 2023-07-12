package Colas;

public class ColaCircularPaciente {
    private int max = 150;
    private Paciente v[] = new Paciente[max + 1];
    private int ini, fin;

    ColaCircularPaciente() {
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

    void adicionar(Paciente elem) {
        if (!esllena()) {
            fin = (fin + 1) % max;
            v[fin] = elem;
        } else {
            System.out.println("Cola circular llena");
        }
    }

    Paciente eliminar() {
        Paciente elem = new Paciente();
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
            ColaCircularPaciente aux = new ColaCircularPaciente();
            while (!esvacia()) {
                Paciente elem = eliminar();
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
            Paciente elem = new Paciente();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(ColaCircularPaciente a) {
        while (!a.esvacia())
            adicionar(a.eliminar());
    }

    // leer datos y generar codigo
    void leerDatosGenerarCodigo() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- ingrese los datos el paciente ---");
            System.out.print("ingrese el nombre del paciente: ");
            String nombre = Leer.dato();
            System.out.print("ingrese el sexo del paciente: ");
            String sexo = Leer.dato();
            System.out.print("ingrese la edad del paciente: ");
            int edad = Leer.datoInt();
            String cod = nombre.substring(0, 2) + 0 + 0 + i;
            Paciente elem = new Paciente(nombre, sexo, cod, edad);
            adicionar(elem);
        }
    }


    // generar codigo deacuerdo a las 2 primeros caractes del nombre y el numero de pacientes
    ColaCircularCad generarCodigo() {
        int c = 1;
        ColaCircularPaciente aux = new ColaCircularPaciente();
        ColaCircularCad codigos = new ColaCircularCad();
        while (!esvacia()) {
            Paciente elem = eliminar();
            aux.adicionar(elem);
            String nombre = elem.getNombre();
            codigos.adicionar(nombre.substring(0, 2) + 0 + 0 + c);
            c++;
        }
        vaciar(aux);
        return (codigos);
    }

    // inciso F)

    void mostrarCantidadHombresMujeres() {
        int h = 0, m = 0;
        ColaCircularPaciente aux = new ColaCircularPaciente();
        while (!esvacia()) {
            Paciente e = eliminar();
            if (e.getSexo().equals("m")) {
                h++;
            } else {
                m++;
            }
            aux.adicionar(e);
        }
        System.out.println("\n--- mostrar cuantas mujeres y hombres son atendidos ---");
        System.out.println("hombres: " + h);
        System.out.println("mujeres: " + m);
        vaciar(aux);
    }


}
