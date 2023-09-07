import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getHistory_GivenUserMakesTransactions_ThisHistoryShouldUpdate() {
        BankAccount bankAccount = new BankAccount("user@email.dev", "password123", "John Doe", 200.0, "savings");

        bankAccount.deposit(200.0);
        bankAccount.withdraw(200.0);
        bankAccount.deposit(50.0);

        assertEquals(3, bankAccount.getHistory().size());
    }
}