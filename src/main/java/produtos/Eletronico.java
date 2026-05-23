package produtos;

public class Eletronico  {
    private final double price;
    private final String name;

    public Eletronico(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
