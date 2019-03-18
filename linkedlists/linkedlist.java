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
class node {

    node next;
    int data;

    node(int data) {
        this.data = data;
        next = null;
    }
}

public class linkedlist {

    static node head;

    public static void main(String[] args) {
        head = null;
        insert(new node(1));
        insert(new node(2));
        insert(new node(3));
        insert(new node(4));
        GFG obj = new GFG();
        obj.rotate(linkedlist.head, 2);
        show(linkedlist.head);
    }

    public static void insert(node node) {
        if (head == null) {
            head = node;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public static void show(node n) {
        node temp = n;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
class GFG{
    public static void rotate(node headd, int k) {
        if (k == 0) {
            return;
        }
        node temp = headd;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        node temp2 = temp.next;
        temp.next = null;
        temp = linkedlist.head;
        linkedlist.head = temp2;
        while (temp2.next != null) {
            temp2 = temp.next;
        }
        temp2.next = temp;
    }

}
