package Exam;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] queue = scanner.nextLine().split("\\s+");
        String[] stack = scanner.nextLine().split("\\s+");
        ArrayDeque<String> vowelsQueue = fillQueue(queue);
        ArrayDeque<String> consonants = fillStack(stack);
        List<String> food = new ArrayList<>();

        while (!consonants.isEmpty() && !vowelsQueue.isEmpty()){
            String vowel =vowelsQueue.peek();
            String consonant = consonants.peek();
            if("pear".contains(vowel)){
                food.add(vowel);
            }if("pear".contains(consonant)){
                food.add(consonant);
            }if("olive".contains(vowel)){
                food.add(vowel);
            }if("olive".contains(consonant)){
                food.add(consonant);
            }if("pork".contains(vowel)){
                food.add(vowel);
            }if("pork".contains(consonant)){
                food.add(consonant);
            }if("flour".contains(vowel)){
                food.add(vowel);
            }if("flour".contains(consonant)){
                food.add(consonant);
            }
            vowelsQueue.poll();
            vowelsQueue.offer(vowel);
            consonants.pop();
        }

        List<String> currentFood = new ArrayList<>();
       if(food.contains("p") && food.contains("e") && food.contains("a") && food.contains("r")){
           currentFood.add("pear");
       }
       if(food.contains("f") && food.contains("l") && food.contains("o") && food.contains("u") && food.contains("r")){
            currentFood.add("flour");
        }
       if(food.contains("p") && food.contains("o") && food.contains("r") && food.contains("k")){
            currentFood.add("pork");
        }
       if(food.contains("o") && food.contains("l") && food.contains("i") && food.contains("v") && food.contains("e")){
            currentFood.add("olive");
        }

        System.out.println("Words found: " + currentFood.size());
       currentFood.forEach(System.out::println);
    }

    private static ArrayDeque<String> fillQueue(String[] queue) {
        ArrayDeque<String> queueDeque = new ArrayDeque<>();
        for (String el : queue) {
            queueDeque.offer(el);
        }
        return queueDeque;
    }

    private static ArrayDeque<String> fillStack(String[] stack) {
        ArrayDeque<String> stackDeque = new ArrayDeque<>();
        for (String el : stack) {
            stackDeque.push(el);
        }
        return stackDeque;
    }
}
/*
e a u o
p r l x f
 */