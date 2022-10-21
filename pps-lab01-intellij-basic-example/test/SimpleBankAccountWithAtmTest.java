import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccountWitAtm;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccountWitAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
    }


    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccountWitAtm.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        bankAccountWitAtm.depositWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccountWitAtm.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccountWitAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWitAtm.depositWithAtm(2, 50);
        assertEquals(99, bankAccountWitAtm.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccountWitAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWitAtm.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(28, bankAccountWitAtm.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccountWitAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWitAtm.withdrawWithAtm(2, 70);
        assertEquals(99, bankAccountWitAtm.getBalance());
    }
}
