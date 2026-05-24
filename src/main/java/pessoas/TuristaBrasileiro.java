package pessoas;

public class TuristaBrasileiro implements Pessoa {
    private final double price;
    private final String name;

    public TuristaBrasileiro(double price, String name) {
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
        return price * 0.35;
    }
}
