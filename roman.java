
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atulb
 */
public class roman {

    static int value(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'M') {
            return 1000;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int value1 = value(s.charAt(i));
            if (i + 1 < s.length()) {
                int value2 = value(s.charAt(i + 1));
                if (value1 >= value2) {
                     sum = sum+value1;
                } else {
                   sum = sum+value2-value1;
                   i++;
                }
            }
            else{
                sum = sum+value1;
                i++;
            }
        }
        System.out.println(sum);
    }

} 
    
