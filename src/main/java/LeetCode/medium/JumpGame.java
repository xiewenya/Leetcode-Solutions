package LeetCode.medium;

/**
 * Created by bresai on 16/9/9.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if ( nums[i + 1] >= last){
                last = i;
            }
        }

        return (last == 0);
    }

    public static void main(String[] args){
        int[] nums = {2, 5, 0, 0};
        boolean result = new JumpGame().canJump(nums);
        System.out.println(result);
    }
}
