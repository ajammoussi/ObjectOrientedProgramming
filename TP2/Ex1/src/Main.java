public class Main {
    public static void main(String[] args) {
        CustomStack s = new CustomStack(5);
        System.out.println("Stack is empty: " + s.StackIsEmpty());
        s.AddElement(2);
        s.AddElement(9);
        s.AddElement(5);
        s.AddElement(1);
        s.Show();
        System.out.println("Stack is empty: " + s.StackIsEmpty());
        s.RemoveElement();
        s.Show();
        System.out.println("Last element on stack: " + s.LastInStack());
        System.out.println("Stack is full: " + s.StackIsFull());
        s.AddElement(8);
        s.AddElement(7);
        s.Show();
        System.out.println("Stack is full: " + s.StackIsFull());
    }
}