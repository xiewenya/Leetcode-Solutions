package LeetCode.easy;

import java.util.*;

/**
 * Created by bresai on 2017/1/4.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        int i = 1;
        List<Character> open = new ArrayList<>(Arrays.asList('(','[', '{'));
        List<Character> end = new ArrayList<>(Arrays.asList(')',']', '}'));
        while(i < s.length()){
            if (open.contains(chars[i])){
                stack.push(chars[i]);
            }else if (end.contains(chars[i])){
                try {
                    char tmp = stack.pop();
                    if (tmp != chars[i] - 1 && tmp != chars[i] - 2){
                        return false;
                    }
                } catch (Exception e){
                    return false;
                }
            }
            i++;
        }

        return stack.isEmpty();
    }
}
