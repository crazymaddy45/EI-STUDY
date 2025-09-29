package exercise1.behavioral.observer;

import java.util.*;

interface AirtelUser {
    void update(String serverStatus);
}

class AirtelServer {
    private final List<AirtelUser> users = new ArrayList<>();
    private String status = "Active"; // default

    public void addUser(AirtelUser user) {
        users.add(user);
    }

    public void removeUser(AirtelUser user) {
        users.remove(user);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyUsers();
    }

    private void notifyUsers() {
        for (AirtelUser user : users) {
            user.update(status);
        }
    }
}

class Customer implements AirtelUser {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String serverStatus) {
        System.out.println("📱 " + name + " noticed: Airtel Server is " + serverStatus);
    }
}

public class Observer {
    public static void main(String[] args) {
        AirtelServer server = new AirtelServer();

        Customer u1 = new Customer("Ram");
        Customer u2 = new Customer("Priya");
        Customer u3 = new Customer("Karthik");

        server.addUser(u1);
        server.addUser(u2);
        server.addUser(u3);

        System.out.println("=== Server Running Normally ===");
        server.setStatus("Active");

        System.out.println("\n=== Server Down ===");
        server.setStatus("Down");

        System.out.println("\n=== Server Restored ===");
        server.setStatus("Active");
    }
}
