import java.util.Scanner;

class Main {
    public static final char PLAYER_X = 'X';
    public static final char PLAYER_O = 'O';
    public static final char EMPTY_SPACE = ' ';

    public static void main(String[] args) {
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);
            System.out.print("Player " + currentPlayer + " enter row and column (1-3): ");
            int row = scanner.nextInt() - 1; // Adjust for zero-based indexing
            int col = scanner.nextInt() - 1;
            System.out.println();

            if (isValidMove(board, row, col)) {
                board[row][col] = currentPlayer;
                if (hasWon(board, currentPlayer)) {
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    break;
                } else {
                    currentPlayer = switchPlayer(currentPlayer);
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
    }

    public static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        for (char[] row : board) {
            java.util.Arrays.fill(row, EMPTY_SPACE);
        }
        return board;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == EMPTY_SPACE;
    }

    public static boolean hasWon(char[][] board, char player) {
        // Implement win condition checks here
        return false; // Placeholder
    }

    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == EMPTY_SPACE) {
                    return false; // Found an empty cell
                }
            }
        }
        return true; // Board is full
    }

    public static char switchPlayer(char currentPlayer) {
        return (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }
}
