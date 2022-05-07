package Workshop.SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
    }

    private void resize(){
        capacity = capacity * 2;
        int[]temp = new int[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int size() {
        return size;
    }

    private void shrink(){
        capacity = capacity / 4;
        int[] temp = new int[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }data = temp;
    }

    public void shiftLeft(int index){
        for (int i = index + 1; i < this.size; i++) {
            data[i - 1] = data[i];
        }data[size - 1] = 0;
    }

    private void shiftRight(int index){
        size++;
        for (int i = this.size; i > index; i--) {
            data[i] = data[i - 1];
        }
    }

    public void add(int element){
        if(this.size == this.capacity){
            this.resize();
        }
        data[size] = element;
        size++;
    }

    private void checkIndex(int index){
        if(index < 0 || index > size - 1){
            String exception = String.format("Index %d is out of bounds for length %d", index, size);
            throw new IndexOutOfBoundsException(exception);
        }
    }

    public int get(int index){
       checkIndex(index);
       return this.data[index];
    }

    public int remove(int index){
        this.checkIndex(index);
        int element = data[index];
        this.shiftLeft(index);
        this.size--;
        if(size == capacity / 4){
            this.shrink();
        }
        return element;
    }

    public boolean contains(int element){
        for (int i = 0; i < size - 1; i++) {
            if(element == data[i]){
                return true;
            }
        }return false;
    }

    public void add(int index, int element){
        if(size == capacity){
            resize();
        }
        checkIndex(index);
        shiftRight(index);
        data[index] = element;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }
}
