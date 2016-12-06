package LeetCode.medium;

/**
 * Created by bresai on 2016/12/5.
 */
// TODO: 2016/12/5 not passed yet
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++){
            count += buildTree(1, i - 1);
            count += buildTree(i+1, n);
        }

        return count;
    }

    private int buildTree(int start, int end){
        int count = 0;
        if (start == end) return 1;
        for (int i = start; i <= end; i++){
            count += buildTree(start, i - 1);
            count += buildTree(i + 1, end);
        }

        return count;
    }

    public static void main( String[] args){
        UniqueBinarySearchTrees object = new UniqueBinarySearchTrees();
        System.out.println(object.numTrees(2));
    }

}
