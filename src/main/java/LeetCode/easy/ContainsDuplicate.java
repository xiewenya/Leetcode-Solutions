package LeetCode.easy;

import java.util.*;

/**
 * Created by bresai on 2016/9/27.
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
//        if (nums.length == 0) return false;
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num : nums){
            set.add(num);
        }
        return !(set.size() == nums.length);
    }

    public static void main(String[] args){
        int[] nums = {};
        System.out.println(containsDuplicate(nums));

    }
}
