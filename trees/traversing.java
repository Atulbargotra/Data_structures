/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import trees.tree.Node;

/**
 *
 * @author atulb
 */
class tree {

    Node rootN = null;

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void inorder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                return;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public void postorder(Node root) {
        if (root != null) {
            int maxleft = Integer.MIN_VALUE;
            int maxright = Integer.MIN_VALUE;
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    public void deepest_node(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        System.out.println(temp.data);
    }

    public void level_order(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public void Reverse_level_order(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Node temp = null;
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            stack.push(temp.data);
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void createTree(int data) {
        Node node = new Node(data);
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        if (rootN == null) {
            rootN = node;
            return;
        }
        queue.add(rootN);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            //System.out.println(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            } else {
                temp.left = node;
                queue.clear();
                return;
            }
            if (temp.right != null) {
                queue.add(temp.right);
            } else {
                temp.right = node;
                queue.clear();
                return;
            }
        }
    }

    public int countNodes(Node root)//recursively
    {
        if (root == null) {
            return 0;
        } else {
            return countNodes(root.left) + 1 + countNodes(root.right);
        }
    }

    public void countNodesNR(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        int count = 0;
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            count++;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        System.out.println(count);
    }

    public void delete_node(int data, Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        Node delete_node = null;
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            if (temp.data == data) {
                System.out.println("found node");
                delete_node = temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        queue.clear();
        Node deepest = temp;
        delete_node.data = deepest.data;
        temp = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.remove();
            if (temp.left == deepest) {
                temp.left = null;
            }
            if (temp.right == deepest) {
                temp.right = null;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        deepest = null;
        temp = null;
        delete_node = null;
        System.gc();
    }
}

public class traversing {

    public static void main(String[] args) {
        tree t = new tree();
        //t.inorder(t.rootN);
        //t.postorder(t.rootN);
        //t.level_order(t.rootN);
        t.createTree(1);
        t.createTree(2);
        t.createTree(3);
        t.createTree(4);
        t.createTree(5);
        t.createTree(6);
        t.createTree(7);
        //System.out.println(t.countNodes(t.rootN));
        //t.level_order(t.rootN);
        //t.countNodesNR(t.rootN);
        //t.Reverse_level_order(t.rootN);
        t.delete_node(4, t.rootN);
        t.level_order(t.rootN);

    }

}
