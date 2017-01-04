package LeetCode.medium;

/**
 * Created by bresai on 2016/12/5.
 */
// TODO: 2016/12/5 not passed yet
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n <= 0){
            return 0;
        }
        int[] list = new int[n+1];
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i <= n; i++){
            int j = 1;
            while (j <= i){
                list[i] += list[j-1]*list[i-j];
                j++;
            }
        }

        return list[n];
    }

    public static void main( String[] args){
        UniqueBinarySearchTrees object = new UniqueBinarySearchTrees();
        System.out.println(object.numTrees(3));
    }

}
