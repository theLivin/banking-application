import java.util.*;

public class Api {
    ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Optional<BankAccount> getAccount(String email, String password){
        for(BankAccount bankAccount: bankAccounts){
            if(Objects.equals(bankAccount.getEmail(), email) && Objects.equals(bankAccount.getPassword(), password)){
                return Optional.of(bankAccount);
            }
        }
        return Optional.empty();
    }

    public Map<String, Object> createAccount(BankAccount bankAccount){
        if(getAccount(bankAccount.getEmail(), bankAccount.getPassword()).isPresent()){
            return Map.of("success", false, "message", "account already exists!");
        }

        bankAccounts.add(bankAccount);
        return Map.of("success", true, "message", "account created successfully!");
    }
}
