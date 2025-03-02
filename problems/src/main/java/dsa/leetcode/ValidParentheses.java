package dsa.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public String refLink() {
        return "https://leetcode.com/problems/valid-parentheses/description/";
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.solve("()[]{}"));
    }

    public boolean solve(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char character = s.charAt(index);
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            }

            if (stack.isEmpty() || character == ')' && stack.pop() != '(' || character == '}' && stack.pop() != '{' || character == ']' && stack.pop() != '[') {
                return false;
            }

            index++;
        }

        return stack.isEmpty();
    }
}
