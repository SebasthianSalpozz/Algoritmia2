package thirdTask.longestStringChain;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    int longestChainLength = longestChain(words);
    System.out.println(longestChainLength);
  }
  public static int longestChain(String[] words) {
    Map<String, Integer> memo = new HashMap<>();
    int max = 0;

    for (int i = 0; i < words.length - 1; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (words[i].length() > words[j].length()) {
          String temp = words[i];
          words[i] = words[j];
          words[j] = temp;
        }
      }
    }
    for (String word : words) {
      memo.put(word, 1);
      for (int i = 0; i < word.length(); i++) {
        StringBuilder current = new StringBuilder(word);
        String next = current.deleteCharAt(i).toString();
        if (memo.containsKey(next)) {
          memo.put(word, Math.max(memo.get(word), memo.get(next) + 1));
        }
      }
      max = Math.max(max, memo.get(word));
    }

    return max;
  }
}
