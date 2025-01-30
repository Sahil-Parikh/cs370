
import java.util.Scanner;

public class TicTacToe {

  private static final int BOARD_SIZE = 3;

  private enum Status {
    WIN, DRAW, CONTINUE;
  }

  private char[][] board; // Stores the values played on the board (mutable)
  private boolean firstPlayer; // (Mutable)
  private boolean gameOver; // (Mutable)
  private Scanner scanner; // Receives user input (mutable)

  public TicTacToe() {
    board = new char[BOARD_SIZE][BOARD_SIZE];
    // Initialize board with empty spaces
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        board[i][j] = ' ';
      }
    }
    firstPlayer = true;
    gameOver = false;
    scanner = new Scanner(System.in);
  }

  // Game logic
  public void play() {
    // TODO: implement play function
    while (!gameOver) {
      char currentSymbol = firstPlayer ? 'X' : 'O';

      System.out.println("Player " + currentSymbol + "'s turn.");
      System.out.print("Player " + currentSymbol + ": Enter row (0, 1, or 2): ");
      int row = scanner.nextInt();
      System.out.print("Player " + currentSymbol + ": Enter column (0, 1, or 2): ");
      int column = scanner.nextInt();
      System.out.println(row);
      System.out.println(column);
      // Check if valid move
      // Check game status
    }
  }

  private void printStatus(int player) {
    // TODO: implement printStatus function
  }

  private Status gameStatus() {
    // TODO: Check for winning combinations: horizontal, vertical, and diagonal

    // If there are empty spaces on the board, we can CONTINUE playing
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (board[i][j] == ' ') {
          firstPlayer = !firstPlayer;
          return Status.CONTINUE;
        }
      }
    }

    // No winning combinations and no empty spaces... it's a DRAW!
    return Status.DRAW;
  }

  public void printBoard() {
    // TODO: implement printBoard function
  }

  private void printSymbol(int column, char value) {
    // TODO: implement printSymbol function
  }

  private boolean validMove(int row, int column) {
    // Checks if the values of row and column are between 0 and 2 and if the
    // corresponding value is empty
    return row >= 0 && row < BOARD_SIZE &&
        column >= 0 && column < BOARD_SIZE &&
        board[row][column] == ' ';
  }

  public static void main(String[] args) {
    // TODO: implement main function
    System.out.println("Starting Tic-Tac-Toe program...");
    new TicTacToe().play();
  }
}
