package LeetCode.easy;

/**
 * Created by bresai on 2017/1/4.
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int maxDiffer = 0;
        int minTmp = prices[0];
        for (int i = 1; i < prices.length; i ++){
            maxDiffer = Math.max(maxDiffer, prices[i-1] - minTmp);
            if (prices[i] < minTmp){
                minTmp = prices[i];
            }
        }
        maxDiffer = Math.max(maxDiffer, prices[prices.length - 1] - minTmp);
        return maxDiffer;
    }

    public static void main(String[] args){
        BestTimeToBuyAndSellStock object = new BestTimeToBuyAndSellStock();
        int[] array = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(object.maxProfit(array));
    }


}
