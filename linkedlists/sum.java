/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;

import linkedlists.linked_list.Node;
import static linkedlists.linked_list.head1;
import static linkedlists.linked_list.head2;

/**
 *
 * @author atulb
 */
class linked_list {

    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    int carry = 0;
    int sum = 0;

    Node lhead = null;

    public Node add(Node he1, Node he2) {
        Node h1 = he1;
        Node h2 = he2;
        while (true) {
            if (h1 == null) {
                sum = carry + (h2.data);
            }
            if (h2 == null) {
                sum = h1.data + carry;
            } else {
                sum = (h1.data + h2.data) + carry;
            }
            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            insert(sum);
            if (h1 != null) {
                h1 = h1.next;
            }
            if (h2 != null) {
                h2 = h2.next;
            }
            if (h1 == null && h2 == null) {
                break;
            }
        }
        return lhead;
    }

    public Node insert(int data) {

        Node n = new Node(data);
        if (lhead == null) {
            lhead = n;
        } else {
            Node temp = lhead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
        return lhead;
    }

    public void show(Node h) {
        Node temp = h;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }
}

public class sum {

    public static void main(String[] args) {
        linked_list list = new linked_list();
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        list.show(head1);
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        list.show(head2);
        list.show(list.add(head1, head2));
    }

}
