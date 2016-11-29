package LeetCode.easy;

import java.util.List;

/**
 * Created by bresai on 2016/11/8.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        return findCommon(strs, 0, strs.length - 1);
    }

    private String findCommon(String[] strings, int from, int to){
        if (from == to) return strings[from];
        int mid = (from + to)/2;
        String left = findCommon(strings, from, mid);
        String right = findCommon(strings, mid + 1, to);
        return merge(left, right);
    }

    private String findCommon(List<String> strs){
        if (strs.size() == 1) return strs.get(0);
        String commonLeft = findCommon(strs.subList(0, strs.size()/2));
        String commonRight = findCommon(strs.subList(strs.size()/2, strs.size()));
        return merge(commonLeft, commonRight);
    }

    private String merge(String left, String right){
        int minLength = Math.min(left.length(), right.length());

        for (int i=0; i< minLength; i++){
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }

        return left.substring(0, minLength);
    }

}
