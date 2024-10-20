import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int toss = Integer.parseInt(scanner.nextLine());

        Deque<String> kids = new ArrayDeque<>();

        for (String name : names) {
            kids.offer(name);
        }

        while (kids.size() > 1) {
            for (int i = 1; i < toss; ++i) {
                kids.offer(kids.poll());
            }
            System.out.println("Removed " + kids.poll());
        }
        System.out.println("Last is " + kids.peek());
    }
}

