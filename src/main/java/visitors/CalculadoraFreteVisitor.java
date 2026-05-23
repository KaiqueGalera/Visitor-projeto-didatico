package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;
import elements.Livro;

public class CalculadoraFreteVisitor implements Visitor {
    @Override
    public void visit(Alimento alimento) {
        double frete = 20;
        System.out.println("Valor do frete para alimentos = " + frete);
    }

    @Override
    public void visit(Eletronico eletronico) {
        double frete = 50;
        System.out.println("Valor do frete para eletronicos = " + frete);
    }

    @Override
    public void visit(Alcoolico alcoolico) {
        double frete = 15;
        System.out.println("Valor do frete para alcoolicos = " + frete);
    }

}
