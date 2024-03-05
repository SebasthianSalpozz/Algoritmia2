package Examen;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] gifts = new int[n];
        for (int i = 0; i < n; i++) {
            gifts[i] = scanner.nextInt();
        }
        int minMoves = findMinMoves(gifts);
        System.out.println(minMoves);
    }

    private static int findMinMoves(int[] gifts) {
        int n = gifts.length;
        int[] sortedGifts = Arrays.copyOf(gifts, n);
        Arrays.sort(sortedGifts);
        int minMoves = 0;
        for (int i = 0; i < n; i++) {
            if (gifts[i] != sortedGifts[i]) {
                minMoves++;
            }
        }
        return minMoves;
    }
}
