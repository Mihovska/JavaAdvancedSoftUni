import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int toss = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> kids = new PriorityQueue<>();

        for (String name : names) {
            kids.offer(name);
        }

        int countCycle = 1;
        while (kids.size() > 1) {
            for (int i = 1; i < toss; ++i) {
                kids.offer(kids.poll());
            }

            if (isPrime(countCycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            countCycle++;
        }
        System.out.println("Last is " + kids.poll());
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
