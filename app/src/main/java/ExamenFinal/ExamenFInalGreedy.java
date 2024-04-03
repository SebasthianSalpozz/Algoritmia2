package ExamenFinal;

import java.util.Arrays;

public class ExamenFInalGreedy {
    
    public static int maxFood(int N, int M, int[] meals) {
        Arrays.sort(meals);
        
        int count = 0; 
        int totalTime = 0;         
        for (int i = 0; i < N; i++) {
            if (totalTime + meals[i] <= M) {
                totalTime += meals[i]; 
                count++; 
            } else {
                break;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int N = 2; 
        int M = 18; 
        
        int[] meals = {1,3}; 
        
        int maxmealsEaten = maxFood(N, M, meals);
        System.out.println("Maximum number of meals eaten: " + maxmealsEaten);
    }
}
// Greddy Choice 
// practicamente el greesy choice en este codigo es que en cada iteración del bucle, se selecciona
// la comida más pequeña disponible que no exceda el tiempo de M
 
// Optimal SubEstructure
// la subestructura óptima en este caso es que en cada iteracion se selecciona la comida más pequeña 
// que aún no ha sido comida y se verifica si se puede agregar al tiempo M sin exceder el límite de M

//Time Complexity
//La complejidad es  O(N log N) ya que se ordena el arreglo de las meals 

//Hablando de mejor tiempo de complejidad tenemos Greddy Como mejor tiempo de complejidad entre Greedy y DP 