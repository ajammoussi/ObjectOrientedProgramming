public class Main {
    public static void main(String[] args) {
        Duck[] ducks = new Duck[4];
        ducks[0] = new MallardDuck();
        ducks[1] = new RedheadDuck();
        ducks[2] = new RubberDuck();
        ducks[3] = new DecoyDuck();
        for (int i = 0; i < ducks.length; i++) {
            ducks[i].display();
            if (ducks[i] instanceof Flyable)
                ((Flyable) ducks[i]).fly();
            if (ducks[i] instanceof Quackable)
                ((Quackable) ducks[i]).quack();
        }
    }
}