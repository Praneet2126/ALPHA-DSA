package Backtracking;

public class NQueens {
    // Different coloured text in terminal
    public static final String RESET = "\u001B[0m";  // Reset to default color
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";


    public static boolean isSafe(char board[][], int row, int col) {
        // vertically up
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonally up left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if(board[i][j] == 'Q') {
                    return false;
            }
        }

        // diagonally up right
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        //base
        if(row == board.length) {
            printBoard(board);
            count++;
            return;
        }

        //column loop
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
        }
    }

    public static boolean printOneSolution(char board[][], int row) {
        //base
        if(row == board.length) {
            return true;
        }

        //column loop
        for(int j=0; j<board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(printOneSolution(board, row+1)) {
                    return true;
                }
                board[row][j] = 'x';
            }
        }

        return false;
    }

    public static void printBoard(char board[][]) {
        System.out.println("------- Chess Board -------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printColouredBoard(char board[][]) {
        System.out.println("------------------");
        for(int i=0; i<board.length; i++) {
            System.out.print("| ");
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q') {
                    System.out.print(YELLOW + board[i][j] + " " + RESET);
                    System.out.print("| ");
                } else {
                    System.out.print(RED + board[i][j] + " " + RESET);
                    System.out.print("| ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------");

    }
    
    // To count ways:-
    static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = 'x';
            }
        }

        // nQueens(board, 0);

        // System.out.println();
        
        // System.out.println("Total ways to solve NQueens = "+count);

        //printOneSolution:
        if(printOneSolution(board, 0)) {
            System.out.println("Solution is possible");
            printColouredBoard(board);
        } else {
            System.out.println("No solution");
        }
    }
}
