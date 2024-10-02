import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {

        // 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> bracketsStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); ++i) {
            char currentSymbol = input.charAt(i);

            if (currentSymbol == '(') {
                bracketsStack.push(i);
            } else if (currentSymbol == ')') {
                int startIndex = bracketsStack.pop();
                String contents = input.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
