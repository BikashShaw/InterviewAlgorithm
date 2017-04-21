package arrayandstring;

/**
 * Word Reverse
 * Created by Bikash on 3/31/2017.
 */
public class ReverseWord {

    public String wordReverse(String str) {
        String[] split = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) { //O(w)
            String s = split[i];

            builder.append(reverse(s.toCharArray()));
            builder.append(" ");
        }
        return builder.toString();
    }
    
    private String reverse(char chars[]) { // O(n/2)
        int n = chars.length - 1;
        for (int i = 0; i <= n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i];
            chars[n - i] = temp;
        }
       return  new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWord().wordReverse("this is a test"));
    }
}
