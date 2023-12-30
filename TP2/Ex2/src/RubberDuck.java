public class RubberDuck extends Duck implements Quackable{

    @Override
    public void swim() {
        return;
    }

    @Override
    public void display() {
        System.out.println("I am a Rubber Duck !");
    }

    @Override
    public void waddle() {
        return;
    }

    @Override
    public void quack() {
        System.out.println("Quack quack !");
    }
}
