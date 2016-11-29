package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 16/9/8.
 */
public class RestoreIp {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length()<4||s.length()>12) return result;

        getCombination(result, s, "", 1);

        return result;
    }

    private void getCombination(List<String> result, String string, String tmp, int count){
        if ( count  == 4 ) {
            if (Integer.parseInt(string) < 256)
                result.add(tmp + string);
            return;
        }

        if (string.equals("")){
            return;
        }

        for ( int i = 3; i > 0; i--){
            String subString;
            try{
                subString = string.substring(0, i);
                if (Integer.parseInt(subString) > 256){
                    break;
                }
                getCombination(result, string.substring(i), tmp + subString + ".", count + 1);

            } catch (Exception e){
                subString = string;
                if (Integer.parseInt(subString) > 256){
                    break;
                }
                getCombination(result, string, tmp + subString + ".", count + 1);

            }




        }
    }

    public static void main(String[] args){
        String s = "0000";
        RestoreIp ip = new RestoreIp();
        List<String> result = ip.restoreIpAddresses(s);
        System.out.println(result);
    }
}
