package elements;

import visitors.VisitorI;

public class AlcoolicoImpl implements ProdutoI {
    private final double price;
    private final String name;

    public AlcoolicoImpl(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void aceitar(VisitorI visitor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
