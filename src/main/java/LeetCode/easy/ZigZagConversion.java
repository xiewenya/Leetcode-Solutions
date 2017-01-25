package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 2017/1/9.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null){
            return null;
        }

        if (numRows == 1){
            return s;
        }

        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }
        char[] chars = s.toCharArray();

        int zig = 0;
        int zag = 0;
        boolean zigging = true;
        for (char string : chars){
            if (zag == numRows - 2){
                zigging = true;
                zag = 0;
            }
            if (zigging){
                list.get(zig).append(string);
                zig++;
                if (zig == numRows){
                    zigging = false;
                    zig = 0;
                }
            }else{
                    list.get(numRows - ++zag - 1).append(string);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            builder.append(list.get(i).toString());
        }
        return builder.toString();
    }

    public static void main(String[] args){
        ZigZagConversion object = new ZigZagConversion();
        System.out.println(object.convert("PAYPALISHIRING", 3));
    }
}
