package trees;

import CDArchiveProject.CDRecord;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

//        System.out.println("Pre-Order: " + tree.traversePreOrder());
//        System.out.println("In-Order: " + tree.traverseInOrder());
//        System.out.println("Post-Order" + tree.traversePostOrder());
//
    }

    public static class Node {
        int key;
        Node left, right;
        Object data;

        public Node(int key, Object data) {
            this.key = key;
            this.data = data;
        }

        public Node(CDRecord record) {
            this.key = record.getBarcode();
            this.data = record;
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

    Node root;

    public BinaryTree() {}

    public BinaryTree(List<Node> nodes) {

        // add list of nodes to new tree

        for (Node node : nodes){ this.insert(node); }
    }

    public Node find(int key) {
        return find(this.root, key);
    }

    private Node find(Node focusNode, int key) {
        if (focusNode.key == key) {
            return focusNode;
        }

        else if (  key < focusNode.key) {
            return find(focusNode.left, key);
        }
        else if ( key > focusNode.key) {
            return find(focusNode.right, key);
        }
        else { return null;
        }
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
        if (focusNode != null) {
            nodes.add(focusNode);
            nodes.addAll(traversePreOrder(focusNode.left));
            nodes.addAll(traversePreOrder(focusNode.right));
        }
        return nodes;
    }

    public ArrayList<Node> traverseInOrder() {
        return traverseInOrder(this.root);
    }

    private ArrayList<Node> traverseInOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        // In-Order traversal, save visited node to "nodes" array list

        if (focusNode != null) {
            nodes.addAll(traverseInOrder(focusNode.left));
            nodes.add (focusNode);
            nodes.addAll(traverseInOrder(focusNode.right));
        }

        return nodes;
    }

    public ArrayList<Node> traversePostOrder() {
        return traversePostOrder(this.root);
    }

    private ArrayList<Node> traversePostOrder(Node focusNode) {
        ArrayList<Node> nodes = new ArrayList<>();

        // Post-Order traversal, save visited node to "nodes" array list
        if (focusNode != null) {
            nodes.addAll(traversePostOrder(focusNode.left));
            nodes.addAll(traversePostOrder(focusNode.right));
            nodes.add(focusNode);
        }

        return nodes;
    }
}



