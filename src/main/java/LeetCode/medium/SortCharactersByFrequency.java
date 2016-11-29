package LeetCode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by bresai on 2016/11/7.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        StringBuilder result = new StringBuilder(s.length());
        Map<Character, Integer> map = new HashMap<>(60);
        Map<Integer, LinkedList<Character>> reversed = new HashMap<>(s.length());

        for(Character c : s.toCharArray()){
            if (map.get(c) == null){
                map.put(c, 1);
            } else{
                map.put(c, map.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (! reversed.containsKey(entry.getValue())){
                reversed.put(entry.getValue(), new LinkedList(Arrays.asList(entry.getKey())));
            } else{
                reversed.get(entry.getValue()).add(entry.getKey());
            }

        }

        for(int i=s.length(); i > 0; i--){
            if (reversed.get(i) != null){
                for(Character c : reversed.get(i)){
                    int j = i;
                    while( j-- > 0){
                        result.append(c);
                    }
                }
            }

        }

        return result.toString();
    }

    public static void main(String[] args){
        SortCharactersByFrequency sort = new SortCharactersByFrequency();
        System.out.println(sort.frequencySort("tree"));
    }
}
