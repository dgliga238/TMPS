public class Toy {
    String name;
    boolean isAvailable;
    int price;

    public Toy(String name, int price){
        this.name = name;
        this.isAvailable = true;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

}
