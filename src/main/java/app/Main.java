package app;

import elements.AlimentoImpl;
import elements.EletronicoImpl;
import elements.ProdutoI;
import visitors.CalculadoraImpostoVisitorImpl;
import visitors.VisitorI;


public class Main {
    public static void main(String[] args) {
        ProdutoI arroz = new AlimentoImpl(100, "Arroz");
        ProdutoI notebook = new EletronicoImpl(5000, "notebook");

        VisitorI imposto = new CalculadoraImpostoVisitorImpl();

        arroz.aceitar(imposto);
        notebook.aceitar(imposto);
        }
    }
