package others;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class RotateMatrix {

    public static void main(String[] args){

    }

    public static void rotate(int[][] matrix){
        int column = matrix.length;
        int row = matrix.length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = i; j < column; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[column - i - 1][j];
                matrix[column - i - 1][j] = matrix[column - i - 1][row - j - 1];
                matrix[column - i - 1][row - j - 1] = matrix[i][row - j - 1];
                matrix[i][row - j - 1] = tmp;
            }
        }
    }
}
