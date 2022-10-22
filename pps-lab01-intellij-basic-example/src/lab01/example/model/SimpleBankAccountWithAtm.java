package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {


    private int fee = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }



    public void depositWithAtm(int userID, double amount) {
        deposit(userID, amount);
        withdraw(userID, fee);

    }

    public void withdrawWithAtm(int userID, double amount) {
        if(withdraw(userID, fee)) {
            withdraw(userID,amount);
        }
    }


}
