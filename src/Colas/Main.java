package Colas;

public class Main {
    public static void main(String[] args) {
//        ColaNum cola = new ColaNum();
//        cola.llenarCola();
//        cola.mostrarCola();

//        System.out.println("--- cola ordenada ---");
//        cola.ordenarColaAscendente();
//        cola.mostrarCola();

//        System.out.println("--- cola impares en la cima ---");
//        cola.moverImparesALaCima();// --- nop
//        cola.mostrarCola();


//        cola.mostrarDosMenores();

//        System.out.println("--- cola rotar pares ---"); --- nop
//        cola.rotarParesIzquierda();
//        cola.mostrarCola();
// ------------------------------------
        ColaCad cola = new ColaCad();
        cola.llenarCola();
        cola.mostrarCola();

//        System.out.println("--- cola ordenada ---");
//        cola.ordenarAlfabeticamente();
//        cola.mostrarCola();



//        int posicion = cola.buscarCadenaX();
//        System.out.println("La cadena se encuentra en la posición: " + posicion);

//        System.out.println("--- eliminar caracter X ---");
//        cola.eliminarCad();
//        cola.mostrarCola();

//        System.out.println("--- cola invertida ---");
//        cola.invertirCola(cola);
//        cola.mostrarCola();

        System.out.println("--- cola cantidad de Caracteres ---");
        cola.cantidadCaracteres();

    }
}
