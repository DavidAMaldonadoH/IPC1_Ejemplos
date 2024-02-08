package laboratorios;

import java.util.Scanner;

public class Clase03 {

    final int tamTablero = 8;

    public void ejecutar() {
        int posGeneral = 63;
        int posX = (posGeneral % tamTablero);
        int posY = posGeneral / tamTablero;

        char[][][] tablero = {
                {{' ', '@'}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}},
                {{' ', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}},
                {{'#', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}},
                {{'#', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}},
                {{'#', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}},
                {{'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}},
                {{'#', ' '}, {'#', ' '}, {' ', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}},
                {{' ', ' '}, {'#', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}},
        };

        pintarTablero(tablero);

        if (estaEnPenalizacion(tablero[posY][posX])) {
            System.out.println("Haz caido en una penalizacion!");
        }

        Scanner scanner = new Scanner(System.in);

        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int index = 10;

            if (num2 == 0) throw new ArithmeticException("No se puede");
            int number[] = new int[10];
            number[index] = num1 / num2;

            System.out.println(number[index]);
        } catch (ArithmeticException e) {
            System.out.println("No se puede divir entre 0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fuera del tamanio del arreglo");
        }finally {
            System.out.println("fin");
        }
    }

    public void pintarTablero(char[][][] tablero) {
        System.out.println("-".repeat(65));
        for (int i = tamTablero - 1; i >= 0; i--) {
            System.out.print("|");
            for (int j = tamTablero - 1; j >= 0; j--) {
                if (i % 2 == 1) {
                    System.out.printf("%02d     |", i * tamTablero - j + tamTablero);
                } else {
                    System.out.printf("%02d     |", i * tamTablero + j + 1);
                }
            }
            System.out.print("\n|");
            for (int j = tamTablero - 1; j >= 0; j--) {
                if (i % 2 == 1){
                    System.out.printf("   %c %c |", tablero[i][7 - j][0], tablero[i][7 - j][1]);
                } else {
                    System.out.printf("   %c %c |", tablero[i][j][0], tablero[i][j][1]);
                }
            }
            System.out.println();
            System.out.println("-".repeat(65));
        }
    }

    public boolean estaEnPenalizacion(char[] casilla){
        return casilla[0] == '#' && casilla[1] == '@';
    }
}
