public class SellService implements IPay, IGetDiscount{

private Inventory inventory;

public SellService(Inventory inventory){
    this.inventory =inventory;
}

    @Override
    public boolean getDiscount(Toy toy) {
        toy.price = toy.getPrice() / 2;
        System.out.println("Toy " + toy.getName() + " costs " + toy.price);
        return  true;
    }

    @Override
    public boolean buyToy(Toy toy) {
        if(toy.isAvailable()){
            System.out.println("Toy " + toy.getName() + "costs " + toy.getPrice());
            return true;
        }
        System.out.println("Unavailable toy");
        return false;
    }
}
