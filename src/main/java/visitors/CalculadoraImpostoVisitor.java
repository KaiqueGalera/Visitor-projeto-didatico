package visitors;

import elements.Alcoolicos;
import elements.Alimento;
import elements.Eletronico;
import elements.Livro;

public class CalculadoraImpostoVisitor implements Visitor{
    @Override
    public void visit(Livro livro) {
        double imposto = 0;
        System.out.println("Livro: isento de impostos = " + imposto);
    }

    @Override
    public void visit(Alimento alimento) {
        double imposto = alimento.getPrice() * 0.2;
        System.out.println("Alimentos: 20% de impostos = " + imposto);
    }

    @Override
    public void visit(Eletronico eletronico) {
        double imposto = eletronico.getPrice() * 0.35;
        System.out.println("Alimentos: 35% de impostos = " + imposto);
    }

    @Override
    public void visit(Alcoolicos alcoolicos) {
        double imposto = alcoolicos.getPrice() * 0.5;
        System.out.println("Alimentos: 59% de impostos = " + imposto);
    }

}
