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
public class sortedcll {

    class Node {

        Node next;
        int data;

        public Node(int d) {
            data = d;
            next = null;
        }
    }
    sortedcll()
    {
        head=null;
    }
    public static Node head;

    public void insert(int data) {
        Node node = new Node(data);
        Node temp = null;
        if (head == null) {
            head = node;
            node.next = head;
        }  
        else if (node.data > head.data)//if node data is greater than head node data
        {
            temp = head;
           while(temp.next!=head && temp.next.data<node.data)
           {
               temp=temp.next;
           }
           node.next=temp.next;
           temp.next=node;
        } else if (node.data < head.data) {
           ///first find out the last node...
           temp=head;
           while(temp.next!=head)
           {
               temp=temp.next;
           }
           temp.next=node;
           node.next=head;
           head=node;
        }
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
    public static void main(String[] args) {
      sortedcll obj = new sortedcll();
      obj.insert(9);
      obj.insert(5);
      obj.insert(6);
      obj.show(head);
    }

}
