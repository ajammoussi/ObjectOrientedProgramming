public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(123, "John", 1000);
        bankAccount.accountInformation();
        bankAccount.deposit(100);
        bankAccount.withdraw(200);
        bankAccount.accountInformation();
    }
}