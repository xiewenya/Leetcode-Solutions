package LeetCode.easy;

/**
 * Created by bresai on 16/9/7.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) != ' '){
                count++;
            }
            else{
                if (count != 0)
                    break;
            }
        }
        return count;
    }
}
