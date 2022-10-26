package com.example.calculator.arithmeticutils;

import java.util.Stack;

public class PostFixConverter {
    Stack<Character> stack = new Stack<>();
    private String postFix = "";

    public PostFixConverter(String expression) {
        for (int i = 0; i < expression.length(); ++i) {

            char c = expression.charAt(i);

            if (!Character.isLetterOrDigit(c))
                postFix += " ";

            if (Character.isLetterOrDigit(c))
                postFix += c;

            else if (c == '('){
                inputToStack(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(')
                    postFix += " " + stack.pop();
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek()) && (c == '+' || c == '-' || c == '/' || c == '*')) {
                    postFix += " " + stack.pop();
                }
                inputToStack(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                System.out.println("This expression is invalid");
            postFix += " " + stack.pop();
        }
    }

    private void inputToStack(char input) {
        stack.add(input);
    }

    private void clearStack() {
        stack.clear();
    }

    public String getPostfixExpression() {
        return postFix;
    }

    int getPrecedence(char ch)
    {
        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }
}
