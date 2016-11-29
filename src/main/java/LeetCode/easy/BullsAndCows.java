package LeetCode.easy;

/**
 * Created by bresai on 2016/11/8.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] list = new int[10];
        if (secret.equals(guess)){
            return "4A0B";
        }

        for(int i= 0; i < secret.length(); i++){
            int b = guess.charAt(i) - '0';
            int a = secret.charAt(i) - '0';
            if (a == b){
                bull++;
            }else{
                if(list[a] < 0) cow++;
                if(list[b] > 0) cow++;
                list[a]++;
                list[b]++;
            }
        }
        return bull + "A" + cow + "B";
    }
}
