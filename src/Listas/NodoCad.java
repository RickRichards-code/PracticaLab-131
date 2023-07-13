package Listas;

public class NodoCad {
    private String dato;
    private NodoCad sig;

    public NodoCad() {
        dato = "";
        sig = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoCad getSig() {
        return sig;
    }

    public void setSig(NodoCad sig) {
        this.sig = sig;
    }
}
