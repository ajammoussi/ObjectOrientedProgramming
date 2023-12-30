public class RedheadDuck extends Duck implements Flyable, Quackable{

    @Override
    public void swim() {
        return;
    }

    @Override
    public void display() {
        System.out.println("I am a Readhead Duck !");
    }

    @Override
    public void waddle() {
        return;
    }

    @Override
    public void fly() {
        System.out.println("I can fly !");
    }

    @Override
    public void quack() {
        System.out.println("Quack quack !");
    }
}
