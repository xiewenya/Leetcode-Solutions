package LeetCode.medium;

/**
 * Created by bresai on 2017/1/23.
 */
public class SearchOfRange {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0){
                return new int[]{-1,-1};
            }

            if (nums.length == 1){
                if (nums[0] == target){
                    return new int[]{0, 0};
                } else {
                    return new int[]{-1,-1};
                }
            }
            return recursive(0, nums.length - 1, nums, target);
        }

        private int[] recursive(int start, int end, int[] nums, int target){
            if (start == end){
                if (nums[start] == target){
                    return new int[]{start,start};
                } else{
                    return null;
                }
            }

            int[] num1 = null, num2 = null;

            if (nums[(start + end)/2] >= target){
                num1 = recursive(start, (start + end)/2, nums, target);
            }

            if (nums[(start + end)/2 + 1] <= target){
                num2 = recursive((start + end)/2 + 1, end, nums, target);
            }

            if (num1 == null && num2 == null){
                return new int[]{-1,-1};
            }

            if (num1 == null){
                return num2;
            }

            if (num2 == null){
                return num1;
            }

            return new int[]{num1[0], num2[1]};
        }
}
