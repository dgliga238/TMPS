import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Toy> toys = new ArrayList<>();

    public  void addToy(Toy toy){
        toys.add(toy);
        System.out.println(("Toy " + toy.getName() + " added. " + "It costs " + toy.getPrice()));
    }

    public void removeToy(Toy toy){
        toys.remove(toy);
        System.out.println("Toy " + toy.getName() + " was sold");
    }

    public List<Toy> displayAllToys(){
        return toys;
    }
}
