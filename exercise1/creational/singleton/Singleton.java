package exercise1.creational.singleton;

class BankServer {
    private static BankServer instance;
    private double totalBalance = 0;
    private BankServer() {}
    public static BankServer getInstance() {
        if (instance == null) {
            instance = new BankServer();
            System.out.println("🏦 BankServer instance created.");
        }
        return instance;
    }
    public void deposit(double amount, String accountHolder) {
        totalBalance += amount;
        System.out.println(accountHolder + " deposited ₹" + amount + ". Total in BankSystem: ₹" + totalBalance);
    }

    public void withdraw(double amount, String accountHolder) {
        if (amount <= totalBalance) {
            totalBalance -= amount;
            System.out.println(accountHolder + " withdrew ₹" + amount + ". Total in BankSystem: ₹" + totalBalance);
        } else {
            System.out.println("❌ Transaction failed for " + accountHolder + ". Insufficient system balance.");
        }
    }
}
public class Singleton {
    public static void main(String[] args) {
        
        BankServer server1 = BankServer.getInstance();
        BankServer server2 = BankServer.getInstance();
        System.out.println("Are server1 and server2 same? " + (server1 == server2));

        server1.deposit(5000, "Madhan");
        server2.withdraw(2000, "Ajith");  
        server1.deposit(3000, "Rajini");
    }
}
