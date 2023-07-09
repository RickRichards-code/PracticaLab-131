package Pilas;
public class Main {

    public static void main(String[] args) {
//        PilaNum pila = new PilaNum();
//        pila.llenarPila();

//        double promedio = pila.calcularPromedio();
//        double varianza = pila.calcularVarianza();
//        double desviacionEstandar = pila.calcularDesviacionEstandar();
//        double medidaArmonica = pila.calcularMedidaArmonica();
//        double medidaGeometrica = pila.calcularMedidaGeometrica();
//
//        System.out.println("Promedio: " + promedio);
//        System.out.println("Varianza: " + varianza);
//        System.out.println("Desviación Estándar: " + desviacionEstandar);
//        System.out.println("Medida Armónica: " + medidaArmonica);
//        System.out.println("Medida Geométrica: " + medidaGeometrica);
//        pila.ordenarAscendente();
//        pila.ordenarDescendenteImpares();
//        pila.ordenarParesInferiorImparesSuperior();
//        pila.mostrarPila();

        PilaCad pila = new PilaCad();
        pila.llenarPila();
        pila.mostrarPila();
//        System.out.println("--- pila convertida ---");
//        pila.convertirMayusculas();
//        pila.mostrarPila();

//        System.out.println("--- pila invertida cadena ---");
//        pila.invertirCadena();
//        pila.mostrarPila();

//        System.out.println("--- pila de validacion de correos ---");
//        pila.mostrarPila();
//        pila.comprobarCorreo();

        System.out.println("--- pila de ordenada alfabeticamente ---");
        pila.ordenarAlfabeticamente();
        pila.mostrarPila();




    }

}