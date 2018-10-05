package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        compute(n, n, "", result);

        return result;
    }

    public void compute(int open, int close, String str, List<String> result) {
        System.out.println("Open: " + open + " Close: " + close + " Str: " + str);
        if (open == 0 && close == 0) {
            System.out.println(str);
            result.add(str);
            return;
        }

        if (open > 0) {
            compute(open - 1, close, str + '(', result);
        }
        if (close > open) {
            compute(open, close - 1, str + ')', result);
        }
    }
}
