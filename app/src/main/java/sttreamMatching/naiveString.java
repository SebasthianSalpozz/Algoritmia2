package sttreamMatching;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Best Case - O(n): Happens when the string doesn't have the pattern.
// Worst Case - O(m * n): Happens when: Where m is the length of pattern
// and n is the length of string. 
// ● All characters in both string and pattern are the same.
// ● All characters in both string and pattern are the same except for the last character.


public class naiveString {
    public static List<Integer> occurrences = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        occurrences.add(1);
        if (occurrences.size() == 0){
            System.out.println("Pattern not found");
        }
        occurrences.remove(0);
        findPattern(pattern, text);
    }

    public static void findPattern(String pattern, String text) {

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            int j;
            for (j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == pattern.length()) {
                occurrences.add(i);
                System.out.println("Pattern found at index" + i);
            }
        }
    }
}
