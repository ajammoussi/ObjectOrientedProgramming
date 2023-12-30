import java.util.Arrays;

public class CustomStack {
    private int[] stack;
    private int size = 0;

    public CustomStack(int capacity) {
        stack = new int[capacity];
    }

    public void AddElement(int element) {
        int i = 0;
        while (i < size)
            i++;
        stack[i] = element;
        size++;
    }

    public void RemoveElement() {
        stack[size - 1] = 0;
        size--;
    }

    public int LastInStack() {
        return stack[size - 1];
    }

    public boolean StackIsEmpty() {
        return size == 0;
    }

    public boolean StackIsFull() {
        return size == stack.length;
    }

    public void Show() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", stack[i]);
        }
        System.out.println();
    }
}
