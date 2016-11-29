package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bresai on 16/9/6.
 */


/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].*/

public class addSum {
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length - 1; i++){
            map.put(nums[i], i);
        }

        for ( int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }

        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        int[] a;
        int[] nums = {2, 7, 11, 15};
        for (int i = 0; i < 10000000; i++) {
            a = twoSum1(nums, 9);
        }
        long end = System.currentTimeMillis();
        System.out.println("costs:" + (end - begin));
    }
}
