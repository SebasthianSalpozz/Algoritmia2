/*a.Update the code so it uses dynamic programming
Transformado a Bottom up
*/
public class Main {
    static int function(int n) {
        if (n <= 0) {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(function(n));
    }
}

/*
 b.Do we still need the base case after converting the code to dynamic programming? why?
 Si necesitamso los casos base por que nos ayudan a dar soluciones inmediatas a los subproblemas mas pequeños que luego utilizamos para construir una solucion al problema mas grande 
 */

/* 
Q3 
q3
 Sí, si un problema puede ser resuelto combinando las soluciones a sus subproblemas 
 podria llegar a ser resuelto con un algoritmo de Dp sin embargo deberia de cumplir 
 alguna caracteristica mas para llegar a serlo como:
subestructura optima o 

*/

/*
Q3
Vemos la Edit-Distance anterior de la segunda cadena porque estamos insertando un nuevo carácter en la primera cadena para hacerla igual a la segunda
*/

//Va disculpar trainer al parece no habia subido esta mi respuesta al repo pero si lo tenia en mi privado sin embargo si no me lo hace valer esta bien disculpe