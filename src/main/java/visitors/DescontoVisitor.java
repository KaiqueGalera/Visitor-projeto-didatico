package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public class DescontoVisitor implements Visitor {
    @Override
    public void visit(Alimento alimento) {
        double desconto = alimento.getPrice() * 0.35;
        System.out.println("Valor do desconto para produtos alimenticios = " + desconto);
    }

    @Override
    public void visit(Alcoolico alcoolico) {
        double desconto = alcoolico.getPrice() * 0.1;
        System.out.println("Valor do desconto para produtos alcoolicos = " + desconto);
    }

    @Override
    public void visit(Eletronico eletronico) {
        double desconto = eletronico.getPrice() * 0.1;
        System.out.println("Valor do desconto para produtos eletronicos = " + desconto);
    }
}
