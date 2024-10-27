
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        SellService sellService = new SellService(inventory);

        Toy toy1 = new Toy("bear", 20);
        Toy toy2 = new Toy("car", 50);
        Toy toy3 = new Toy("doll", 100);
        Toy toy4 = new Toy("bird", 30);

        inventory.addToy(toy1);
        inventory.addToy(toy2);
        inventory.addToy(toy3);
        inventory.addToy(toy4);
        inventory.displayAllToys();

        sellService.buyToy(toy2);
        sellService.getDiscount(toy1);

        RegularCustomer first = new RegularCustomer(sellService);
        first.buyToy(toy2);

        inventory.removeToy(toy2);
        inventory.displayAllToys();

        PermanentCustomer second = new PermanentCustomer(sellService);
        second.buyToy(toy3);
        second.getDiscount(toy3);
    }
}