package others.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class IsUnique {

    public static void main(String[] args){
        System.out.println(isUnique("abcd"));
        System.out.println(isUnique1("abcd"));
        System.out.println(isUnique("abcda"));
        System.out.println(isUnique1("abcda"));
    }

    public static boolean isUnique(String str){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            if (set.contains(str.charAt(i))){
                return false;
            }

            set.add(str.charAt(i));
        }

        return true;
    }

    public static boolean isUnique1(String str){

        boolean[] hasSeen = new boolean[128];

        for(int i = 0; i < str.length(); i++){
            int rest = str.charAt(i) - 'a';

            if (hasSeen[rest]){
                return false;
            }

            hasSeen[rest] = true;
        }

        return true;
    }
}
