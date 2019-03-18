/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;

/**
 *
 * @author atulb
 */
class list {

    class node {

        node next;
        int data;
    }
    node head;

    public void insert(int data) {
        node n = new node();
        n.data = data;
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public void show() {
        node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

    public int getpos(int n) {
        int pos = 1;
        node temp = head;
        while (temp.data != n) {
            temp = temp.next;
            pos++;
        }
        return pos;
    }

    public void swap(int d1, int d2) {
        int pos1 = getpos(d1);
        int pos2 = getpos(d2);
        node temp1 = head;
        node temp2 = head;
        for (int i = 1; i < pos1 - 1; i++) {
            temp1 = temp1.next;
        }
        for (int i = 1; i < pos2 - 1; i++) {
            temp2 = temp2.next;
        }
        node n = temp2.next;
        temp2.next = n.next;
        temp1.next = n;
        n.next = temp2;

    }

    public void reverse(node n) {
        node curr = n;
        node prev = null;
        node nxt = null;
        while (curr.next != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        curr.next = prev;
        head = curr;
        /////printing data
        node temp = curr;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}

public class swapnodes {

    public static void main(String[] args) {
        list o = new list();
        o.insert(7);
        o.insert(50);
        o.insert(4);
        o.insert(78);
        o.insert(45);
        o.swap(50, 4);
        o.show();
        System.out.println("==========================reverse========================");
        o.reverse(o.head);
    }

}
