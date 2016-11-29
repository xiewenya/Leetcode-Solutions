package LeetCode.medium;

/**
 * Created by bresai on 16/9/9.
 */
public class SortColor {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        for (int i = 0; i < blue + 1; i++){
            if(nums[i] == 0){
                nums[i] = nums[red];
                nums[red] = 0;
                red ++;
            }else if(nums[i] == 2){
                nums[i] = nums[blue];
                nums[blue] = 2;
                blue --;
                i --;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 0};
        new SortColor().sortColors(nums);
        System.out.print(nums);
    }
}
