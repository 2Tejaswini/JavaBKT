package String;

public class N_Queen {
    public static void main(String[] args) {
        int n = 8;
        boolean[][] board = new boolean[n][n];
        System.out.println(queen(board, 0));
    }

    static int queen(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        //placing the queen and checking for each row and column
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count = count + queen(board, row + 1);
                board[row][col] = false;
            }

        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int r, int c){
        //we will check which place is safe to place the queen vertically diagonally left and right
        //vertically
        for (int i = 0; i < r; i++) {
            if(board[i][c]){
                return false;
            }
        }

        //diagonally left
        int maxleft = Math.min(r,c);
        for (int i = 1; i <= maxleft; i++) {
            if(board[r - i][c - i]){
                return false;
            }
        }

        //diagonally right
        int maxright = Math.min(r, board.length - c -1);
        for (int i = 1; i <= maxright; i++) {
            if(board[r - i][c + i]){
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board){
        for (boolean[] row: board) {
            for (boolean element: row) {
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
