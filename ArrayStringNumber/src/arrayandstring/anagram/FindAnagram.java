package arrayandstring.anagram;

/**
 * Find if two strings are anagram
 * Created by Bikash on 4/8/2017.
 */
public class FindAnagram {

    public static boolean isAnagram(String str1, String str2) {
        int count[] = new int[26];

        for (char c : str1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i : count) {
            if(i!=0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("schoolmaster", "theclassroom"));
    }
}
