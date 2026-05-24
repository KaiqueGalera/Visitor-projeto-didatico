package visitors;

import elements.AlcoolicoImpl;
import elements.AlimentoImpl;
import elements.EletronicoImpl;

public class DescontoVisitorImpl implements VisitorI {
    @Override
    public void visit(AlimentoImpl alimento) {
        double desconto = alimento.getPrice() * 0.35;
        System.out.println("Valor do desconto para produtos alimenticios = " + desconto);
    }

    @Override
    public void visit(AlcoolicoImpl alcoolico) {
        double desconto = alcoolico.getPrice() * 0.1;
        System.out.println("Valor do desconto para produtos alcoolicos = " + desconto);
    }

    @Override
    public void visit(EletronicoImpl eletronico) {
        double desconto = eletronico.getPrice() * 0.1;
        System.out.println("Valor do desconto para produtos eletronicos = " + desconto);
    }
}
