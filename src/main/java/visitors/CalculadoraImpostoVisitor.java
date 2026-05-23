package visitors;

import elements.Alcoolico;
import elements.Alimento;
import elements.Eletronico;

public class CalculadoraImpostoVisitor implements Visitor{
    @Override
    public void visit(Alimento alimento) {
        double imposto = alimento.getPrice() * 0.2;
        System.out.println("Valor do imposto no preço dos produtos alimenticios = " + imposto);
    }

    @Override
    public void visit(Eletronico eletronico) {
        double imposto = eletronico.getPrice() * 0.35;
        System.out.println("Valor do imposto no preço dos produtos eletronicos = " + imposto);
    }

    @Override
    public void visit(Alcoolico alcoolico) {
        double imposto = alcoolico.getPrice() * 0.5;
        System.out.println("Valor do imposto no preço dos produtos alcoolicos = " + imposto);
    }

}
