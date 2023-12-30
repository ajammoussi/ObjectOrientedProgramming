package Library;

import Library.Lending;

import java.util.ArrayList;

public class LendingHistory {
    private ArrayList<Lending> lendings;

    public LendingHistory() {
        lendings = new ArrayList<Lending>();
    }

    public ArrayList<Lending> getLendings() {
        return lendings;
    }

    public void addLending(Lending lending) {
        lendings.add(lending);
    }

    public void showLendingHistory() {
        for (Lending lending : lendings) {
            lending.lendingInformation();
        }
        System.out.println("==========================");
    }

}
