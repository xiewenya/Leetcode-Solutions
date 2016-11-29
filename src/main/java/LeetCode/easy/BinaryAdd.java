package LeetCode.easy;

/**
 * Created by bresai on 16/9/11.
 */
public class BinaryAdd {
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        if (a.length() < length){

        } else {

        }
        StringBuilder stringBuilder = new StringBuilder();
        int add = 0;
        int tmp = 0;
        for ( int i = length - 1; i < length; i++){
            int atmp,btmp;

            try{
                atmp = Integer.parseInt(String.valueOf(a.charAt(i)));
            } catch (Exception e){
                atmp = 0;
            }

            try{
                btmp = Integer.parseInt(String.valueOf(b.charAt(i)));
            } catch (Exception e){
                btmp = 0;
            }

            int sum = atmp + btmp + add;

            if ( sum == 2){
                tmp = 0;
                add = 1;
            } else if ( sum == 3){
                tmp = 1;
                add = 1;
            } else {
                tmp = sum;
            }

            stringBuilder.insert(0, String.valueOf(tmp));
        }
        if (add == 1){
            stringBuilder.insert(0, '1');
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        String a = "1010";
        String b = "1011";

        new BinaryAdd().addBinary(a, b);
    }
}
