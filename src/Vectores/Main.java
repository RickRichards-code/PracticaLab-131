package Vectores;

public class Main {
    static void invertirVector(Vector v){ // vector como obejeto
        int i = 0;
        int j = v.n - 1;
        while (i < j){
            int aux = v.vector[i];
            v.vector[i] = v.vector[j];
            v.vector[j] = aux;
            i++;
            j--;
        }
    }
    // rotar a la derecha los elementos del vector y el primer elemento pasa a ser el ultimo
    static void rotarDerecha(Vector v){
        int aux = v.vector[v.n - 1];
        for (int i = v.n - 1; i > 0; i--){
            v.vector[i] = v.vector[i - 1];
        }
        v.vector[0] = aux;
    }
    static void rotarIzquierda(Vector v){
        int aux = v.vector[0];
        for (int i = 0; i < v.n - 1; i++){
            v.vector[i] = v.vector[i + 1];
        }
        v.vector[v.n - 1] = aux;
    }

    public static void main(String[] args) {
        Vector v = new Vector();
        v.llenarVector();
        v.mostrarVector();
//        System.out.println("\n--- vector invetido ---");
//        invertirVector(v);
//        v.mostrarVector();
        System.out.println("\n--- vector rotado ---");
//        rotarDerecha(v);
//        v.mostrarVector();
        rotarIzquierda(v);
        v.mostrarVector();

    }
}
