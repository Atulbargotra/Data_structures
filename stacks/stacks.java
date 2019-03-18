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
public class stacks {

    stack top = null;
    int length;
    class stack {
        int data;
        stack next;
        stack(int data) {
            this.data = data;
        }
    }

    stacks() {
        top = null;
        length = 0;
    }

    public void push(int data) {
        stack s = new stack(data);
        s.next = top;
        top = s;
        length++;
    }

    public int pop() {
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }
    public int getLength()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length==0;
    }
    public void printStack()
    {
        stack temp = top;
        System.out.print("[");
        while(temp.next!=null)
        {
            System.out.print(temp.data+",");
            temp=temp.next;
        }
        System.out.print(temp.data+"]");
    }
            
    public static void main(String[] args) {
        stacks obj = new stacks();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        //System.out.println(obj.pop());
        System.out.println(obj.length);
        obj.printStack();
    }
}
