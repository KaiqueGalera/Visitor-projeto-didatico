package visitors;

import elements.AlcoolicoImpl;
import elements.AlimentoImpl;
import elements.EletronicoImpl;

public class CalculadoraFreteVisitorImpl implements VisitorI {
    @Override
    public void visit(AlimentoImpl alimento) {
        double frete = 20;
        System.out.println("Valor do frete para alimentos = " + frete);
    }

    @Override
    public void visit(EletronicoImpl eletronico) {
        double frete = 50;
        System.out.println("Valor do frete para eletronicos = " + frete);
    }

    @Override
    public void visit(AlcoolicoImpl alcoolico) {
        double frete = 15;
        System.out.println("Valor do frete para alcoolicos = " + frete);
    }

}
