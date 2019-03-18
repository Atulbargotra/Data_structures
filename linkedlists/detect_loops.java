/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlists;

import linkedlists.dlist.Node;
import static linkedlists.dlist.head;

/**
 *
 * @author atulb //floyds cycle detection algorithm in linked list
 */
class dlist {

    static Node head;

    static class Node {

        Node next;
        int data;

        Node(int d) {
            data = d;
            next = null;
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
    public void rotate(Node headd,int k)
        {
            if(k==0)
            return;
         Node temp = headd;
          for(int i=0;i<k-1;i++)
          {
              temp = temp.next;
          }
         Node temp2 = temp.next;
         temp.next=null;
         temp = head;//
         head=temp2;
         while(temp2.next!=null)
         {
             temp2=temp.next;
         }
         temp2.next=temp;
     }

    public void detect(Node head) {
        Node p = head;
        Node q = head;
        while (q != null && p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                System.out.println("Found a loop..................");
                System.out.println("Finding start element of loop................");
               p=head;
               while(p!=q)
               {
                   p=p.next;
                   q=q.next;
               }
                System.out.println("Start element of loop is "+p.data);
                q=p;
                while(q.next!=p)
                    q=q.next;
                q.next=null;
                break;
            }
        }
      
    }
    
}

public class detect_loops {

    public static void main(String[] args) {
        dlist list = new dlist();
        list.head = new Node(4);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
        //head.next.next.next.next.next = head.next.next;  ////////////creating a loop in linkedlist
      // list.detect(list.head);
        list.rotate(list.head, 4);
       list.show(list.head);
    }

}
