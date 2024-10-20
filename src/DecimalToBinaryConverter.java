import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = scanner.nextInt();

        Deque<String> binaryNumberStack = new ArrayDeque<>();

        if (decimalNumber == 0) {
            System.out.println(0);
        } else {
            while (decimalNumber != 0) {
                int remainder = decimalNumber % 2;
                binaryNumberStack.push(String.valueOf(remainder));
                decimalNumber /= 2;
            }


            System.out.println(String.join("", binaryNumberStack));
        }
    }
}
