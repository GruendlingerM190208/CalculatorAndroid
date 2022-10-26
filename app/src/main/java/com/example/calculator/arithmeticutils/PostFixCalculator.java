package com.example.calculator.arithmeticutils;

import java.math.BigDecimal;
import java.util.Stack;

public class PostFixCalculator {
    private String expression;

    public PostFixCalculator(String expression) {
        this.expression = expression;
    }

    public BigDecimal getResult() {
        Stack<Integer> calc = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            int x = 0;
            int y = 0;
            int r = 0;
            if (Character.isDigit(c)) {
                int t = Character.getNumericValue(c);
                calc.push(t);
            } else if (c == '+') {
                x = calc.pop();
                y = calc.pop();
                r = x + y;
                calc.push(r);
            } else if (c == '-') {
                x = calc.pop();
                y = calc.pop();
                r = x - y;
                calc.push(r);
            } else if (c == '*') {
                x = calc.pop();
                y = calc.pop();
                r = x * y;
                calc.push(r);
            } else if (c == '/') {
                x = calc.pop();
                y = calc.pop();
                r = x / y;
                calc.push(r);
            }
        }
        int result = 0;
        while (!calc.isEmpty()){
            result += calc.pop();
        }
        return BigDecimal.valueOf(result);
    }
}