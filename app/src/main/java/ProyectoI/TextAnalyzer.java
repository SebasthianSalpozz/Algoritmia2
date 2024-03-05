
package ProyectoI;

import java.util.HashMap;

import static ProyectoI.Algorithms.levenshteinDistance;
import static ProyectoI.Algorithms.longestCommonSubsequenceText;

public class TextAnalyzer {
  private static int lcsLength = 0;

  public static double calculateSimilarityPercentage(String text1, String text2) {
    lcsLength = sentencesLength(text1, text2);
    String[] words1 = text1.toLowerCase().split(" ");
    String[] words2 = text2.toLowerCase().split(" ");
    int maxLength;

    if (words1.length < words2.length) {
      maxLength = words1.length;
    } else {
      maxLength = words2.length;
    }

    HashMap<String, String> misspelings = findMisspelings(text1, text2);
    misspelings.forEach((k, v) -> {
      System.out.println(k + "-" + v);
    });

    double similarityPercentage = (double) lcsLength / maxLength * 100;
    double roundedPercentage = Math.round(similarityPercentage * 100.0) / 100.0;
    return roundedPercentage;
  }

  public static int sentencesLength(String text1, String text2) {
    String[] sentences1 = text1.split("\\.");
    String[] sentences2 = text2.split("\\.");
    int maxLength = 0;
    if (sentences1.length == sentences2.length) {
      int lcsLength = longestCommonSubsequenceText(text1, text2);
      maxLength = Math.max(maxLength, lcsLength);
    } else {
      for (String sentence1 : sentences1) {
        for (String sentence2 : sentences2) {
          int lcsLength = longestCommonSubsequenceText(sentence1, sentence2);
          maxLength = Math.max(maxLength, lcsLength);
        }
      }
    }

    return maxLength;
  }

  private static HashMap<String, String> findMisspelings(String text1, String text2) {
    text1 = text1.replaceAll("[^a-zA-Z0-9]", " ");
    text2 = text2.replaceAll("[^a-zA-Z0-9]", " ");
    String[] words1 = text1.toLowerCase().split(" ");
    String[] words2 = text2.toLowerCase().split(" ");

    HashMap<String, String> misspelings = new HashMap<>();

    for (int i = 0; i < words1.length; i++) {
      for (int j = 0; j < words2.length; j++) {
        int distance = levenshteinDistance(words1[i], words2[j]);
        if (distance <= words1[i].length() * 0.45 && distance <= words2[j].length() * 0.45 && distance != 0
                && words1[i].length() > 3 && words2[j].length() > 3) {
          misspelings.put(words1[i], words2[j]);
          lcsLength++;
        }
      }
    }
    if (words1.length == misspelings.size()&& words2.length == misspelings.size()) {
      for (int i = 1; i < words1.length; i++) {
        misspelings.remove(words1[i]);
        lcsLength--;
      }
    }
    return misspelings;
  }

}
