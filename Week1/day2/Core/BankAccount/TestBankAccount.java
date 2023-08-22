public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000, 2000);
        System.out.println("Checking balance: " + account1.getCheckingBalance());
        System.out.println("Savings balance: " + account1.getSavingsBalance());

        System.out.println(account1.deposit("checking", 500));
        System.out.println(account1.deposit("savings", 1000));

        System.out.println(account1.withdraw("checking", 300));
        System.out.println(account1.withdraw("savings", 1500));

        System.out.println(account1.totalMoney());

        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total balance across all accounts: " + BankAccount.getTotalBalance());
    }
}

