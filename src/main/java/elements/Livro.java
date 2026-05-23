package elements;

import visitors.Visitor;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Livro implements Produto {
    private double price;
    private String name;

    public Livro(double price, String name) {
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
