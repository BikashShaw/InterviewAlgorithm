package arrayandstring.anagram;

/**
 * Find if two strings are anagram
 * Created by Bikash on 4/8/2017.
 */
public class FindAnagram {

    public static boolean isAnagram(String str1, String str2) {
        boolean status = false;

        if(str1.length() != str2.length()) {
            return status;
        }

        StringBuilder sb = new StringBuilder(str2);
        for (int i = 0; i < str1.length(); i++) { //O(n)
            char c = str1.charAt(i);
            int index = sb.indexOf("" + c);
            if(index == -1) {
                break;
            }
            sb.deleteCharAt(index);
        }
        if(sb.length() == 0) {
            status = true;
        }
        return status;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("schoolmaster", "theclassroom"));
    }
}
