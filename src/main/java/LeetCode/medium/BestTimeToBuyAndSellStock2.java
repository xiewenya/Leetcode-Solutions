package LeetCode.medium;

/**
 * Created by bresai on 2017/1/4.
 */

//my first dp solution, haha
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }

        int[] earnings = new int[prices.length];
        earnings[0] = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < prices[i-1]){
                earnings[i] = earnings[i-1];//
            }else {
                earnings[i] = prices[i] - prices[i-1] + earnings[i-1];
            }
        }

        return earnings[prices.length - 1];
    }

    public static void main(String[] args){
        BestTimeToBuyAndSellStock2 object = new BestTimeToBuyAndSellStock2();
        int[] array = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(object.maxProfit(array));
    }

}
