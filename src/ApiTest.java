import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ApiTest {
    @Test
    void getAccount_GivenAccountDoesNotExist_ThenReturnEmpty() {
        Api api = new Api();
        Optional<BankAccount> response = api.getAccount("user@email.dev", "password123");
        assertEquals(Optional.empty(), response);
    }

    @Test
    void getAccount_GivenAccountExists_ThenReturnAccount() {
        Api api = new Api();
        BankAccount bankAccount = new BankAccount("user@email.dev", "password123", "John Doe", 200.0, "savings");
        api.createAccount(bankAccount);

        Optional<BankAccount> response = api.getAccount("user@email.dev", "password123");
        assertTrue(response.isPresent());
        assertEquals("user@email.dev", response.get().getEmail());
    }


    @Test
    void createAccount_GivenAccountDoesNotExist_ThenReturnSuccess() {
        Api api = new Api();
        BankAccount bankAccount = new BankAccount("user@email.dev", "password123", "John Doe", 200.0, "savings");

        Map<String, Object> response = api.createAccount(bankAccount);
        assertEquals(true, response.get("success"));
    }

    @Test
    void createAccount_GivenAccountAlreadyExists_ThenReturnFailure() {
        Api api = new Api();
        BankAccount bankAccount = new BankAccount("user@email.dev", "password123", "John Doe", 200.0, "savings");
        api.createAccount(bankAccount);

        Map<String, Object> response = api.createAccount(bankAccount);
        assertEquals(false, response.get("success"));
    }
}