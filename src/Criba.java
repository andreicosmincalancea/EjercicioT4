import java.util.Scanner;
/**
 * Clase Criba:
 * Dado un número, imprimer dos arrays. El primero con todos los enteros y el segundo únicamente
 * los primos hasta el número especificado
 * @author Andrei Cosmin Calancea
 * @version 1.2
 */
public class Criba {
    /**
     * Función que genera los números primos desde el 2 hasta el número máximo especificado
     * @return un array de integers primos
     * @param numeroMaximo último número al que llegar para determinar los números primos
     */
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
    /**
     * Función que solicita un número, imprime los enteros hasta ese número y los primos hasta el
     * mismo número
     */
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
        // Determinamos los números primos
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