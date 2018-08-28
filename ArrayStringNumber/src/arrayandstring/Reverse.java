package arrayandstring;

/**
 * Created by Bikash on 3/10/2017.
 * Write code to reverse a C-Style String.
 */
public class Reverse {
    //Time Complexity: O(n/2)
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int min = 0;
        int max = chars.length - 1;
        for (; min < chars.length / 2; min++) {
            char temp = chars[min];
            chars[min] = chars[max - min];
            chars[max - min] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("ABCDE"));
        System.out.println(reverseBits(1));
    }

    public static int reverseBits(int n) {
        String bit = Integer.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 32 - bit.length(); i++) {
            stringBuilder.append("0");
        }

        stringBuilder.append(bit);

        String reverseBit = reverseString(stringBuilder.toString());

        return (int) Long.parseLong(reverseBit, 2);
    }
}
