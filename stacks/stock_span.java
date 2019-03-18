/*,
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author atulb
 */
public class stock_span{
    public static void getSpan(int[]price,ArrayList<Integer>span,int n){
        Stack<Integer>stack = new Stack<>();
        stack.push(0);
        span.add(1);
        for(int i=1;i<n;i++)
        {
            while(price[stack.peek()]<=price[i]&&!stack.isEmpty())
            {
                stack.pop();
            }
            span.add((stack.isEmpty())?(i+1):(i-stack.peek()));
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        int[]price = {100,80,60,70,60,75,85};
        ArrayList<Integer>span=new ArrayList<>();
        getSpan(price,span,price.length);
        System.out.println(span);
    }
}
