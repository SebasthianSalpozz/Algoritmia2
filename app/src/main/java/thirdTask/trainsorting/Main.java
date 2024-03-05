package thirdTask.trainsorting;

import java.util.Scanner;

public class Main {
  public static int trains(int n, int[] trenes) {
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (trenes[i] < trenes[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int maxTrainLength = 0;
    for (int i = 0; i < n; i++) {
      maxTrainLength = Math.max(maxTrainLength, dp[i]);
    }

    return maxTrainLength;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cases = scanner.nextInt();
    scanner.nextLine();
    for (int t = 0; t < cases; t++) {
      int n = scanner.nextInt();
      int[] trenes = new int[n];

      for (int i = 0; i < n; i++) {
        trenes[i] = scanner.nextInt();
      }

      System.out.println(trains(n, trenes));
    }

    scanner.close();
  }

}
