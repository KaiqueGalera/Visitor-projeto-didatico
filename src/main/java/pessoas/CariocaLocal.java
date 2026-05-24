package pessoas;

public class CariocaLocal implements Pessoa {
    private final double price;
    private final String name;

    public CariocaLocal(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public double calculateImposto() {
        return price * 0.2;
    }
}
