package others.chapter1;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class Urlify {
    public static void main(String[] args){
        System.out.println(urlify("12 123 321".toCharArray(), 14));
    }

    public static char[] urlify(char[] str, int trueLen){
        char[] newStr = new char[trueLen];
        int gap = 0;
        for(int i=0; i < str.length; i++){
            if (str[i] == ' '){
                newStr[i + gap] = '%';
                gap++;
                newStr[i + gap] = '2';
                gap++;
                newStr[i + gap] = '0';
            }else{
                newStr[i + gap] = str[i];
            }
        }

        return newStr;
    }
}
