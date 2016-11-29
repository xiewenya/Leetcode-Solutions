package LeetCode.easy;

import java.util.*;

/**
 * Created by bresai on 2016/9/27.
 */
public class ContainsDuplicate2 {
    public static boolean containsDuplicate(int[] nums, int k) {
        for(int i=0; i < nums.length; i++){
            int bound = i + k < nums.length ? i + k: nums.length - 1;
            for (int j = i + 1; j <= bound; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums, int k) {
        if (k == 0) return false;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i=0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                if ( i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,2,1};
        int k = 1;
        System.out.println(containsDuplicate2(nums, k));

    }
}
