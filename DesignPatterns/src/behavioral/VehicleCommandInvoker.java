package behavioral;


import java.util.ArrayList;
import java.util.List;

public class VehicleCommandInvoker {
    private List<Command> commandQueue = new ArrayList<>();

    // Add a command to the queue
    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    // Execute all commands in the queue
    public void executeCommands() {
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear(); // Clear the queue after execution
    }
}

