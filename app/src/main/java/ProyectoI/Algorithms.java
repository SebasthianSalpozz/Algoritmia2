package ProyectoI;

public class Algorithms {
  public static int longestCommonSubsequenceText(String text1, String text2) {
    String[] words1 = text1.toLowerCase().split(" ");
    String[] words2 = text2.toLowerCase().split(" ");
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
    // for (int j = 0; j <= sizeText2; j++) {
    // System.out.print(dp[i][j] + " ");
    // }
    // System.out.println();
    // }
    return dp[sizeText1][sizeText2];
  }

  public static int levenshteinDistance(String s1, String s2) {
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
