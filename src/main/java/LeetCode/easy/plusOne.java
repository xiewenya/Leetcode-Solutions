package LeetCode.easy;

/**
 * Created by bresai on 16/9/7.
 */
public class plusOne {
    public static int[] plusOne(int[] digits) {
        int idx = digits.length - 1;

        while (idx >= 0){
            if (digits[idx] == 9){
                digits[idx] = 0;
                if(idx == 0){
                    int[] result = new int[digits.length + 1];
                    System.arraycopy(digits, 0, result, 1, digits.length);
                    result[0] = 1;
                    return result;
                }
            }
            else{
                digits[idx] += 1;
                break;
            }
            idx--;
        }
        return digits;
    }

    public static void main(String[] args){
        int[] digits = {9,9};
        plusOne(digits);
    }
}
