package Colas;

import java.util.ArrayList;

public class ColaEstudiante {
    private int max = 15;
    private Estudiante v[] = new Estudiante[max + 1];
    private int ini, fin;


    ColaEstudiante() {
        ini = fin = 0;
    }

    public int getFin() {
        return fin;
    }
    // obtener dato fin


    boolean esvacia() {
        return ini == 0 && fin == 0;
    }

    boolean esllena() {
        return fin == max;
    }

    int nroelem() {
        return (fin - ini);
    }

    void adicionar(Estudiante elem) {
        if (!esllena()) {
            fin++;         //v[fin+1]=elem
            v[fin] = elem;  //fin=fin+1
        } else {
            System.out.println("Cola Simple llena");
        }
    }

    Estudiante eliminar() {
        Estudiante elem = new Estudiante();
        if (!esvacia()) {
            ini++;
            elem = v[ini];
            if (ini == fin) {
                ini = fin = 0;
            }
        } else {
            System.out.println("Cola Simple vacia");
        }
        return (elem);
    }

    void mostrarCola() {
        if (esvacia()) {
            System.out.println("Cola vacia");
        } else {
            System.out.println("\n--- Datos --- ");
            ColaEstudiante aux = new ColaEstudiante();
            while (!esvacia()) {
                Estudiante elem = eliminar();
                aux.adicionar(elem);
                elem.mostrar();
            }
            vaciar(aux);
        }
    }

    void llenarCola() {
        System.out.print("ingrese el numero de elementos a ingresar: ");
        int n = Leer.datoInt();
        for (int i = 0; i < n; i++) {
//            System.out.print("ingrese un elemento: ");
            Estudiante elem = new Estudiante();
            elem.leer();
            adicionar(elem);
        }
    }

    void vaciar(ColaEstudiante a) {
        while (!a.esvacia()) {
            adicionar(a.eliminar());
        }
    }

    Estudiante obtenerFin() {
        return v[fin];
    }

    void mostrarEstudiatesFemeninos() {
        ColaEstudiante aux = new ColaEstudiante();
        ColaEstudiante aux1 = new ColaEstudiante();
        while (!esvacia()) {
            Estudiante elem = eliminar();
            if (elem.getGenero() == ('F')) {
                aux1.adicionar(elem);
            }
            aux.adicionar(elem);
        }
        vaciar(aux);
        aux1.mostrarCola();
    }

    // mostrar el Estudiante con la mayor edad
    void mostrarEstudianteMayorEdad() {
        ColaEstudiante aux = new ColaEstudiante();
        ColaEstudiante aux1 = new ColaEstudiante();
        int max = 0;
        while (!esvacia()) {
            Estudiante elem = eliminar();
            if (elem.getEdad() > max) {
                aux1.adicionar(elem);
            }
            aux.adicionar(elem);
        }
        vaciar(aux);
        aux1.eliminar().mostrar();
    }


    public double calcularDesviacionEstandarEdades() {
        double media = 0;
        double sumaCuadradosDiferencias = 0;
        int contador = 0;

        // Calcular la media (promedio) de las edades
        ColaEstudiante aux = new ColaEstudiante();
        while (!esvacia()) {
            Estudiante elem = eliminar();
            media += elem.getEdad();
            aux.adicionar(elem);
            contador++;
        }
        vaciar(aux);
        media /= contador;

        // Calcular la suma de los cuadrados de las diferencias entre cada edad y la media
        aux = new ColaEstudiante();
        while (!esvacia()) {
            Estudiante elem = eliminar();
            double diferencia = elem.getEdad() - media;
            sumaCuadradosDiferencias += Math.pow(diferencia, 2);
            aux.adicionar(elem);
        }
        vaciar(aux);

        // Dividir la suma de los cuadrados de las diferencias entre el número de elementos
        double varianza = sumaCuadradosDiferencias / contador;

        // Calcular la raíz cuadrada de la varianza para obtener la desviación estándar
        double desviacionEstandar = Math.sqrt(varianza);

        return desviacionEstandar;
    }

//    public void mostrarNombresRepetidos() {
//        List<String> nombres = new ArrayList<>();
//        List<String> nombresRepetidos = new ArrayList<>();
//
//        ColaEstudiante aux = new ColaEstudiante();
//        while (!esvacia()) {
//            Estudiante estudiante = eliminar();
//            String nombre = estudiante.getNombre();
//
//            if (nombres.contains(nombre) && !nombresRepetidos.contains(nombre)) {
//                nombresRepetidos.add(nombre);
//            } else {
//                nombres.add(nombre);
//            }
//
//            aux.adicionar(estudiante);
//        }
//        vaciar(aux);
//
//        System.out.println("Nombres repetidos:");
//        for (String nombre : nombresRepetidos) {
//            System.out.println(nombre);
//        }
//    }







}