package others.chapter1;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class OneAway {

    public static void main(String[] args){
        System.out.println(checkOneAway("pale", "ple"));
        System.out.println(checkOneAway("pale", "pble"));
        System.out.println(checkOneAway("pale", "paale"));
        System.out.println(checkOneAway("pales", "pale"));

        System.out.println(checkOneAway1("pale", "ple"));
        System.out.println(checkOneAway1("pale", "pble"));
        System.out.println(checkOneAway1("pale", "paale"));
        System.out.println(checkOneAway1("pales", "pale"));

    }

    public static boolean checkOneAway1(String str1, String str2){
        int gap = 0;
        int i = 0;
        int j = 0;
        while(i < (Math.min(str1.length(), str2.length()))){
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
                continue;
            }

            gap++;
            if (gap > 1){
                return false;
            }

            if (str1.length() == str2.length()){
                i++;
                j++;
                continue;
            }

            if (str1.length() > str2.length()){
                i++;
            } else{
                j++;
            }
        }

        return true;
    }

    public static boolean checkOneAway(String str1, String str2){
        int[] count1 = new int[128];
        int[] count2 = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            int idx = str1.charAt(i) - 'a';
            count1[idx]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int idx = str2.charAt(i) - 'a';
            count2[idx]++;
        }

        int gap = 0;
        for (int i = 0; i < 128; i++) {
            if (Math.abs(count1[i] - count2[i]) > 1){
                return false;
            }

            if (count1[i] - count2[i] == 1 ){
                gap++;
                continue;
            }

            if (count1[i] - count2[i] == -1 ){
                gap--;
            }
        }

        return gap == 0 || gap == -1 || gap == 1;
    }
}
