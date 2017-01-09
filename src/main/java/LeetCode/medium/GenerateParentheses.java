package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 2017/1/5.
 */
public class GenerateParentheses {
    private List<String> result = new ArrayList<>();
    int length;
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return result;
        }
        if (n == 1){
            result.add("()");
            return result;
        }

        String tmp = "(";
        length = n;
        generate('(', 2, 0, tmp);
        generate(')', 1, 1, tmp);

        return result;
    }

    private void generate(char append, int leftCount, int rightCount, String string){
        String tmp = string + append;
        if (tmp.length() == 2*length){
            result.add(tmp);
            return;
        }
        if (rightCount == length){
            return;
        }
        if (rightCount == leftCount){
            generate('(', leftCount+1, rightCount, tmp);
            return;
        }
        if (leftCount == length){
            generate(')', leftCount, rightCount + 1, tmp);
            return;
        }

        generate('(', leftCount+1, rightCount, tmp);
        generate(')', leftCount, rightCount + 1, tmp);
    }

    public static void main(String[] args){
        GenerateParentheses object = new GenerateParentheses();
        System.out.println(object.generateParenthesis(3));
    }
}
