package Exam;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = fillMatrix(size, scanner);
        int row = 0;
        int col = 0;
        int gold = 0;
        boolean isOutOfBounds = false;

        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                if (matrix[rows][cols].equals("A")) {
                    row = rows;
                    col = cols;
                    break;
                }
            }
        }

        while (gold < 65){
            String command = scanner.nextLine();
            matrix[row][col] = "-";
            switch (command){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "right":
                    col++;
                    break;
                case "left":
                    col--;
                    break;
            }
            if(isOut(row, col, matrix)){
                isOutOfBounds = true;
                break;
            }else if(Character.isDigit(matrix[row][col].charAt(0))){
                int digit = Integer.parseInt(String.valueOf(matrix[row][col].charAt(0)));
                gold += digit;
            }else if(matrix[row][col].equals("M")){
                matrix[row][col] = "-";
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if(matrix[i][j].equals("M")){
                            row = i;
                            col = j;
                        }
                    }
                }
            }
            matrix[row][col] = "A";
        }
        if(isOutOfBounds){
            System.out.println("I do not need more swords!");
        }else{
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n", gold);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static boolean isOut(int row, int col, String[][] matrix){
        return (row < 0 || row >= matrix.length || col < 0 || col >= matrix.length);
    }

    private static String[][] fillMatrix(int size, Scanner scanner) {
        String[][] matrix = new String[size][size];
        for (int rows = 0; rows < size; rows++) {
            String[] row = scanner.nextLine().split("");
            matrix[rows] = row;
        }
        return matrix;
    }
}
/*
4
A9--
-M--
----
M---
right
down
left
 */