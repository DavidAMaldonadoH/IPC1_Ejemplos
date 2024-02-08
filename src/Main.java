import laboratorios.Clase03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int posicion = 64;
        int posY =  (posicion - 1) / 8;
        int posX = (posicion - 1) % 8;

        char[][][] tablero = {
                {{' ', '@'}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}},
                {{' ', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}},
                {{'#', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}},
                {{'#', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}},
                {{'#', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}},
                {{'#', ' '}, {'#', ' '}, {' ', ' '}, {'#', ' '}, {' ', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}},
                {{'#', ' '}, {'#', ' '}, {' ', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}},
                {{' ', ' '}, {'#', ' '}, {' ', ' '}, {' ', ' '}, {'#', ' '}, {'#', ' '}, {'#', ' '}, {'#', '@'}},
        };

        pintarTablero(tablero);

        if (estaEnPenalizacion(tablero[posY][posX])) {
            System.out.println("Haz caido en una penalizacion!");
        }

        Scanner scanner = new Scanner(System.in);
        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            if (num2 == 0) throw new ArithmeticException("No se puede dividir entre 0");

            int division = num1 / num2;
            System.out.println(division);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void pintarTablero(char[][][] tablero) {
        for (int i = 7; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 7; j >= 0; j--) {
                if (i % 2 == 1) {
                    System.out.printf("%02d %c %c |", i * 8 - j + 8, tablero[i][7 - j][0], tablero[i][7 - j][1]);
                } else {
                    System.out.printf("%02d %c %c |", i * 8 + j + 1, tablero[i][j][0], tablero[i][j][1]);
                }
            }
            System.out.println();
        }
    }

    public static boolean estaEnPenalizacion(char[] casilla) {
        return casilla[0] == '#' && casilla[1] == '@';
    }
}