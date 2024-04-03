package ExamenFinal;
//Q1 
//Cuandotenemos q comparar mayor cantidad de datos o datos para hacer match

// Q2
// el estado inicial seria a y el estado aceptado es abc

// Q3
// B

// a)
// El subproblema practicamente esta almacenando el número máximo de comidas que se pueden comer en una cantidad específica de tiempo M

// Los overlaps ocuuren dentro del segundo for donde estamos comparando estamos realizando la verificacion si el numero maximo de comidas que se pueden comer  no sobrepasa el tiempo M

// Time Complexity tiene una complejidad de tiempo de O(N * M),

public class ExamenFinal {
    public static int maxFood(int N, int M, int[] meals) {
        int[] dp = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = M; j >= meals[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - meals[i - 1]] + 1);
            }
        }
        return dp[M];
    }

    public static void main(String[] args) {
        int[] meals = {8,6,5,4,3,2,1}; 
        int N = 7; 
        int M = 13; 

        int maxFoodCount = maxFood(N, M, meals);
        System.out.println("Maximum number of foods that can be eaten: " + maxFoodCount);
    }
}
