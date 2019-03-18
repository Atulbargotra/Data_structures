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
public class Minimum_element {
    public static Stack<Integer>stack=new Stack<>();
       public static Stack<Integer>min=new Stack<>();
       public static Integer minimum;
        public static void insert(int data)
        {
            stack.push(data); 
            if(minimum==null){
                min.push(data);
               minimum = (Integer)min.peek();
            }
            else{
            if(min.peek()>data)
                min.push(data);
            else
                min.push(min.peek());
            }        
        }
        public static void delete()
        {
            stack.pop();
            min.pop();
        }
    public static void main(String[] args) {
        insert(4);
        insert(5);
        insert(3);
        insert(10);
        insert(20);
        insert(1);
        delete();
        System.out.println(stack);
        System.out.println(min);
        System.out.println("minimum is "+min.peek());
        
    }
    
}
