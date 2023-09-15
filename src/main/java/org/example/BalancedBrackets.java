package org.example;

import java.util.Stack;
import java.util.HashMap;


public class BalancedBrackets {
    public static boolean balancedParentheses(String s) {
        int numUnclosedOpenParen = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == '(') {
                numUnclosedOpenParen += 1;
            } else if (s.charAt(i) == ')') {
                numUnclosedOpenParen -= 1;
            }
            if (numUnclosedOpenParen < 0) {
                return false;
            }
        }
        return numUnclosedOpenParen == 0;
    }

    public static boolean balancedBrackets(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < s.length(); i += 1) {
            if (bracketPairs.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (bracketPairs.containsKey(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String parenthesesExample = "((())())";
        String bracketsExample = "{[()]}";

        boolean isBalancedParentheses = balancedParentheses(parenthesesExample);
        boolean isBalancedBrackets = balancedBrackets(bracketsExample);

        System.out.println("Balanced Parentheses: " + isBalancedParentheses);
        System.out.println("Balanced Brackets: " + isBalancedBrackets);
    }
}


//1.The balancedParenthesis function has a runtime complexity of O(n),
// where n is the length of the input string s. It iterates through the string once and uses a counter to check for balanced parentheses.

//The balancedBrackets function has a runtime complexity of O(n), where n is the length of the input string s.
// It uses a stack to check for balanced brackets.

//2. They all have O(n) runtime complexity and use different approaches to check for balanced brackets or parentheses.
// The key difference lies in the scope of brackets they can handle.

//3. If I were to implement a queue, the key difference would be in how elements are removed from the data structure.
