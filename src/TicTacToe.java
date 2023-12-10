import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    final static char circle = 'O';
    final static char cross = 'X';
    final static char empty = ' ';

    static char[][] board;
    static int movesCounter;

    public static void initializeBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = empty;
            }
        }
        movesCounter = 0;
    }

    public static void displayBoard() {
        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n+---+---+---+");
        }
    }

    public static boolean insertMove(char player, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != empty) {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        board[row][col] = player;
        movesCounter++;
        return true;
    }

    public static boolean checkWinner(char player) {
        int[][] patterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
        };

        for (int[] pattern : patterns) {
            if (Arrays.stream(pattern).allMatch(index -> board[index / 3][index % 3] == player)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        initializeBoard();
        char currentPlayer = circle;
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameWon && movesCounter < 9) {
            displayBoard();
            System.out.print("Player " + currentPlayer + " enter move (row col): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (insertMove(currentPlayer, row, col)) {
                gameWon = checkWinner(currentPlayer);
                if (gameWon) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    currentPlayer = (currentPlayer == circle) ? cross : circle;
                }
            }
        }

        if (!gameWon) {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
