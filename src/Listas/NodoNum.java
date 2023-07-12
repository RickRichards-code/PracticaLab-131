package Listas;

public class NodoNum {
    private int dato;
    private NodoNum sig;

    public NodoNum() {
        dato = 0;
        sig = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoNum getSig() {
        return sig;
    }

    public void setSig(NodoNum sig) {
        this.sig = sig;
    }
}
