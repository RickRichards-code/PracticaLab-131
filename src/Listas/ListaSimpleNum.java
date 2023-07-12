package Listas;

public class ListaSimpleNum extends ListaNum {
    public ListaSimpleNum() {
        super();
    }

    boolean vacia() {
        return getP() == null;
    }

    void adicionarPrimero(int dato) {
        NodoNum nodo = new NodoNum();
        nodo.setDato(dato);
        if (vacia()) {
            setP(nodo);
        } else {
            nodo.setSig(getP());
            setP(nodo);
        }
    }

    NodoNum eliminarPrimero() {
        NodoNum q = new NodoNum();
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

    void adcionarUltimo(int dato) {
        NodoNum nodo = new NodoNum();
        nodo.setDato(dato);
        if (vacia()) {
            setP(nodo);
        } else {
            NodoNum q = new NodoNum();
            q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nodo);
        }
    }

    NodoNum eliminarUltimo() {
        NodoNum q = new NodoNum();
        if (vacia()) {
            System.out.println("--- la lista esta vacia ---");
        } else {
            if (getP().getSig() == null) {
                q = getP();
                setP(null);
            } else {
                NodoNum r = new NodoNum();
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
        NodoNum q = getP();
        System.out.println("--- Datos de la lista ---");
        while (q != null) {
            System.out.print(q.getDato() + "-> ");
            q = q.getSig();
        }
        System.out.print("null");
        System.out.println("--- fin de la lista ---");
    }


    // ========================================================================
    void llenarTipoPila(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ingrese un elemento: ");
            adicionarPrimero(Leer.datoInt());
        }
        System.out.println("------------------------");
    }

    void llenarTipoCola(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print("ingrese un elemento: ");
            adcionarUltimo(Leer.datoInt());
        }
        System.out.println("------------------------");
    }

    int cantidadNumeros() {
        int cantidad = 0;
        NodoNum q = new NodoNum();
        q = getP();
        while (q != null) {
            cantidad++;
            q = q.getSig();
        }
        return cantidad;
    }

    void invertirLista() {
        ListaSimpleNum aux = new ListaSimpleNum();
        while (!vacia()) {
            aux.adicionarPrimero(eliminarPrimero().getDato());
        }
        while (!aux.vacia()) {
            adicionarPrimero(aux.eliminarPrimero().getDato());
        }
    }

    void rotarNumerosDerecha() {


    }

}