package Listas;

public class Main {
    public static void main(String[] args) {
        ListaSimpleNum lista = new ListaSimpleNum();
        lista.llenarTipoCola();
        lista.mostrarLista();
        System.out.println("\n--- rotar lista ---");
        lista.rotarKnodos(10);
        lista.mostrarLista();

    }
}
