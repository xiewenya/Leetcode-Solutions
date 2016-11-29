package LeetCode.medium;

import java.util.*;

/**
 * Created by bresai on 16/9/6.
 */
public class Sum3 {
    public static List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        Map map = new HashMap<Integer, Integer>();
        List<Integer> tmp = new ArrayList<>();
        for (int index = 0; index < nums.length; index++)
            tmp.add(nums[index]);
        for ( int i = 0; i < nums.length - 1; i++){
            int target = tmp.remove(0);
            List<List<Integer>> result = twoSum2(tmp, target);
            if ( result != null){
                for (List<Integer> list : result){
                    list.add(0, target);
                    Collections.sort(list);
                    if (! results.contains(list)){
                        results.add(list);
                    }
                }
            }
        }
        return results;
    }

    public static List<List<Integer>> twoSum2(List<Integer> nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        for ( int i = 0; i < nums.size(); i++){
            map.put(nums.get(i), i);
        }

        for ( int i = 0; i < nums.size(); i++){
            int complement = - nums.get(i) - target;
            if (map.containsKey(complement) && map.get(complement) != i){
                List<Integer> result = new ArrayList<Integer>();
                result.add(nums.get(i));
                result.add(complement);
                results.add(result);
            }
        }

        return results;
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Set<List<Integer>> results = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for ( int i = 0; i < nums.length - 2; i++){
            for ( int j = i + 1; j < nums.length; j ++){
                int complement = - nums[i] -  nums[j];
                if (map.containsKey(complement) &&
                        map.get(complement) != i &&
                        map.get(complement) != j){
                    List<Integer> result = new ArrayList<Integer>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(complement);
                    Collections.sort(result);
                    results.add(result);
                }
            }
            map.put(nums[i], i);
        }
        return new ArrayList<>(results);
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> results = threeSum(nums);
        System.out.print(results);
    }
}
