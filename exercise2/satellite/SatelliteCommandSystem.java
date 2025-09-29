package exercise2.satellite;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SatelliteCommandSystem {
    public static void main(String[] args) {
Satellite satellite = new Satellite();
Map<String, Command> commands = new HashMap<>();
commands.put("rotate", new RotateCommand(satellite));
commands.put("activatepanels", new ActivatePanelsCommand(satellite));
commands.put("deactivatepanels", new DeactivatePanelsCommand(satellite));
commands.put("collectdata", new CollectDataCommand(satellite));
commands.put("status", new StatusCommand(satellite));

        boolean running = true;
        System.out.println("Satellite Command System Initialized. Type 'exit' to quit.");
        satellite.displayStatus();

        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.print("\nEnter command > ");
                String input = scanner.nextLine();
                if (input == null || input.trim().isEmpty()) {
                    continue;
                }
                
                String[] parts = input.trim().split("\\s+");
                String commandName = parts[0].toLowerCase();

                if (commandName.equals("exit")) {
                    running = false;
                } else {
                    Command command = commands.get(commandName);
                    if (command != null) {
                        command.execute(parts);
                    } else {
                        System.out.println("Error: Unknown command '" + commandName + "'.");
                    }
                }
            }
        }
        System.out.println("Satellite Command System Shutting Down.");
    }
}

interface PanelState {
    void collectData(Satellite satellite);
    String getStatus();
}

class ActivePanelState implements PanelState {
    @Override
    public void collectData(Satellite satellite) {
        satellite.setDataCollected(satellite.getDataCollected() + 10);
        System.out.println("Data collected.");
    }

    @Override
    public String getStatus() { return "Active"; }
}

class InactivePanelState implements PanelState {
    @Override
    public void collectData(Satellite satellite) {
        System.out.println("Error: Cannot collect data. Solar panels are inactive.");
    }

    @Override
    public String getStatus() { return "Inactive"; }
}

class Satellite {
    private String orientation;
    private int dataCollected;
    private PanelState panelState;

    public Satellite() {
        this.orientation = "North";
        this.dataCollected = 0;
        this.panelState = new InactivePanelState();
    }

    public int getDataCollected() { return dataCollected; }
    public void setDataCollected(int data) { this.dataCollected = data; }
    public void setPanelState(PanelState state) { this.panelState = state; }

    public void rotate(String direction) {
        this.orientation = direction;
        System.out.println("Satellite orientation set to " + direction + ".");
    }
    
    public void collectData() {
        panelState.collectData(this);
    }

    public void displayStatus() {
        System.out.println("--- Satellite Status ---");
        System.out.println("  Orientation: " + this.orientation);
        System.out.println("  Solar Panels: " + this.panelState.getStatus());
        System.out.println("  Data Collected: " + this.dataCollected);
        System.out.println("------------------------");
    }
}

interface Command {
    void execute(String[] args);
}

class RotateCommand implements Command {
    private final Satellite satellite;

    public RotateCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: Rotate command requires a direction (North, South, East, West).");
            return;
        }
        String direction = args[1];
        if (direction.matches("(?i)North|South|East|West")) { // Case-insensitive match
            satellite.rotate(direction);
            satellite.displayStatus();
        } else {
            System.out.println("Error: Invalid direction '" + direction + "'.");
        }
    }
}

class ActivatePanelsCommand implements Command {
    private final Satellite satellite;

    public ActivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute(String[] args) {
        satellite.setPanelState(new ActivePanelState());
        System.out.println("Solar panels activated.");
        satellite.displayStatus();
    }
}

class DeactivatePanelsCommand implements Command {
    private final Satellite satellite;

    public DeactivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute(String[] args) {
        satellite.setPanelState(new InactivePanelState());
        System.out.println("Solar panels deactivated.");
        satellite.displayStatus();
    }
}

class CollectDataCommand implements Command {
    private final Satellite satellite;

    public CollectDataCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute(String[] args) {
        satellite.collectData();
        satellite.displayStatus();
    }
}

class StatusCommand implements Command {
    private final Satellite satellite;
    public StatusCommand(Satellite satellite) { this.satellite = satellite; }
    
    @Override
    public void execute(String[] args) { 
        satellite.displayStatus(); 
    }
}