import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        ArrayDeque<String> links = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String current = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!links.isEmpty()) {
                    current = links.pop();
                    System.out.println(current);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                if (!current.equals("")) {
                    links.push(current);
                }
                current = line;
                System.out.println(current);
            }
            line = scanner.nextLine();
        }
    }
}
