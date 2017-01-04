package LeetCode.medium;

/**
 * Created by bresai on 2017/1/4.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int number = 0;
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 1; i < chars.length; i++){
            for (int j = start; j < i; j++){
                if (chars[j] == chars[i]){
                    number = Math.max(number, i - start);
                    start = j + 1;
                    break;
                }
            }
        }
        number = Math.max(number, chars.length - start);
        return number;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters object = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(object.lengthOfLongestSubstring("a"));
    }

}
