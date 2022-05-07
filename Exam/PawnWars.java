package Exam;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        int cols = 8;
        char[][] matrix = fillMatrix(rows, cols, scanner);
        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                } else if (matrix[row][col] == 'b') {
                    blackRow = row;
                    blackCol = col;
                }
            }
        }

        while (true) {
            if (isOutOfBounds(matrix, whiteRow - 1, whiteCol - 1) && matrix[whiteRow - 1][whiteCol - 1] == 'b') {
                    System.out.println("Game over! White capture on " + positionName(whiteRow - 1, whiteCol - 1) + ".");
                    break;
            } else if (isOutOfBounds(matrix, whiteRow - 1, whiteCol + 1) && matrix[whiteRow - 1][whiteCol + 1] == 'b') {
                    System.out.println("Game over! White capture on " + positionName(whiteRow - 1, whiteCol + 1) + ".");
                    break;
            } else {
                matrix[whiteRow][whiteCol] = '-';
                whiteRow--;
                matrix[whiteRow][whiteCol] = 'w';
            }
            if (isOutOfBounds(matrix, blackRow + 1, blackCol - 1) && matrix[blackRow + 1][blackCol - 1] == 'w') {
                    System.out.println("Game over! Black capture on " + positionName(blackRow + 1, blackCol - 1) + ".");
                    break;
            } else if (isOutOfBounds(matrix, blackRow + 1, blackCol + 1) && matrix[blackRow + 1][blackCol + 1] == 'w') {
                    System.out.println("Game over! Black capture on " + positionName(blackRow + 1, blackCol + 1) + ".");
                    break;
            } else {
                matrix[blackRow][blackCol] = '-';
                blackRow++;
                matrix[blackRow][blackCol] = 'b';
            }
            if (whiteRow == 0) {
                System.out.println("Game over! White pawn is promoted to a queen at " + positionName(whiteRow, whiteCol) + ".");
                break;
            } else if (blackRow == rows - 1) {
                System.out.println("Game over! Black pawn is promoted to a queen at " + positionName(blackRow, blackCol) + ".");
                break;
            }
        }
    }
    private static String positionName(int row, int col){
        StringBuilder positionName = new StringBuilder();
        for (int i = 8; i >= 0; i--) {
            if (col == i) {
                positionName.append((char)(i + 97));
            }
        }

        int counter = 8;
        for (int i = 0; i < 8; i++) {
            if (row == i)
            {
                positionName.append(counter);
            }
            counter--;
        }return positionName.toString();
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length);
    }

    private static char[][] fillMatrix(int rows, int cols, Scanner scaner) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = scaner.nextLine().split("");
            for (int j = 0; j < line.length; j++) {
                char current = line[j].charAt(0);
                matrix[i][j] = current;
            }
        }
        return matrix;
    }
}
/*
--------
--------
--------
--------
--------
b-------
-w------
--------
 */