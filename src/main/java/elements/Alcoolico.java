package elements;

import visitors.Visitor;

public class Alcoolico implements Produto {
    private final double price;
    private final String name;

    public Alcoolico(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void aceitar(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
