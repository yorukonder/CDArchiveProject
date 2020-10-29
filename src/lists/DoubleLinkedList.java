package lists;

public class DoubleLinkedList {

    // member: head and tail nodes
    Node head;
    Node tail;
    public static void main (String[] args ){

        DoubleLinkedList myList = new DoubleLinkedList();
        myList.append(new DoubleLinkedList.Node("a"));
        myList.append(new DoubleLinkedList.Node("b"));
        myList.append(new DoubleLinkedList.Node("c"));
        myList.prepend(new DoubleLinkedList.Node("K"));
        myList.insertAfter(myList.find("b"), new DoubleLinkedList.Node("G"));

        System.out.println( myList.toString());
        System.out.println(myList.toStringReverse());


    }


    public static class Node {
        // member: next and previous nodes
        Node next;
        Node previous;
        // member: to hold data
        Object data;
        // constructor: takes data as input
        public Node(Object data) { this.data = data; }

        // method: get data
        public Object getData() { return data; }

        // method: set data
        public void setData(Object data) { this.data = data; }

        // method: get next
        public Node getNext() { return next; }

        // method: get previous
        public Node getPrevious() { return previous; }
    }

    // method: prepend
    public void prepend(Node node) {
        if (this.head == null || this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
        }
    }
    // method find
    public Node find(Object data) {
        Node focusNode = this.head;

        while (focusNode != null) {
            if (focusNode.data == data) {
                return focusNode;
            }

            focusNode = focusNode.next;
        }

        return null;
    }

    // method: append
    public void append(Node node) {
        if (this.head == null || this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
        }

    }

    // method: insertAfter
    public void insertAfter(Node nodeBefore, Node nodeAfter) {
        if (nodeBefore == null || nodeBefore == this.tail) {
            append(nodeAfter);
            return;
        }
        nodeAfter.next = nodeBefore.next;
        nodeBefore.next.previous = nodeAfter;
        nodeBefore.next = nodeAfter;
        nodeAfter.previous = nodeBefore;


    }


    // method: remove
    public void remove(Node node) {
        if (node == this.head) {
            this.head = node.next;
        }

        if (node == this.tail) {
            this.tail = null;
        }

        Node focusNode = this.head;
        Node previousNode = null;

        while (focusNode != null) {
            if (focusNode == node) {
                previousNode.next = node.next;
            }

            previousNode = focusNode;
            focusNode = focusNode.next;
        }
    }


    // method: toString
    public String toString() {
        Node focusNode = this.head;
        String str = "DoubleLinkedList: ";

        while (focusNode != null) {
            str += focusNode.data.toString();
            if (focusNode.next != null) {
                str += " -> ";
            }
            focusNode = focusNode.next;
        }

        return str;
    }


    // method: toStringReverse
    public String toStringReverse(){
        Node focusNode = this.tail;
        String str1 = "ReverseDoubleLinkedList: ";
        while (focusNode != null){
            str1 += focusNode.data.toString();
            if (focusNode.previous != null){
                str1 += "<-";
            }
            focusNode = focusNode.previous;

        }
        return str1;
    }
}
