import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long k = scanner.nextLong();

        Deque<Long> a = readDeque(scanner, n);

        if (!isPossible(a, k)) {
            System.out.println("Impossible");
            return;
        }

        long count = greedyRemove(a, k);

        System.out.println(count);
    }

    public static Deque<Long> readDeque(Scanner scanner, long n) {
        Deque<Long> deque = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            long current = scanner.nextLong();
            deque.add(current);
        }
        return deque;
    }

    private static boolean isPossible(Deque<Long> deque, long k) {
        for (long num : deque) {
            if (num > k) {
                return false;
            }
        }
        return true;
    }

    public static long greedyRemove(Deque<Long> deque, long k) {
        deque.stream().sorted();
        long count = 0;
        while (!deque.isEmpty()) {
            count++;
            if (deque.size() == 1) {
                break;
            }
            if (deque.getFirst() + deque.getLast() <= k) {
                deque.pollFirst();
            }
            deque.pollLast();
        }
        return count;
    }
}
