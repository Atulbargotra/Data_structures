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
import java.util.ArrayList;

class circularll {

    class Node {

        Node next;
        int data;

        public Node(int d) {
            data = d;
            next = null;
        }
    }
    public static Node last;
    int length;
    public static ArrayList<Node> list = new ArrayList<>();

    public circularll() {
        last = null;
    }

    public int getLength(Node h) {
        int l = 0;
        Node head = h;
        Node temp = head;
        while (temp.next != head) {
            l++;
            temp = temp.next;
        }
        return l + 1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insert(int data) {
        Node temp = new Node(data);
        if (last == null) {
            last = temp;
            last.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
    }

    public void insertAtFirst(int data) {
        Node f = new Node(data);
        if (last == null) {
            last = f;
        } else {
            f.next = last.next;
        }
        last.next = f;
    }

    public void show(Node n) {
        Node head = n;
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

    public ArrayList<Node> split(Node last) {
        if(last==null){
            return null;
        }
        Node head1 = last.next;
        Node head2 = null;
        Node last2 = last;
        Node temp = last.next;
        int l = 0;
        if (getLength(last.next) % 2 == 0) {
            l = getLength(last.next) / 2;
            for (int i = 0; i < l-1; i++) {
                temp = temp.next;
            }
        } else {
            l = (getLength(last.next) / 2) + 1;
            for (int i = 0; i < l-1; i++) {
                temp = temp.next;
            }
        }
        head2 = temp.next;
        temp.next = head1;
        last2.next = head2;
        list.add(head1);
        list.add(head2);
        return list;
    }

    public static void main(String[] args) {
        circularll obj = new circularll();
        obj.insert(35);
        obj.insert(45);
        obj.insert(78);
        obj.insert(65);
        obj.insert(86);
        obj.insert(46);
        //System.out.println("Length of circular singly linked list is "+obj.getLength());
        obj.split(last);
        obj.show(list.get(0));
         obj.show(list.get(1));
    }
}
