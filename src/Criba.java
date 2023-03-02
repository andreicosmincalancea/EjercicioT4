import java.util.Scanner;
public class Criba {

    public static int[] generarPrimos(int numeroMaximo) {

        int i;
        int j;
        int tamanyo = numeroMaximo + 1;
        int cuenta = 0;
        boolean[] esPrimo = new boolean[tamanyo];

        if (numeroMaximo >= 2) {
            for (i = 0; i < tamanyo; i++) {
                esPrimo[i] = true;
            }

            esPrimo[0] = false;
            esPrimo[1] = false;

            for (i = 2; i < Math.sqrt(tamanyo) + 1; i++) {
                if (esPrimo[i]) {
                    for (j = 2 * i; j < tamanyo; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }

            for (i = 0; i < tamanyo; i++) {
                if (esPrimo[i]) {
                    cuenta++;
                }
            }

            int[] primos = new int[cuenta];

            for (i = 0, j = 0; i < tamanyo; i++) {
                if (esPrimo[i]) {
                    primos[j++] = i;
                }
            }

            return primos;

        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");

        int dato = teclado.nextInt();
        int[] vector = new int[dato];

        System.out.println("\nVector inicial hasta :"+dato);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }

        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}