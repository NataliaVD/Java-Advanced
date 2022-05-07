package Workshop.LinkedList;

public class Node {
    public int item;
    public Node prev;
    public Node next;

    public Node(int item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item + "";
    }
}
