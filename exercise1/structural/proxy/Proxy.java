package exercise1.structural.proxy;
interface Fan {
    void turnOn();
}

class RealFan implements Fan {
    @Override
    public void turnOn() {
        System.out.println("🌀 Fan is now ON... rotating smoothly!");
    }
}
class ClapProxy implements Fan {
    private final RealFan realFan = new RealFan();

    private boolean clapDetected(String sound) {
        return "CLAP".equalsIgnoreCase(sound);
    }

    @Override
    public void turnOn() {
        System.out.println("🔊 Listening for clap...");
        String sound = "CLAP"; 
        if (clapDetected(sound)) {
            System.out.println("👏 Clap detected!");
            realFan.turnOn();
        } else {
            System.out.println("❌ No clap detected, fan stays OFF.");
        }
    }
}

public class Proxy {
    public static void main(String[] args) {
        Fan fan = new ClapProxy();
        fan.turnOn();
    }
}
