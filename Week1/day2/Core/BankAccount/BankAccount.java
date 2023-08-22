import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;
    private static int totalAccounts = 0;
    private static double totalBalance = 0;

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
        totalBalance += (checkingBalance + savingsBalance);
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        long number = rand.nextLong() % 10000000000L;
        if (number < 0) {
            number *= -1;
        }
        return String.format("%010d", number);
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public String deposit(String accountType, double amount) {
        if (amount > 0) {
            if (accountType.equals("checking")) {
                checkingBalance += amount;
            } else if (accountType.equals("savings")) {
                savingsBalance += amount;
            }
            totalBalance += amount;
            return String.format("Deposited $%.2f into %s account.", amount, accountType);
        } else {
            return "Invalid deposit amount.";
        }
    }

    public String withdraw(String accountType, double amount) {
        if (amount > 0) {
            if (accountType.equals("checking")) {
                if (checkingBalance >= amount) {
                    checkingBalance -= amount;
                    totalBalance -= amount;
                    return String.format("Withdrew $%.2f from %s account.", amount, accountType);
                } else {
                    return "Insufficient funds in checking account.";
                }
            } else if (accountType.equals("savings")) {
                if (savingsBalance >= amount) {
                    savingsBalance -= amount;
                    totalBalance -= amount;
                    return String.format("Withdrew $%.2f from %s account.", amount, accountType);
                } else {
                    return "Insufficient funds in savings account.";
                }
            }
        }
        return "Invalid withdrawal amount.";
    }

    public String totalMoney() {
        return String.format("Total money in both accounts: $%.2f", checkingBalance + savingsBalance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getTotalBalance() {
        return totalBalance;
    }
}
