package laboratorios;

public class Clase02 {

    public void ejecutar() {
        System.out.println("Clase 02");

        int[] values = { 2, 35, 12, 55, 50,7, 9};
        int[] arr = {10, 80, 30, 90, 40};

        int[] sortedValues = bubbleSort(values);
        printArray(sortedValues);

        System.out.println(factorial(5));
        System.out.println(factorial2(5));
        System.out.println(potencia(2.0, 4));
        System.out.println(esPar(12));
    }

    public void printArray(int[] elements) {
        System.out.print("[");
        for (int i = 0; i < elements.length; i++) {
            if (i != elements.length - 1) {
                System.out.printf("%d, ", elements[i]);
            } else {
                System.out.print(elements[i]);
            }
        }
        System.out.println("]");
    }
    
    public int[] bubbleSort(int[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j+1]) {
                    int tmp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = tmp;
                }
            }
        }
        return elements;
    }

    public int factorial(int num) {
        if (num == 1 || num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public int factorial2(int num) {
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f *= i;
        }
        return f;
    }

    public double potencia(double num, int n) {
        double pot = 1;
        int absN = n < 0 ? n * -1 : n;
        for (int i = 1; i <= absN; i++) {
            pot *= num;
        }
        return n < 0 ? 1.0 / pot : pot;
    }

    public boolean esPar(int num) {
        if (num == 0) {
            return true;
        } else {
            return esImpar(num - 1);
        }
    }

    public boolean esImpar(int num) {
        if (num == 0) {
            return false;
        } else {
            return esPar(num - 1);
        }
    }
}
