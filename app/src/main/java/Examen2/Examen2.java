package Examen2;

import java.util.Scanner;
import java.util.Arrays;

//Q1
// Why do we need to do a formal proof for a greedy Algorithm 
// La necesidad de realizar una prueba formal para un algoritmo Greedy radica en la garantía de su correctitud y eficiencia y  una prueba formal puede ayudar a identificar posibles casos de Limite

//Q2
// The worst case, it increases to O ((n-m+1) m, *m is the length of the pattern & n is the length of the string.
//Q3
// 

//Q4 
// La complejidad es  O(N log N) ya que se ordena el arreglo de tiempo de reenvolver y el arreglo de tiempo de entrega
// Estoy usando greedy algorithm para resolver el problema ya que estoy ordenando los arreglos de tiempo de reenvolver 
// y tiempo de entrega y luego sumando el tiempo de reenvolver y el tiempo de entrega mas pequeño lo cual me da el tiempo minimo
// Sin embargo es otro punto del problema omitiendo la parte que dice que solo se puede entregar un delivery a la vez
public class Examen2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Presents Number");
        int N = scanner.nextInt();

        System.out.println("Time to repacking the presents");
        int[] tiempoReenvolver = new int[N];
        for (int i = 0; i < N; i++) {
            tiempoReenvolver[i] = scanner.nextInt();
        }

        System.out.println("Deliveri time");
        int[] tiempoEntrega = new int[N];
        for (int i = 0; i < N; i++) {
            tiempoEntrega[i] = scanner.nextInt();
        }

        int minTime = calculateMinimumTime(tiempoReenvolver, tiempoEntrega);
        System.out.println("Minimum time: " + minTime);
    }
    
    public static int calculateMinimumTime(int[] tiempoReenvolver, int[] tiempoEntrega) {
        Arrays.sort(tiempoReenvolver);
        Arrays.sort(tiempoEntrega);

        int sumRegalosEnvueltos = 0;
        for (int i = 0; i < tiempoReenvolver.length; i++) {
            sumRegalosEnvueltos += tiempoReenvolver[i];
        }

        int minTiempoEntrega = tiempoEntrega[0];

        return sumRegalosEnvueltos + minTiempoEntrega;
    }
}