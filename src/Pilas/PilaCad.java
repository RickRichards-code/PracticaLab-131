package Pilas;

public class PilaCad {

    private int max = 100;
    private String v[] = new String[max + 1];
    private int tope;

    PilaCad() {
        tope = 0;
    }

    boolean esvacia() {
        if (tope == 0) {
            return (true);
        }
        return (false);
    }

    boolean esllena() {
        return tope == max;
    }

    int nroelem() {
        return (tope);
    }

    void adicionar(String elem) {
        if (!esllena()) {
            tope++;
            v[tope] = elem;
        } else {
            System.out.println("Pila llena");
        }
    }

    String eliminar() {
        String elem = "";
        if (!esvacia()) {
            elem = v[tope];
            tope--;
        } else {
            System.out.println("Pila vacia");
        }
        return (elem);
    }

    void mostrarPila() {
        String elem;
        if (esvacia()) {
            System.out.println("Pila vacia");
        } else {
            System.out.println("\n--- Datos de la Pila ---");
            var aux = new PilaCad();
            while (!esvacia()) {
                elem = eliminar();
                aux.adicionar(elem);
                System.out.println(elem + " ");
            }
            while (!aux.esvacia()) {
                elem = aux.eliminar();

                adicionar(elem);
            }
        }
    }

    void llenarPila() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ingrese el elemento: ");
            String elem = Leer.dato();
            adicionar(elem);
        }
    }

    void vaciar(PilaCad a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }
    }

    void invertir() {
        PilaCad aux = new PilaCad();
        PilaCad aux2 = new PilaCad();
        while (!esvacia())
            aux.adicionar(eliminar());
        while (!aux.esvacia())
            aux2.adicionar(aux.eliminar());
        while (!aux2.esvacia())
            adicionar(aux2.eliminar());
    }

    void convertirMayusculas() {
        PilaCad aux = new PilaCad();
        while (!esvacia()) {
            String e = eliminar().toUpperCase();
            aux.adicionar(e);
        }
        while (!aux.esvacia())
            adicionar(aux.eliminar());
    }

    void invertirCadena() {
        PilaCad aux = new PilaCad();
        while (!esvacia()) {
            StringBuilder r = new StringBuilder(eliminar());
            aux.adicionar(String.valueOf(r.reverse()));
        }
        vaciar(aux);
    }

    void comprobarCorreo() {
        PilaCad aux = new PilaCad();
        PilaCad aux2 = new PilaCad();
        while (!esvacia()) {
            String e = eliminar();
            if (validar(e))
                aux2.adicionar("valido");
            else
                aux2.adicionar("no valido");
            aux.adicionar(e);
        }
        aux2.mostrarPila();
        while (!aux.esvacia())
            adicionar(aux.eliminar());
    }
    boolean validar(String texto) {
        String c = "^.+@.+\\..+$";
        return texto.matches(c);
    }



    void ordenarAlfabeticamente() {
        PilaCad pilaAux = new PilaCad();

        while (!esvacia()) {
            String elem = eliminar();
            while (!pilaAux.esvacia() && compareTo(elem, pilaAux.obtenerTope()) > 0) {
                adicionar(pilaAux.eliminar());
            }
            pilaAux.adicionar(elem);
        }

        while (!pilaAux.esvacia()) {
            adicionar(pilaAux.eliminar());
        }
        invertir();
    }
    int compareTo(String cadena1, String cadena2) {
        return cadena1.compareTo(cadena2);
    }
    String obtenerTope() {
        return v[tope];
    }


}