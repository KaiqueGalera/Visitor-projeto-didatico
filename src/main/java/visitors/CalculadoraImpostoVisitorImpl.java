package visitors;

import elements.AlcoolicoImpl;
import elements.AlimentoImpl;
import elements.EletronicoImpl;

public class CalculadoraImpostoVisitorImpl implements VisitorI {
    @Override
    public void visit(AlimentoImpl alimento) {
        double imposto = alimento.getPrice() * 0.2;
        System.out.println("Valor do imposto no preço dos produtos alimenticios = " + imposto);
    }

    @Override
    public void visit(EletronicoImpl eletronico) {
        double imposto = eletronico.getPrice() * 0.35;
        System.out.println("Valor do imposto no preço dos produtos eletronicos = " + imposto);
    }

    @Override
    public void visit(AlcoolicoImpl alcoolico) {
        double imposto = alcoolico.getPrice() * 0.5;
        System.out.println("Valor do imposto no preço dos produtos alcoolicos = " + imposto);
    }

}
