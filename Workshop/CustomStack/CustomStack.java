package Workshop.CustomStack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
    }

    public int size() {
        return size;
    }

    private void resize(){
        capacity = capacity * 2;
        int[]temp = new int[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void push(int element){
        if(size == capacity){
            resize();
        }
        size++;
        data[size - 1] = element;
    }

    public int pop(){
        checkSize();
        int element = data[size - 1];
        data[size - 1] = 0;
        size--;
        return element;
    }

    private void checkSize(){
        if(size == 0){
            throw new NoSuchElementException ("CustomStack is empty");
        }
    }

    public int peek(){
        checkSize();
        return data[size - 1];
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }
}
