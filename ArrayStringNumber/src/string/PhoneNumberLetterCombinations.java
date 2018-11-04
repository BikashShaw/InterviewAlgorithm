package string;


import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumberLetterCombinations {
    private String[] phonePad = new String[]{" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {
        System.out.println(new PhoneNumberLetterCombinations().letterCombinations("021314"));
    }

    public List<String> letterCombinations(String digits) {

        LinkedList<String> output = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return output;
        }
        output.add("");
        while (output.peekFirst().length() != digits.length()) {
            String previousValue = output.remove();
            char c = digits.charAt(previousValue.length());
            String characters = phonePad[Character.getNumericValue(c)];
            for (int i = 0; i < characters.length(); i++) {
                output.addLast(previousValue + characters.charAt(i));
            }
        }
        return output;
    }

}
