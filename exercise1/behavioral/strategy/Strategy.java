package exercise1.behavioral.strategy;


interface BookingStrategy {
    void bookTicket(String passengerName, String destination);
}
class OnlineBooking implements BookingStrategy {
    @Override
    public void bookTicket(String passengerName, String destination) {
        System.out.println("✅ Ticket booked online for " + passengerName +
                " to " + destination + ". Payment done via UPI/Card.");
    }
}


class CounterBooking implements BookingStrategy {
    @Override
    public void bookTicket(String passengerName, String destination) {
        System.out.println("✅ Ticket booked at counter for " + passengerName +
                " to " + destination + ". Payment done with cash.");
    }
}

// Context
class TicketSystem {
    private BookingStrategy strategy;

    // allow changing strategy at runtime
    public void setStrategy(BookingStrategy strategy) {
        this.strategy = strategy;
    }

    public void processBooking(String passengerName, String destination) {
        if (strategy == null) {
            System.out.println("⚠️ No booking method selected!");
        } else {
            strategy.bookTicket(passengerName, destination);
        }
    }
}

public class Strategy {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        system.setStrategy(new OnlineBooking());
        system.processBooking("Madhan", "Chennai");
        system.setStrategy(new CounterBooking());
        system.processBooking("Santhiya", "Chennai");
    }
}
