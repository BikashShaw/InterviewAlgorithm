package number.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneDialPadLatterCombination {

    private static final HashMap<Character, String> map = new HashMap<>(8);

    static {
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        System.out.println(PhoneDialPadLatterCombination.letterCombinations("2345"));
    }

    //O(4^n)

    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        results.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = map.get(digits.charAt(i));
            List<String> nextResults = new ArrayList<>(letters.length() * results.size());
            for (String str : results) {
                for (int j = 0; j < letters.length(); j++) {
                    nextResults.add(str + letters.charAt(j));
                }
            }
            System.out.println(results);

            results = nextResults;
        }
        return results;
    }
}