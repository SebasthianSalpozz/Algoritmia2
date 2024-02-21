package wedding;

import java.util.Scanner;

public class main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      int m = scanner.nextInt();
      int c = scanner.nextInt();
      int[][] prenda = new int[c][];

      for (int j = 0; j < c; j++) {
        int k = scanner.nextInt();
        prenda[j] = new int[k];

        for (int l = 0; l < k; l++) {
          prenda[j][l] = scanner.nextInt();
        }
      }

      int result = tienda(m, c, prenda);
      System.out.println((result != -1) ? result : "no solution");
    }

    scanner.close();
  }
  static int tienda(int money, int c, int[][] prenda) {
    int[][] moneyQuantity = new int[21][201];
    for (int[] fila : moneyQuantity) {
      java.util.Arrays.fill(fila, -1);
    }
    moneyQuantity[0][0] = 0;

    for (int g = 0; g < c; g++) {
      for (int m = 0; m <= money; m++) {
        if (moneyQuantity[g][m] != -1) {
          for (int price : prenda[g]) {
            if (m + price <= money) {
              moneyQuantity[g + 1][m + price] = Math.max(moneyQuantity[g + 1][m + price], moneyQuantity[g][m] + price);
            }
          }
        }
      }
    }

    for (int m = money; m >= 0; m--) {
      if (moneyQuantity[c][m] != -1) {
        return m;
      }
    }

    return -1;
  }
}
