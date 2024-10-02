import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");

        Deque<String> tokensStack = new ArrayDeque<>();
        Collections.addAll(tokensStack, tokens);

        while (tokensStack.size() > 1) {
            int firstNumber = Integer.parseInt(tokensStack.pop());
            String operator = tokensStack.pop();
            int secondNumber = Integer.parseInt(tokensStack.pop());

            int result = switch (operator) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                default -> 0;
            };

            tokensStack.push(String.valueOf(result));
        }

        System.out.println(tokensStack.pop());
    }
}
