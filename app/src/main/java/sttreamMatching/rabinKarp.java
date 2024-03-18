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
        if (occurrences.size() == 0){
            System.out.println("Pattern not found");
        }
        search(pattern, text);
    }

    public static void search(String pattern, String text) {
        

        int m = pattern.length();
        int n = text.length();

        for (int i = 0; i <= n - m; i++) {
            if (checkEqual(pattern, text, i, i + m - 1)) {
                occurrences.add(i);
                System.out.println("Pattern found at index " + i);
            }
        }

    }

    private static boolean checkEqual(String pattern, String text, int start, int end) {
        for (int i = start, j = 0; i <= end; i++, j++) {
            if (pattern.charAt(j) != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
