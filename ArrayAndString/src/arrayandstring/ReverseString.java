package arrayandstring;
/**
 * Created by Bikash on 3/10/2017.
 * Write code to reverse a C-Style String.
 */
public class ReverseString {
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int min = 0;
        int max = chars.length - 1;
        for (; min < chars.length /2 ; min++) {
            char temp = chars[min];
            chars[min] = chars[max - min];
            chars[max - min] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString(args[0]));
    }
}
