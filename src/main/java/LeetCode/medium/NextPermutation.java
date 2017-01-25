package LeetCode.medium;

import java.util.Arrays;

/**
 * Created by bresai on 2017/1/23.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null){
            return;
        }
        if (nums.length == 1){
            return;
        }

        recursive(nums, nums.length);
    }

    private boolean recursive(int[] nums, int length){
        if (length == 1){
            return false;
        }

        boolean res = recursive(nums, length - 1);

        if (res) return true;

        for (int i = 1; i < length; i++){
            if (nums[nums.length - length] < nums[nums.length - i]){
                swap(nums, length, i);
                flip(nums, nums.length - length + 1);
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int length, int i){
        int tmp = nums[nums.length - length];
        nums[nums.length - length] = nums[nums.length - i];
        nums[nums.length - i] = tmp;
    }

    private void flip(int[] nums, int start){
        for (int i = 0; i < (nums.length + 1 - start)/2; i++){
            int tmp = nums[start + i];
            nums[start + i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }

    public static void main(String[] args){
        NextPermutation object = new NextPermutation();
        int[] nums = new int[]{1,4,3,2};
        object.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
