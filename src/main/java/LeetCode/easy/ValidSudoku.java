package LeetCode.easy;

/**
 * Created by bresai on 2016/11/8.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i< board.length; i++){
            char[] column = board[i];
            for (int j = 0; j < column.length; j++){
                if (board[i][j] == '.') continue;

                int n= i/3*3;
                int m = j/3*3;

                for(int p= 0; p < column.length; p++){
                    if (p != j && board[i][p] == board[i][j]){
                        return false;
                    }
                }

                for(int q= 0; q < board.length; q++){
                    if (q != i && board[q][j] == board[i][j]){
                        return false;
                    }
                }

                for(int k = 0; k < 3; k++){
                    for (int l = 0; l < 3; l++){
                        if (i != n + k && j != m + l && board[n+k][m+l] == board[i][j]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        String[] suduko = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};

        char[][] list = new char[suduko.length][suduko.length];

        for (int i = 0; i < suduko.length; i++ ){
            list[i] = suduko[i].toCharArray();
        }

        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(list));
    }

}
