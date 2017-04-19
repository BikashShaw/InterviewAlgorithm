package string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 * Created by Bikash Shaw on 4/19/2017.
 */
public class LengthOfLastWord {
    public int length(String s) {
        if(s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] split = s.split(" ");
        return split[split.length -1].length();
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().length(" "));

    }
}
