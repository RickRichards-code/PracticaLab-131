package Listas;

public class ListaSimpleCad extends ListaCad {
    public ListaSimpleCad() {
        super();
    }

    boolean vacia() {
        return getP() == null;
    }

    void adicionarPrimero(String dato) {
        NodoCad nodo = new NodoCad();
        nodo.setDato(dato);
        if (vacia()) {
            setP(nodo);
        } else {
            nodo.setSig(getP());
            setP(nodo);
        }
    }

    NodoCad eliminarPrimero() {
        NodoCad q = new NodoCad();
        if (vacia()) {
            if (getP().getSig() == null) {
                q = getP();
                setP(null);
            } else {
                q = getP();
                setP(getP().getSig());
                q.setSig(null);
            }
        } else {
            System.out.println("--- la lista esta vacia ---");
        }
        return q;
    }

    void adcionarUltimo(String dato) {
        NodoCad nodo = new NodoCad();
        nodo.setDato(dato);
        if (vacia()) {
            setP(nodo);
        } else {
            NodoCad q = new NodoCad();
            q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nodo);
        }
    }

    NodoCad eliminarUltimo() {
        NodoCad q = new NodoCad();
        if (vacia()) {
            System.out.println("--- la lista esta vacia ---");
        } else {
            if (getP().getSig() == null) {
                q = getP();
                setP(null);
            } else {
                NodoCad r = new NodoCad();
                r = getP();
                while (r.getSig().getSig() != null) {
                    r = r.getSig();
                }
                q = r.getSig();
                r.setSig(null);
            }
        }
        return q;
    }

    void mostrarLista() {
        NodoCad q = getP();
        System.out.println("\n--- Datos de la lista ---");
        while (q != null) {
            System.out.print(q.getDato() + " -> ");
            q = q.getSig();
        }
        System.out.print("null");
        System.out.println("\n--- fin de la lista ---");
    }


    // ========================================================================
    void llenarTipoPila() {
        System.out.print("ingrese la cantidad de elementos a ingresar: ");
        int cantidad = Leer.datoInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ingrese un elemento: ");
            adicionarPrimero(Leer.dato());
        }
//        System.out.println("------------------------");
    }

    void llenarTipoCola() {
        System.out.print("ingrese la cantidad de elementos a ingresar: ");
        int cantidad = Leer.datoInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ingrese un elemento: ");
            adcionarUltimo(Leer.dato());
        }
//        System.out.println("------------------------");
    }

    int cantidadNumeros() {
        int cantidad = 0;
        NodoCad q = new NodoCad();
        q = getP();
        while (q != null) {
            cantidad++;
            q = q.getSig();
        }
        return cantidad;
    }

    void invertirLista() {
        ListaSimpleCad aux = new ListaSimpleCad();
        while (!vacia()) {
            aux.adicionarPrimero(eliminarPrimero().getDato());
        }
        while (!aux.vacia()) {
            adicionarPrimero(aux.eliminarPrimero().getDato());
        }
    }

    void rotarNumerosDerecha() {
        NodoCad q = new NodoCad();
        q = eliminarUltimo();
        adicionarPrimero(q.getDato());
    }

    void rotarNumerosIzquierda() {
        NodoCad q = new NodoCad();
        q = eliminarPrimero();
        adcionarUltimo(q.getDato());
    }

    void rotarKnodos(int k) {
        if (k > 0 && k < cantidadNumeros()) {
            ListaSimpleCad aux = new ListaSimpleCad();
            for (int i = 0; i < k; i++) {
                aux.adicionarPrimero(eliminarPrimero().getDato());
            }
            aux.rotarNumerosDerecha();
            for (int i = 0; i < k; i++) {
                adicionarPrimero(aux.eliminarPrimero().getDato());
            }
        }
    }

    // agregar x nodos despues del nodo de la posicion K
    void agregarNodosDespuesDe(int k) {
        NodoCad q = getP();

        int contador = 1;

        while (contador < k - 1 && q != null) {
            q = q.getSig(); // nodo antes de K
            contador++;
        }


        if (q != null) {
            NodoCad nodo = q;
            System.out.print("ingrese n: "); // numero nodos antes de K
            int n = Leer.datoInt();

            for (int i = 0; i < n; i++) {
                System.out.print("ingrese un elemento: ");
                String dato = Leer.dato(); // Lee el dato del nuevo nodo
                NodoCad nuevoNodo = new NodoCad();
                nuevoNodo.setDato(dato);
                nuevoNodo.setSig(nodo.getSig());
                nodo.setSig(nuevoNodo);
                nodo = nuevoNodo;
                q = q.getSig();
            }
            q = q.getSig();


            NodoCad nodo1 = q;
            System.out.print("ingrese m: "); // numero nodos despues  de K
            int m = Leer.datoInt();
            for (int i = 0; i < m; i++) {
                System.out.print("ingrese un elemento: ");
                String dato = Leer.dato(); // Lee el dato del nuevo nodo
                NodoCad nuevoNodo = new NodoCad();
                nuevoNodo.setDato(dato);
                nuevoNodo.setSig(nodo1.getSig());
                nodo1.setSig(nuevoNodo);
                nodo1 = nuevoNodo;
            }

        } else {
            System.out.println("La posición K no existe en la lista.");
        }
    }

    // eliminar el nodo en cual su contenido sea igual a x
    void eliminarNodo(String x) {
        NodoCad q = getP();
        NodoCad r = new NodoCad();
        while (q != null) {
            if (q.getDato().equals(x)) {

                NodoCad nodo = q;
                System.out.print("ingrese n: "); // numero nodos despues  de K
                int m = Leer.datoInt();
                for (int i = 0; i < m; i++) {
                    System.out.print("ingrese un elemento: ");
                    String dato = Leer.dato(); // Lee el dato del nuevo nodo
                    NodoCad nuevoNodo = new NodoCad();
                    nuevoNodo.setDato(dato);
                    nuevoNodo.setSig(nodo.getSig());
                    nodo.setSig(nuevoNodo);
                    nodo = nuevoNodo;
                }
                r.setSig(q.getSig());
                q = null;
                break;
            } else {
                r = q;
                q = q.getSig();
            }
        }
    }




}
