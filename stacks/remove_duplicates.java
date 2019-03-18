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
public class remove_duplicates {
    public static void main(String[] args) {
        String str = "mis";
        Stack<Character>stack = new Stack<>();
        stack.push(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
           if(!stack.peek().equals(str.charAt(i)))
               stack.push(str.charAt(i));
           else if(stack.peek().equals(str.charAt(i)))
           {
               stack.pop();
               
           }
        }
        System.out.println(stack);
    }
    
}
