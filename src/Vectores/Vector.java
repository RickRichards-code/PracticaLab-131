package Vectores;

import java.util.Scanner;

public class Vector {
    int n;
    int[] vector = new int[50];


    public void llenarVector() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese el tamaño del vector: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ingrese un numero: ");
            vector[i] = sc.nextInt();
        }
    }

    public void mostrarVector() {
        for (int i = 0; i < n; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public int getN() {
        return n;
    }
}
