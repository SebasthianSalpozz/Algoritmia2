package sttreamMatching;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// The complexity of the Rabin-Karp algorithm in a general scenario is quite good, which is O(m+n).
// However, if we talk about the worst case, it increases to O ((n-m+1) m, *m is the length of the pattern & n is the length of the string.

public class rabinKarp {

    public static List<Integer> occurrences = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String pattern = scanner.nextLine();
        occurrences.add(1);
        if (occurrences.size() == 0){
            System.out.println("Pattern not found");
        }
        occurrences.remove(0);
        search(pattern, text);
    }

    public static void search(String pattern, String text) {
        int patternHash = calculateHash(pattern);
        int textHash = calculateHash(text.substring(0, pattern.length()));

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (patternHash == textHash && checkEqual(pattern, text, i, i + pattern.length() - 1)) {
                occurrences.add(i);
                System.out.println("Pattern found at index " + i);
            }
            if (i < text.length() - pattern.length()) {
                textHash = recalculateHash(text, textHash, i, i + pattern.length());
            }
        }
    }

    public static int calculateHash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i);
        }
        return hash;
    }

    public static int recalculateHash(String text, int oldHash, int oldIndex, int newIndex) {
        int newHash = oldHash - text.charAt(oldIndex) + text.charAt(newIndex);
        return newHash;
    }

    public static boolean checkEqual(String pattern, String text, int start, int end) {
        for (int i = start, j = 0; i <= end; i++, j++) {
            if (pattern.charAt(j) != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
