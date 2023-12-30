public class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private int balance;

    public BankAccount(int accountNumber, String accountHolderName, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        System.out.println("Depositing " + amount + " to " + accountNumber);
        System.out.println();
        balance += amount;
    }

    public void withdraw(int amount) {
        if (balance > amount) {
            System.out.println("Withdrawing " + amount + " from " + accountNumber);
            System.out.println();
            balance -= amount;
        }
        else {
            System.out.println("insuficient balance");
        }
    }

    public void accountInformation() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("===============");
    }
}
