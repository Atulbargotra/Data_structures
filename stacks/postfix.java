/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import java.util.Stack;

/**
 *
 * @author atulb
 */
public class postfix {

    public static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String infix) {
        String postfix = new String();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); ++i) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.print("Error in expression");
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }
            while (!stack.isEmpty()) {
                infix += stack.pop();
            }
        return postfix;
    }

    public static void main(String[] args) {
        String exp = "a+b(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

}
