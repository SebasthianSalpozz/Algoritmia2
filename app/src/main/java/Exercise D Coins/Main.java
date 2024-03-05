import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    class WaysOfChanges {
      int[] coins = {50, 25, 10, 5, 1};
      int[][] almacen = new int[8000][5];
      int changesNumber(int money, int coinsI) {
        if (money == 0)
          return 1;
        if (almacen[money][coinsI] != -1)
          return almacen[money][coinsI];
        int cambios = 0;
        for (int i = coinsI; i < 5; ++i) {
          if (money >= coins[i])
            cambios += changesNumber(money - coins[i], i);
        }
        return almacen[money][coinsI] = cambios;
      }
    }

    Scanner scanner = new Scanner(System.in);
    WaysOfChanges waysOfChanges = new WaysOfChanges();
    for (int[] arr : waysOfChanges.almacen) {
      Arrays.fill(arr, -1);
    }
    while (scanner.hasNextInt()) {
      int money = scanner.nextInt();
      System.out.println(waysOfChanges.changesNumber(money, 0));
    }
  }
}
