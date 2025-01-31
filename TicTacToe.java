
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
      int player = currentSymbol == 'X' ? 1 : 2;

      System.out.print("Player " + currentSymbol + ": Enter row (0, 1, or 2): ");
      int row = scanner.nextInt();
      System.out.print("Player " + currentSymbol + ": Enter column (0, 1, or 2): ");
      int column = scanner.nextInt();

      // If we have a valid move...
      if (validMove(row, column)) {
        board[row][column] = currentSymbol;
        printBoard();
        firstPlayer = !firstPlayer;
        printStatus(player);
      } else {
        System.out.println("Invalid move. Please try again.");
      }
    }
  }

  private void printStatus(int player) {
    switch (gameStatus()) {
      case Status.WIN -> System.out.println("Player " + player + " wins.");
      case Status.DRAW -> System.out.println("Neither player wins; it's a draw.");
      default -> System.out.println("Player " + player + "'s turn.");
    }
  }

  private Status gameStatus() {
    // TODO: Check for winning combinations: horizontal, vertical, and diagonal

    // If there are empty spaces on the board, we can CONTINUE playing
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (board[i][j] == ' ') {
          return Status.CONTINUE;
        }
      }
    }

    // No winning combinations and no empty spaces... it's a DRAW!
    return Status.DRAW;
  }

  // Implements for loops to draw out the boards and players' symbols
  public void printBoard() {
    System.out.println("\n _______________________ "); // top border
    for (int i = 0; i < BOARD_SIZE; i++) { // loop to draw out the rows
      System.out.println("|       |       |       |");
      System.out.print("|   "); // start of row
      for (int j = 0; j < BOARD_SIZE; j++) { // loop to draw out columns
        printSymbol(j, board[i][j]); // and symbols inputted
      }
      System.out.println("   |"); // end of row
      System.out.println("\n|_______|_______|_______|"); // bottom border
    }
  }

  // Prints the symbol given by player and assists drawing the board
  private void printSymbol(int column, char value) {
    System.out.print(value); // print value given from player
    if (column < BOARD_SIZE - 1) { // if not last column
      System.out.print(" | "); // print separator
    }
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
