package others;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class ZeroMatrix {

    public static void zero(int[][] matrix){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
