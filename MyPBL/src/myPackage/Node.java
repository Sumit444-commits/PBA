package myPackage;

 public class Node {
    State data;
    Node next;

    public Node(State state) {
        this.data = state;
        this.next = null;
    }
}