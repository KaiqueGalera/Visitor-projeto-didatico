package produtos;

public class Alcoolico {
    private final double price;
    private final String name;

    public Alcoolico(double price, String name) {
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
