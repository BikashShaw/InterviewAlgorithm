package datastructure.linear;

import java.util.Stack;

/**
 * Created by Bikash on 3/27/2017.
 */
public class BalancedParentheses {

    public boolean isBalanced(String expession) {
        boolean balanced = true;
        Stack<Character> parenthesesStack = new Stack<>();
        for (int i = 0; i <expession.length() ; i++) {
            char parentheses = expession.charAt(i);
            if(parentheses == '(' || parentheses == '{' || parentheses == '[') {
                parenthesesStack.push(parentheses);
            } else if(!parenthesesStack.isEmpty() && parentheses == ')') {
                Character openParentheses = parenthesesStack.pop();
                if(openParentheses != '(') {
                    balanced = false;
                    break;
                }
            } else if(!parenthesesStack.isEmpty() && parentheses == '}'){
                Character openParentheses = parenthesesStack.pop();
                if (openParentheses != '{'){
                    balanced = false;
                    break;
                }
            }else if(!parenthesesStack.isEmpty() && parentheses == ']'){
                Character openParentheses = parenthesesStack.pop();
                if (openParentheses != '['){
                    balanced = false;
                    break;
                }
            }
        }
        return balanced && parenthesesStack.isEmpty();
    }

    public static void main(String[] args) {

        String exp1 = "[{(a+b)/(a-b)} * {(a+b)/(a-b)}]";
        System.out.println(exp1 + " - is balanced: " +
        new BalancedParentheses().isBalanced(exp1)); //Balanced

        String exp2 = "[{(a+b)/(a-b)} * {(a+b)/(a-b)]}";
        System.out.println(exp2 + " - is balanced: " + new BalancedParentheses().isBalanced(exp2)); // Not Balanced

        String exp3 = "[{(a+b)/({a-b)} * {(a+b)/(a-b))]}";
        System.out.println(exp3 + " - is balanced: " + new BalancedParentheses().isBalanced(exp3)); // Not Balanced

        String exp4 = "[a*{b-(c+d)*(e+f)/g}/h*(i%j)/k]";
        System.out.println(exp4 + " - is balanced: " + new BalancedParentheses().isBalanced(exp4)); // Balanced

        String exp5 = "[a*{b-(c+d)*(e+f)/g}/h*(i%j)/k[]";
        System.out.println(exp5 + " - is balanced: " + new BalancedParentheses().isBalanced(exp5)); // Not Balanced
    }
}
