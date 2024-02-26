package applePeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
  public static String longestCommonSubsequence(String text1, String text2) {
    int sizeText1 = text1.length();
    int sizeText2 = text2.length();
    int[][] dp = new int[sizeText1 + 1][sizeText2 + 1];

    for (int i = 1; i <= sizeText1; i++) {
      for (int j = 1; j <= sizeText2; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    StringBuilder lcs = new StringBuilder();
    int i = sizeText1, j = sizeText2;
    while (i > 0 && j > 0) {
      if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        lcs.insert(0, text1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    return lcs.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter text 1:");
    String text1 = br.readLine();

    System.out.println("Enter text 2:");
    String text2 = br.readLine();

    String result = longestCommonSubsequence(text1, text2);

    System.out.printf("The LCS is \"%s\".%n", result);
  }
}
