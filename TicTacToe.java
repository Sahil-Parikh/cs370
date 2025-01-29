
import java.util.Scanner;

public class TicTacToe {

  private static final int BOARD_SIZE = 3;

  private enum Status {
    WIN, DRAW, CONTINUE;
  }

  private char[][] board; // Stores the values played on the board
  private boolean firstPlayer;
  private boolean gameOver;
  private Scanner scanner; // Receives user input

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

  public void play() {
    // TODO: implement play function
  }

  // Called after printing the board
  private void printStatus(int player) {
    // TODO: implement printStatus function
  }

  // Called after each move
  private Status gameStatus() {
    // TODO: implement gameStatus function
    return Status.CONTINUE;
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
  }
}
