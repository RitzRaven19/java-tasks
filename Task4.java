
import java.util.Scanner;

public class Task4 {
    private static final int SIZE = 9;

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Sudoku puzzle (0 for empty cells):");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        if (solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

        scanner.close();
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= SIZE; num++) { // Try numbers 1-9
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // Place the number

                            if (solveSudoku(board)) { // Recursively try to solve
                                return true;
                            }

                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found, trigger backtracking
                }
            }
        }
        return true; // Solved
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check the row
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check the column
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check the 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true; // Safe to place the number
    }

    private static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.print("\n");
        }
    }
}