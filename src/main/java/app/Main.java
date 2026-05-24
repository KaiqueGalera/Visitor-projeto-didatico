package app;

import elements.Alimento;
import elements.Eletronico;
import elements.ProdutoI;
import visitors.CalculadoraImpostoVisitorImpl;
import visitors.VisitorI;


public class Main {
    public static void main(String[] args) {
        ProdutoI arroz = new Alimento(100, "Arroz");
        ProdutoI notebook = new Eletronico(5000, "notebook");

        VisitorI imposto = new CalculadoraImpostoVisitorImpl();

        arroz.aceitar(imposto);
        notebook.aceitar(imposto);
        }
    }
