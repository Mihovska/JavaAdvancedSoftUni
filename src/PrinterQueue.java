import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Deque<String> filesForPrint = new ArrayDeque<>();

        while (!line.equals("print")) {
            if (line.equals("cancel")) {
                if (filesForPrint.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + filesForPrint.pollFirst());
                }
            } else {
                filesForPrint.offer(line);
            }
            line = scanner.nextLine();
        }
        System.out.println(String.join("\n", filesForPrint));
    }
}
