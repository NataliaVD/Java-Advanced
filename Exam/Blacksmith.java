package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Blacksmith {
    private static final int Gladius = 70;
    private static final int Shamshir = 80;
    private static final int Katana = 90;
    private static final int Sabre = 110;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] steels = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] carbons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> steelQueue = fillQueue(steels);
        ArrayDeque<Integer> carbonStack = fillStack(carbons);
        int gladius = 0;
        int katana = 0;
        int sabre = 0;
        int shamshir = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()){
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int sum = steel + carbon;
            switch (sum){
                case Gladius:
                    gladius++;
                    break;
                case Shamshir:
                    shamshir++;
                    break;
                case Katana:
                    katana++;
                    break;
                case Sabre:
                    sabre++;
                    break;
                default:
                    carbonStack.push(carbon + 5);
            }
        }
        if(gladius + shamshir + katana + sabre > 0){
            System.out.printf("You have forged %d swords.%n", gladius + shamshir + katana + sabre);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if(steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            System.out.print("Steel left: ");
            System.out.print(String.join(", ", steelQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        if(carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        }else{
            System.out.print("Carbon left: ");
            System.out.println(String.join(", ", carbonStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if(gladius > 0){
            System.out.println("Gladius: " + gladius);
        }
        if(katana > 0){
            System.out.println("Katana: " + katana);
        }if(sabre > 0){
            System.out.println("Sabre: " + sabre);
        }if(shamshir > 0){
            System.out.println("Shamshir: " + shamshir);
        }
    }

    private static ArrayDeque<Integer> fillStack(int[] carbons) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int carbon : carbons) {
            stack.push(carbon);
        }
        return stack;
    }

    private static ArrayDeque<Integer> fillQueue(int[] steels) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int steel : steels) {
            queue.offer(steel);
        }
        return queue;
    }
}
/*
40 50 70 120 10 20
30 20 30 20 30 50
 */