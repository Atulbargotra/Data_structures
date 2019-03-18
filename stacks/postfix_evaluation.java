/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author atulb
 */
public class postfix_evaluation {
    public static boolean isOperator(char ch)
    {
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^')
            return true;
        return false;
    }
    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        Scanner kb = new Scanner(System.in);
        String postfix = kb.next();
        for(int i=0;i<postfix.length();i++)
        {
            char ch = postfix.charAt(i);
            if(Character.isDigit(ch)){
                int no = Integer.parseInt(String.valueOf(ch));
                stack.push(no);
            }
            else if(ch=='+')
            {
              int no1 = stack.pop();
              int no2 = stack.pop();
              stack.push(no2+no1);
              
            }
            else if(ch=='-')
            {
              int no1 = stack.pop();
              int no2 = stack.pop();
              stack.push(no2-no1);
              
            }
            else if(ch=='*')
            {
              int no1 = stack.pop();
              int no2 = stack.pop();
              stack.push(no2*no1);
              
            }
            else if(ch=='/')
            {
              int no1 = stack.pop();
              int no2 = stack.pop();
              stack.push(no2/no1);
              
            }
        }
        Integer res = (Integer)stack.pop();
        System.out.println(res);
    }
    
}
