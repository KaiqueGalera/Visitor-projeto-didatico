package elements;

import visitors.Visitor;

public class Eletronico implements Produto {
    private final double price;
    private final String name;

    public Eletronico(double price, String name) {
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
