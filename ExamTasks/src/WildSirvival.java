import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class WildSirvival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] beeGroups = scanner.nextLine().split(" ");
        String[] beeEatersGroups = scanner.nextLine().split(" ");

        Queue<Integer> beeGroupsQueue = new ArrayDeque<>();
        Deque<Integer> beeEatersGroupsStack = new ArrayDeque<>();

        for (String s : beeGroups) {
            beeGroupsQueue.offer(Integer.parseInt(s));
        }
        for (String s : beeEatersGroups) {
            beeEatersGroupsStack.push(Integer.parseInt(s));
        }

        while (!beeGroupsQueue.isEmpty() && !beeEatersGroupsStack.isEmpty()) {
            int firstGroupBees = beeGroupsQueue.poll();
            int lastGroupBeeEaters = beeEatersGroupsStack.pop();

            for (int i = lastGroupBeeEaters; i > 0; i--) {

                if (firstGroupBees >= 7) {
                    firstGroupBees -= 7;
                    lastGroupBeeEaters--;
                    // System.out.println(firstGroupBees);
                    // System.out.println(lastGroupBeeEaters);
                }
            }

            int lastGroupBeeEatersCapacity = lastGroupBeeEaters * 7;

            if (lastGroupBeeEatersCapacity > firstGroupBees) {
                beeEatersGroupsStack.push(lastGroupBeeEaters);
            } else if (firstGroupBees > lastGroupBeeEatersCapacity){
                beeGroupsQueue.offer(firstGroupBees);
            }
        }

        String finalMessage = "The final battle is over!";
        String beeGroupsLeftMessage = "Bee groups left: " + String.join(", ", beeGroupsQueue.stream().map(String::valueOf).toArray(String[]::new));
        String beeEatersGroupsLeftMessage = "Bee-eater groups left: " + String.join(", ", beeEatersGroupsStack.stream().map(String::valueOf).toArray(String[]::new));
        String noSurvivorsMessage = "But no one made it out alive!";

        System.out.println(finalMessage);
        if (!beeGroupsQueue.isEmpty()) {
            System.out.print(beeGroupsLeftMessage);
        } else if (!beeEatersGroupsStack.isEmpty()) {
            System.out.println(beeEatersGroupsLeftMessage);
        } else {
            System.out.println(noSurvivorsMessage);
        }
        System.out.println(beeGroupsQueue);
        System.out.println(beeEatersGroupsStack);
        System.out.println(beeEatersGroupsStack.peek());
        System.out.println(beeGroupsQueue.peek());
    }
}
