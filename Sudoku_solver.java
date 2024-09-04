package String;

public class Sudoku_solver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(solve(board)){
            dispay(board);
        }
    }

    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // this is how we will change the value of row and col in the argument
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if we find some empty elements in the row then break
            if(emptyLeft == false){
                break;
            }
        }
        if(emptyLeft == true){
            return true;
            // this means sudoku is solved
        }

        //backtrack
        // put the numbers at the empty places
        for (int number = 1; number <= 9; number++) {
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(solve(board)){
                    //answer found
                    return true;
                    // it means this is the correct answer
                }
                else{
                    //backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void dispay(int[][] board){
        for (int[] row: board) {
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        // check for the row
        for (int i = 0; i < board.length; i++) {
            //check if the num is already present in the row
            if(board[row][col] == num){
                return false;
            }
        }
        // check for the col
        for (int i = 0; i < board.length; i++) {
            //check if the num is already present in the col
            if(board[row][col] == num){
                return false;
            }
        }
        //check for the 3*3 matrix
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }

        }
        return  true;
    }
}
