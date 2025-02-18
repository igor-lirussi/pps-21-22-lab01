package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount implements BankAccount {

    double balance;
    final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public boolean deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
            return true;
        }
    return false;
    }

    @Override
    public boolean withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
