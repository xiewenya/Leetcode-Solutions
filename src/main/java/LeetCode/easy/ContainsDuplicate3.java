package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bresai on 2016/9/27.
 */
public class ContainsDuplicate3 {
    public static boolean containsDuplicate2(int[] nums, int k, int t) {
        if (k == 0) return false;
        if (t < 0) return false;
        if (t == 0) return containsDuplicate3(nums, k);
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (Integer value : map.keySet()) {
                if (nums[i] >= value) {
                    if (nums[i] - t <= value) {
                        for (Integer index : map.get(value)) {
                            if (i - index <= k) {
                                return true;
                            }
                        }
                    }
                } else {
                    if (value - t <= nums[i]) {
                        for (Integer index : map.get(value)) {
                            if (i - index <= k) {
                                return true;
                            }
                        }
                    }
                }

            }

            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(nums[i], tmp);
            }
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums, int k) {
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

    public static void main(String[] args) {
        int[] nums = {-1, 2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(containsDuplicate2(nums, k, t));
    }
}
