package Workshop.LinkedList;

import java.util.EmptyStackException;
import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        Node current = null;
        if (index < size / 2) {
            current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = this.tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.item;
    }

    public int removeFirst() throws Exception {
        int element = 0;
        if(isEmpty()){
            throw new Exception("LinkedList is empty");
        }else if(size == 1){
            element = this.head.item;
            this.head = null;
            size--;
        }
        else {
            element = this.head.item;
            this.head = this.head.next;
            this.head.prev = null;
            size--;
        }return element;
    }

    public int removeLast() throws Exception{
        int element = 0;
        if(isEmpty()){
            throw new Exception("LinkedList is empty");
        }else if(size == 1){
            element = this.head.item;
            this.head = null;
            size--;
        }else {
            element = this.tail.item;
            tail = this.tail.prev;
            this.tail.next = null;
            size--;
        }return element;
    }

    public void forEach(Consumer<Integer> consumer){
        Node currentNode = this.head;
        while (currentNode != null){
            consumer.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node currentNode = this.tail;
        int index = size - 1;
        while (index >= 0){
            array[index] = currentNode.item;
            currentNode = currentNode.prev;
            index--;
        }return array;
    }

    public int size(){
        return size;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds for length %d", index, size));
        }
    }

    public boolean isEmpty(){
       return size == 0;
    }
}
