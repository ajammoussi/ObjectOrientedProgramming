public class DecoyDuck extends Duck{

    @Override
    public void swim() {
        return;
    }

    @Override
    public void display() {
        System.out.println("I am a Decoy Duck !");
    }

    @Override
    public void waddle() {
        return;
    }
}
