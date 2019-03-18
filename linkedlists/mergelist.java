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
class mlist {

    class Node {

        Node next;
        int data;
    }
    Node head;

    public void insert(int data) {
        Node n = new Node();
        n.data = data;
        n.next = null;
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public void show(Node h) {
        Node temp = h;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

    public Node merge(Node headA, Node headB, Node sorted) {
        Node newhead = null;
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        if (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                sorted = headA;
                headA = sorted.next;
            } else {
                sorted = headB;
                headB = sorted.next;

            }
        }
        newhead = sorted;
        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                sorted.next = headA;
                sorted = headA;
                headA = sorted.next;
            } else {
                sorted.next = headB;
                sorted = headB;
                headB = sorted.next;
            }
        }
        if (headA == null) {
            sorted.next = headB;
        }
        if (headB == null) {
            sorted.next = headA;
        }
        return newhead;
    }

}

public class mergelist {

    public static void main(String[] args) {
        mlist p = new mlist();
        p.insert(1);
        p.insert(2);
        p.insert(4);
//        p.insert(90);
//        p.insert(100);
        //p.show(p.head);
        mlist q = new mlist();
        q.insert(3);
        q.insert(9);
//        q.insert(40);
//        q.insert(60);
//        q.insert(80);
        mlist s = new mlist();
        mlist obj = new mlist();
        obj.show(obj.merge(p.head, q.head, s.head));

    }

}
