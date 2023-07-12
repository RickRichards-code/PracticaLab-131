package Colas;

public class Main {
    public static void main(String[] args) {
//        =================== COlA NUMEROS ======================

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
//        =================== COlA CADENAS ======================
//        ColaCad cola = new ColaCad();
//        cola.llenarCola();
//        cola.mostrarCola();

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

//        System.out.println("--- cola cantidad de Caracteres ---");
//        cola.cantidadCaracteres();

//        =================== COlA CIRCULAR NUMEROS ======================
//        ColaCircularNum cola = new ColaCircularNum();
//        cola.llenarCola();
//        cola.mostrarCola();


//        =================== COlA CIRCULAR CADENAS ======================


//        =================== COlA OBJETOS - AUTO ======================
//        ColaAuto cola = new ColaAuto();
//        cola.llenarCola();
//        cola.mostrarCola();

//        System.out.println("--- listar los auto del mismo tipoAuto ---");
//        cola.listarTipoAuto("Carreras");

//        System.out.println("--- ordenar alfabeticamente ---");
//        cola.ordenarAlfabeticamente();
//        cola.mostrarCola();

//        System.out.println("--- quitar autos con el mismo codigo ---");
//        cola.eliminarAutosMismoCodigo();
//        cola.mostrarCola();
//        System.out.println("--- calcular promedio de monto de pago ---");
//        double prom = cola.calcularPromedioMontoPago();
//        System.out.println("promedio  de monto de pago: " + prom);

//        =================== COlA OBJETOS - ESTUDIANTE ======================
//        ColaEstudiante cola = new ColaEstudiante();
//        cola.llenarCola();
//        System.out.println("--- mostrar estudiantes femeninos ---");
//        cola.mostrarEstudiatesFemeninos();
//
//
//        System.out.println("--- mostrar el estudiante con mayor edad ---");
//            cola.mostrarEstudianteMayorEdad();


//        System.out.println("--- mostrar estudiantes repetidos ---");
//        cola.mostrarEstudiantesRepetido("mario");

//        System.out.println("--- desviacion estandar ---");
//        double e  = cola.calcularDesviacionEstandarEdades();
//        System.out.println("desviacion estandar: " + e);
//        cola.imparesArribaParesAbajo();

//        ColaCircularNum cola = new ColaCircularNum();
//        cola.llenarCola();
//        cola.mostrarCola();
////
//        System.out.println("--- mostra colas mayor/menor al promedio ---");
//        double i = cola.promedio();
// 7       System.out.println("promedio: " + i);
//        cola.mayoreMenorPromedio();


//        ====================================
//        ColaCircularCad cola = new ColaCircularCad();
//        cola.llenarCola();
//        cola.mostrarCola();
//
//        System.out.println("--- eliminar vocales ---");
//        cola.eliminarVocales1();
//        cola.mostrarCola();

        // ColaCircularProducto  cola = new ColaCircularProducto();
        // cola.comprarProducto();

//        ColaCircularPersona p = new ColaCircularPersona();
//        p.llenarCola();
//        p.mostrarCola();


        // ==================================  DEFENSA NRO 5 COLAS CIRCULARES  ==================================
        ColaCircularPaciente cola = new ColaCircularPaciente();
        cola.leerDatosGenerarCodigo();
        cola.mostrarCola();
        ColaCircularHistorial historial = new ColaCircularHistorial();
        historial.generarHistorial(cola);
        historial.mostrarCola();
        historial.incisosBCDE();
        historial.mostrarCantidadHombresMujeres(cola);
        historial.especialidadMenosConsultas();
    }

}
