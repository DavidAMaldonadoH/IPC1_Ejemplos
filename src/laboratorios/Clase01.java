package laboratorios;

import java.util.ArrayList;
import java.util.Scanner;

public class Clase01 {
    public void ejecutar() {
        final char[] letras = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        boolean comenzar = true;
        Scanner textInput = new Scanner(System.in);
        ArrayList<Integer> matricesGeneradas = new ArrayList<Integer>();
        while (comenzar) {
            System.out.println("Menu");
            System.out.println("1. Generar Matriz Aleatoria");
            System.out.println("2. Mostrar Historial");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = (int) textInput.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tamaño de la matriz deseada: ");
                    int tamanio = textInput.nextInt();
                    matricesGeneradas.add(tamanio);
                    char[][] matrizLetras = new char[tamanio][tamanio];
                    for (int i = 0; i < tamanio; i++) {
                        for (int j = 0; j < tamanio; j++) {
                            int indiceAleatorio = (int) (Math.random() * letras.length);
                            matrizLetras[i][j] = letras[indiceAleatorio];
                        }
                    }

                    for (char[] fila : matrizLetras) {
                        System.out.print("|");
                        for (char letra : fila) {
                            System.out.print(" " + letra + " |");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    if (matricesGeneradas.isEmpty()) {
                        System.out.println("Aun no se han generado matrices!");
                    } else {
                        for (int matriz : matricesGeneradas) {
                            System.out.println("Matriz de tamanio - " + matriz);
                        }
                    }
                    break;
                case 3:
                    comenzar = false;
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida!");
            }
        }
    }
}
