package ProyectoI;
import java.util.HashMap;

public class Kitt {
    public static void main(String[] args) {
        String text1 = "This text should show what a printed text will look like at this place. If you read this text you will get no information.";
 
        String text2 = "This paragraph should show what a printd text will look like at this place. If you read this text you will get no informaton."; 

        String text3= "This text should show what a printed text will look like at this place. If you read this text you will get no information.";
 
        String text4 = "A blind text like this gives you information about the selected font.";
 
        String text5 ="Richard Bellman is best known as the father of dynamic programming. He was the author of many books and the recipient of many honors including the first Norbert Wiener Prize in Applied Mathematics.";
        
        String text6 = "Richard Bellman was the author of many books in matematicas.";
        double a = calculateSimilarityPercentage(text1, text2);
        double b = calculateSimilarityPercentage( text4, text3);
        double c = calculateSimilarityPercentage(text5, text6);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
     }

    private static int lcsLength = 0;
    private static HashMap<String, String> findMisspelings(String text1, String text2) {
        text1 = text1.replaceAll("[^a-zA-Z0-9]", " ");  
        text2 = text2.replaceAll("[^a-zA-Z0-9]", " ");  
        String[] words1 = text1.toLowerCase().split(" ");
        String[] words2 = text2.toLowerCase().split(" ");

        HashMap<String, String> misspelings = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            for (int j = 0; j < words2.length; j++) {
                int distance = calculateDistance(words1[i], words2[j]);
                if (distance <= 2 && distance != 0 && words1[i].length() > 3 && words2[j].length() > 3) {
                    misspelings.put(words1[i], words2[j]);
                    lcsLength ++;
                }
            }
        }
        return misspelings;
    }
    
    private static double calculateSimilarityPercentage(String text1, String text2) {
        lcsLength = longestCommonSubsequenceText(text1, text2);
        String[] words1 = text1.toLowerCase().split(" ");
        String[] words2 = text2.toLowerCase().split(" ");
        int maxLength;

        if (words1.length < words2.length) {
            maxLength = words1.length;  
        } else {
            maxLength = words2.length;
        }

        HashMap<String, String> misspelings = findMisspelings(text1, text2);
        misspelings.forEach((k, v) -> {System.out.println(k + "-" + v);});

        // System.out.println("MaxLength "+ maxLength);
        // System.out.println("LCS "+lcsLength);
        
        return (double) lcsLength / maxLength * 100;
    }


    public static int longestCommonSubsequenceText(String text1, String text2) {
        String[] words1 = text1.split(" ");
        String[] words2 = text2.split(" ");
        int sizeText1 = words1.length;
        int sizeText2 = words2.length;
        int[][] dp = new int[sizeText1 + 1][sizeText2 + 1];
        for (int i = 1; i <= sizeText1; i++) {
            for (int j = 1; j <= sizeText2; j++) {
                if (words1[i - 1].equals(words2[j - 1])) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // System.out.println("Matrix dp:");
        // for (int i = 0; i <= sizeText1; i++) {
        //     for (int j = 0; j <= sizeText2; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[sizeText1][sizeText2];
    }

    public static int calculateDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
