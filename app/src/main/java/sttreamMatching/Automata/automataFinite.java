package sttreamMatching.Automata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class automataFinite {
    private int[][] tablaDeTransicion;
    private String patron;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Patron: ");
        String patron = scanner.nextLine();

        System.out.println("Text: ");
        String text = scanner.nextLine();

        automataFinite automata = new automataFinite(patron);
        List<Integer> occurrences = automata.search(text);
        if (occurrences.isEmpty()) {
            System.out.println("Pattern not found");
        }
    }

    public automataFinite(String patron) {
        this.patron = patron;
        int patronLength = patron.length();
        int Size = 256;
        tablaDeTransicion = new int[patronLength + 1][Size];
        for (int estado = 0; estado <= patronLength; estado++) {
            for (int ch = 0; ch < Size; ch++) {
                tablaDeTransicion[estado][ch] = getNextestado(patron, estado, ch);
            }
        }
    }

    public int getNextestado(String patron, int estado, int ch) {
        if (estado < patron.length() && ch == patron.charAt(estado)) {
            return estado + 1;
        }
        for (int i = estado; i > 0; i--) {
            if (patron.charAt(i - 1) == ch) {
                int j = 0;
                while (j < i - 1 && patron.charAt(j) == patron.charAt(estado - i + 1 + j)) {
                    j++;
                }
                if (j == i - 1) {
                    return i;
                }
            }
        }

        return 0;
    }

    public List<Integer> search(String text) {
        List<Integer> occurrences = new ArrayList<>();
        int estadoAct = 0;

        for (int i = 0; i < text.length(); i++) {
            estadoAct = tablaDeTransicion[estadoAct][text.charAt(i)];
            if (estadoAct == patron.length()) {
                occurrences.add(i - patron.length() + 1);
                System.out.println("Pattern found at index " + (i - patron.length() + 1));
            }
        }

        return occurrences;
    }
}