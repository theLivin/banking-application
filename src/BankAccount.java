import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    private String email;
    private String password;
    private String name;
    private double balance;
    private String accountType;
    private ArrayList<String> history = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public BankAccount(String email, String password, String name, double balance, String accountType) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    private Date getNow() {
        return new Date();
    }

    public void deposit(double amount){
        balance += amount;
        String h = getNow() + "\n(deposit) GHc" + amount + "\n";
        history.add(h);
    }

    public boolean withdraw(double amount){
        if(amount > balance) return false;

        balance -= amount;
        history.add(getNow() + ": (withdrawal) GHc" + amount);
        return true;
    }

    public void printHistory() {
        System.out.println("TRANSACTION HISTORY");
        for(String history: history){
            System.out.println(history);
        }
        System.out.println("==========\n");
    }

    public ArrayList<String> getHistory() {
        return history;
    }
}
