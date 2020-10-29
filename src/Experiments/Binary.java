package Experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary {

    // Main method for testing
   // public static void main(String[] args) {
//
////        Experiments.Binary tree = new Experiments.Binary();
////
////        tree.insert(new Node(40, "World"));
////        tree.insert(new Node(50, "!"));
////        tree.insert(new Node(30, "Hello"));
////
////        prnt(tree.root);
//
//       Node[] nodes = new Node[] {
////                new Node(40, "World"),
////                new Node(50, "!"),
////                new Node(30, "Hello")
//        };
//
//        Binary tree = new Binary(Arrays.asList(nodes));
//
//        System.out.println("Pre-Order: " + tree.traversePreOrder());
//        System.out.println("In-Order: " + tree.traverseInOrder());
//        System.out.println("Post-Order" + tree.traversePostOrder());
//
//        prnt(tree.root);
//        //tree.find(30).setData("Hi");
//
//        System.out.println(tree.traverseInOrder());
//    }

    public static class Node {
        int key;
        Node left, right;
        Object data;

        public Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        public int getKey() {
            return key;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public String toString() {
            return Integer.toString(this.key) + " = " + this.data.toString();
        }
    }

    public static void prnt(Node n) {
        System.out.println(n.left);
        System.out.println(n.toString());
        System.out.println(n.right);
    }

    Node root;

    public Binary() {}

    public Binary(List<Node> nodes) {
        // add list of nodes to new tree

    }

    public Node find(int key) {
        return find(this.root, key);
    }

    private Node find(Node focusNode, int key) {
        // Find a node in the tree by key
        return null;
    }

    public void insert(Node insertNode) {
        if (this.root == null) {
            this.root = insertNode;
        } else {
            insert(this.root, insertNode);
        }
    }

    private void insert(Node focusNode, Node insertNode) {
        // Insert a node based on key
        if (insertNode.key < focusNode.key) {
            if (focusNode.left == null) {
                focusNode.left = insertNode;
            } else {
                insert(focusNode.left, insertNode);
            }
        }

        else if (insertNode.key > focusNode.key) {
            if (focusNode.right == null) {
                focusNode.right = insertNode;
            }
            else  {
                insert (focusNode.right , insertNode);
            }
        }
    }

    public ArrayList<Node> traversePreOrder() {
        return traversePreOrder(this.root);
    }

    private ArrayList<Node> traversePreOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        // Pre-Order traversal, save visited node to "nodes" array list

        return nodes;
    }

    public ArrayList<Node> traverseInOrder() {
        return traverseInOrder(this.root);
    }

    private ArrayList<Node> traverseInOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        // In-Order traversal, save visited node to "nodes" array list

        return nodes;
    }

    public ArrayList<Node> traversePostOrder() {
        return traversePostOrder(this.root);
    }

    private ArrayList<Node> traversePostOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        // Post-Order traversal, save visited node to "nodes" array list

        return nodes;
    }
}

