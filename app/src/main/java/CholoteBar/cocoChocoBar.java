package CholoteBar;
import java.util.Arrays;
import java.util.Scanner;

// i. Analyze the problem based on sub-problems.
// El problema de por si ya me parecia familiar debido a q nos daba un numero y debiamos dividirlo hasta llegar a la maxima cantidad de particiones del chocolate
// entonces lo que realice fue hacer una modificacion en el problema de coinchange que nos devolvia el minimo de monedas para realizar el cambio y lo modifique para que 
// me devuelva el maximo y qno repita el valor ya existente debido a q en el problema se veia q no se puede dividir por el mismo valor.
// ii. Identify where the overlap occurs.
// El Overlap ocurre en el cálculo del array dp en el bucle anidado
// cuando se actualiza dp[i] se utiliza dp[i - coin] para determinar el número de monedas necesarias para formar la cantidad i que seria el monto 
// iv. What is the time complexity of your solution?
//El time Complexity de este algoritmo es O(n * amount), donde n es la cantidad de particiones posibles del chocolate y amount es el N del chocolate.



public class cocoChocoBar {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = amount; i >= coin; i--) {
                if (dp[i - coin] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount];
    }
    public static int[] fillparticions(int n ){
        int[] particions = new int[n];
        for (int i = 0; i < n; i++) {
            particions[i] = i + 1;
        }
        return particions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.close();

        int[] particions = fillparticions(amount);
        int result = coinChange(particions, amount);
        System.out.println(result);
    }
}