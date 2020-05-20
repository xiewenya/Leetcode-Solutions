package others.chapter1;

import java.util.Arrays;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class CheckPermutation {

    public static void main(String[] args){
        System.out.println(isPermutation("asd", "dsa"));
        System.out.println(isPermutation("asd", "dsc"));

        System.out.println(isPermutation1("asd", "dsa"));
        System.out.println(isPermutation1("asd", "dsc"));
    }

    public static boolean isPermutation1(String str1, String str2){
        int[] booleans1 = new int[128];
        int[] booleans2 = new int[128];

        for (int i = 0; i < str1.length(); i++){
            int idx = str1.charAt(i) - 'a';
            booleans1[idx]++;
        }

        for (int i = 0; i < str2.length(); i++){
            int idx = str2.charAt(i) - 'a';
            booleans2[idx]++;
        }

        for (int i = 0; i < 128; i++){
            if (booleans1[i] != booleans2[i]){
                return false;
            }
        }

        return true;
    }


    public static boolean isPermutation(String str1, String str2){
        String str1Sorted = sortString(str1);
        String str2Sorted = sortString(str2);
        return str1Sorted.compareTo(str2Sorted) == 0;
    }

    private static String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
