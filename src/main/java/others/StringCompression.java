package others;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/9
 * @content:
 */
public class StringCompression {
    public static void main(String[] args){
        System.out.println(compressed("aaabcvvvvVVV"));
        System.out.println(compressed("a"));
        System.out.println(compressed("aa"));
        System.out.println(compressed("aaa"));
        System.out.println(compressed(""));
    }

    public static String compressed(String str){
        StringBuilder builder = new StringBuilder();

        if (str.length() <= 1){
            return str;
        }

        char lastChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == lastChar){
                count++;
                continue;
            }

            builder.append(lastChar).append(count);
            lastChar = str.charAt(i);
            count = 1;
        }

        builder.append(lastChar).append(count);

        String result = builder.toString();

        return result.length() > str.length() ? str : result;
    }
}
