public class sudoku {
  // Function of sudoku solver ---------------------------------------
    public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit) {
      // is safe for that column ? vertically ?
      for (int i = 0; i < 9; i++) {
        if (sudoku[i][col] == digit) {
          return false;
        }
      }
  
      // is safe for that row ? horizontally ?
      for (int j = 0; j < 9; j++) {
        if (sudoku[row][j] == digit) {
          return false;
        }
      }
  
      // is safe for that grid ? that particular 3x3 grid
      int sr = (row / 3) * 3; // sr: starting row
      int sc = (col / 3) * 3; // sc: starting column
      // 3x3 grid
      for (int i = sr; i < sr + 3; i++) {
        for (int j = sc; j < sc + 3; j++) {
          if (sudoku[row][col] == digit) {
            return false;
          }
        }
      }
  
      return true;
  
    }
  
  **// this is recursive function**
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
      // Base case
      if (row == 9) {
        return true;
      }
  
      // Recursion Part
  
      // A way to traverse in sudoku from col to col then next row and then again col
      // to col
      int nextRow = row, nextCol = col + 1;
      if (col + 1 == 9) {
        nextRow = row + 1;
        nextCol = 0;
      }
  
      if (sudoku[row][col] != 0) {
        sudokuSolver(sudoku, nextRow, nextCol);
      }
  
      // checker, if digit can be placed in the (row, col) or not?
      for (int digit = 1; digit <= 9; digit++) {
        if (isSafeSudoku(sudoku, row, col, digit)) {
          sudoku[row][col] = digit;
          if (sudokuSolver(sudoku, nextRow, nextCol)) { // if solution exist for digit for next row/col then do
            return true;
          }
          sudoku[row][col] = 0;
        }
      }
  
      return false;
  
    }
  
    public static void sudokuPrint(int sudoku[][]) {
      for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
          System.out.print(sudoku[row][col] + " ");
        }
        System.out.println();
      }
    }
  
    // Function of sudoku solver ends---------------------------------------
  
  public static void main(String args[]) {
  
  int sudoku[][] = {
          { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
          { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
          { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
          { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
          { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
          { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
          { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
          { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
          { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
      };
  
      if (sudokuSolver(sudoku, 0, 0)) {
        System.out.println("Solution exist.");
      } else {
        System.out.println("Solution does not exist.");
      }
  
  }
  
  }