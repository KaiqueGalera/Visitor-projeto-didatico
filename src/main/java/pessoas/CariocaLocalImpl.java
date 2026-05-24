package pessoas;

import visitante.VisitanteI;

public class CariocaLocalImpl implements PessoaI {
    private final double price;
    private final String name;

    public CariocaLocalImpl(double price, String name) {
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
    public void aceitarVisitante(VisitanteI v) {
        v.visita(this);
    }
}
