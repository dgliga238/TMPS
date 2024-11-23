# Behavioral Design Patterns


### Author: Gliga Daniela, FAF-223


## Objectives:
1. Study and understand the Behavioral Design Patterns.

2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.

3. Implement some additional functionalities using behavioral design patterns.


## Main Task:
1. By extending your project, implement at least 1 behavioral design pattern in your project:

- The implemented design pattern should help to perform the tasks involved in your system.
- The behavioral DPs can be integrated into you functionalities alongside the structural ones.
- There should only be one client for the whole system.

2. Keep your files grouped (into packages/directories) by their responsibilities.

3. Document your work in a separate markdown file.


## Used Design Patterns:
- **Command**


## Theory
Behavioral design patterns focus on communication between objects and the delegation of responsibilities.
The Command pattern is a behavioral design pattern that encapsulates a request as an object, enabling parameterization, queuing of requests, and support for undoable operations.
- **Key Concepts in Command Pattern:**
- Command Interface: Defines the method(s) to execute a command.
- Concrete Command: Implements the command interface, encapsulating the logic of the request.
- Invoker: Responsible for executing commands, typically through a queue or by invoking the execute method.

## Implementation
The Command pattern was implemented to manage functionalities such as vehicle creation, software updates, and other tasks while maintaining flexibility and decoupling the client from execution logic.
Firstly, I have created the interface `VehicleAdapter`, which defines the only method the client will use.
```java
public interface Command {
    void execute();
}
```
Further, I have created some Concrete Commands , which are `VehicleCreationCommand` and `UpdateSoftwareCommand`.
This two concrete commands are responsible for encapsulating the logic of creating each vehicle and consequently updating software of a certain vehicle.
```java
 public VehicleCreationCommand(VehicleCreationFacade facade, String type, String category) {
        this.facade = facade;
        this.type = type;
        this.category = category;
        }

@Override
public void execute() {
        switch (category.toLowerCase()) {
        case "car":
        createdVehicle = createCar();
        break;
        case "truck":
        createdVehicle = createTruck();
        break;
        case "motorcycle":
        createdVehicle = createMotorcycle();
        break;
default:
        throw new IllegalArgumentException("Unknown category: " + category);
        }
        System.out.println(type + " " + category + " created: " + createdVehicle);
        }
```     
Implementing this pattern, especially using `VehicleCreationCommand` class, the creation proccess becomes much easier.
It separates the request for creation from the details of how objects are instantiated and managed.
The client now can much easier create vehicles, without knowing exaclty which classes are involved.
The same was done for updating software.
```java
public class UpdateSoftwareCommand implements Command {
    private String vehicleName;

    public UpdateSoftwareCommand(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public void execute() {
        Vehicle vehicle = VehicleRegistry.getInstance().getVehicle(vehicleName);
        if (vehicle != null) {
            System.out.println("Updating software for " + vehicleName + ".");
            // Perform the update (example: simulate update process)
            System.out.println(vehicleName + " software update complete.");
        } else {
            System.out.println("Vehicle not found in registry.");
        }
    }
}
```
Here, the same execute method was overriden, just for a different purpose.
If the `VehicleCreationCommand` was created to show how the facade can interact with Vehicle in order to achieve an easier proccess of vehicle crreation,
`UpdateSoftwareCommand` was created to show how different command can be queued or scheduled.
Also, the client does not need to know how the update is performed, he just executes the method `execute` which is very useful for a complex system.
In order to show how these commands could be queued , I have created `VehicleCommandInvoker` class:
```java
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
        commandQueue.clear(); 
    }
}
```
This class is responsible for managing commands and executing when needed. It simplifies the execution process.
The client just adds the commands he need in order and then calls the function to execute them all.
This feature is very useful when working with a complex, big system. Also., any new command can be added to the invoker without changing teh system , which emphasize the Open/Close Principle.

```java
VehicleCreationFacade menu = new VehicleCreationFacade();

        VehicleCreationCommand createEconomyCar = new VehicleCreationCommand(menu, "economy", "car");
        VehicleCreationCommand createLuxuryTruck = new VehicleCreationCommand(menu, "luxury", "truck");
        UpdateSoftwareCommand softwareUpdateCommand = new UpdateSoftwareCommand("Toyota Corolla");

        VehicleCommandInvoker invoker = new VehicleCommandInvoker();

        invoker.addCommand(createEconomyCar);
        invoker.addCommand(createLuxuryTruck);
        invoker.addCommand(softwareUpdateCommand);

        invoker.executeCommands();
   ```



The client interacts with the command objects in a decoupled manner, without needing to know the specifics of how the tasks are executed. 
Instead, the client creates command objects, configures them with the necessary parameters, and passes them to the Invoker to execute the tasks. 
The client is only responsible for initiating the requests and does not handle the actual execution details.

## Conclusions

By using the Command pattern in the vehicle management system:

The command interface makes it easy to add new commands in a consistent way.
Concrete commands handle specific actions, keeping the client separate from the internal details.
The invoker manages and runs commands, allowing multiple actions to be processed at once or queued for later.
The system is easier to scale and maintain since new commands can be added without changing existing code.
Overall, these changes make the system more flexible, modular, and easier to expand with new features.