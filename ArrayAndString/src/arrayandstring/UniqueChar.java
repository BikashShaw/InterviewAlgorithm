package arrayandstring;

/**
 * Created by Bikash on 3/10/2017.
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class UniqueChar {
    //Time Complexity: O(n) --WORKS ONLY FOR ASCII
    public static boolean isUniqueChars(String str) {
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueChars(args[0]));
    }
}
