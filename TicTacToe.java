
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
    printBoard();
    while (!gameOver) {
      char currentSymbol = firstPlayer ? 'X' : 'O';

      System.out.print("Player " + currentSymbol + ": Enter row (0, 1, or 2): ");
      int row = scanner.nextInt();
      System.out.print("Player " + currentSymbol + ": Enter column (0, 1, or 2): ");
      int column = scanner.nextInt();

      // If we have a valid move...
      if (validMove(row, column)) {
        board[row][column] = currentSymbol; // Place symbol in space specified
        printBoard(); // Print the board
        switch (gameStatus()) {
          case CONTINUE -> firstPlayer = !firstPlayer;
          default -> gameOver = true;
        }
        System.out.println("Player " + currentSymbol + " played (" + row + ", " + column + ").");
        printStatus();
      } else {
        System.out.println("Invalid move. Please try again.");
      }
    }
  }

  // Prints the status of the game
  // e.g., "Player X wins." or "Player O's turn."
  private void printStatus() {
    char curSymbol = firstPlayer ? 'X' : 'O';
    switch (gameStatus()) {
      case WIN -> System.out.println("Player " + curSymbol + " wins.");
      case DRAW -> System.out.println("Neither player wins; it's a draw.");
      default -> System.out.println("Player " + curSymbol + "'s turn.");
    }
  }

  // Returns the status of the game
  private Status gameStatus() {
    // Check for horizontal and vertical winning combinations
    for (int i = 0; i < BOARD_SIZE; i++) {
      if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        return Status.WIN;
      }
      if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        return Status.WIN;
      }
    }

    // Check for diagonal winning combinations
    if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      return Status.WIN;
    }
    if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      return Status.WIN;
    }

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
      System.out.print("   |"); // end of row
      System.out.println("\n|_______|_______|_______|"); // bottom border
    }
  }

  // Prints the symbol given by player and assists drawing the board
  private void printSymbol(int column, char value) {
    System.out.print(value); // print value given from player
    if (column < BOARD_SIZE - 1) { // if not last column
      System.out.print("   |   "); // print separator
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
    System.out.println("Starting Tic-Tac-Toe program...");
    new TicTacToe().play();
  }
}
