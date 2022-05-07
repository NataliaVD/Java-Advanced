package Workshop.LinkedList;

public class Test {
    public static void main (String[] args) throws Exception {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(2);
        linkedList.addFirst(1);

        linkedList.addLast(3);
        linkedList.addLast(4);

        System.out.println(linkedList.get(3));

        System.out.println(linkedList.removeFirst());

        System.out.println(linkedList.removeLast());

        linkedList.addFirst(1);
        linkedList.addLast(4);
        linkedList.forEach(System.out::println);

        int[] array = new int[linkedList.size()];
        array = linkedList.toArray();
        System.out.println();
        }
}
