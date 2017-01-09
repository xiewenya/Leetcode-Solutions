package LeetCode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bresai on 2017/1/6.
 * 这个问题只是求解最长路径，但是先求解所有文件路径虽然性能肯定不好，但是更容易理解。
 *
 * 由于每个文件节点的父节点一定是最近一次访问的上层目录节点，并且我们需要缓存每一层
 * 当前节点的路径。因此，我们可以结合DFS和动态规划算法思路来求解这个问题。
 *
 * 首先维护一个缓存列表用于存放中间目录节点的绝对路径，再维护一个结果列表，用于存放
 * 所有文件的绝对路径。
 *
 * 在循环中，先算出当前节点的层级。如果当前节点是目录，那么拼接父节点和该节点的路径，
 * 并存放于缓存列表中。如果当前节点是文件，那么拼接父节点和该节点的路径，并存放于结
 * 果列表。
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] splitter = input.split("\n");
        String[] cache = new String[splitter.length + 1];
        cache[0] = "";
        List<String> list = new ArrayList<>();
        for (String string : splitter){
            int currentLevel = string.lastIndexOf("\t") + 2;

            if (string.contains(".")){
                list.add(cache[currentLevel - 1] + "/" + string.substring(currentLevel - 1, string.length()));
            }else{
                cache[currentLevel] = cache[currentLevel - 1] + "/" + string.substring(currentLevel - 1, string.length());
            }
        }
        return list.stream().max(Comparator.comparing(String::length)).map(max -> max.length() - 1).orElse(0);
    }

    public static void main(String[] args){
        LongestAbsoluteFilePath object = new LongestAbsoluteFilePath();
        System.out.println(object.lengthLongestPath("a"));
    }
}
