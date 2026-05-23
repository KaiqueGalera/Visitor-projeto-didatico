package app;

import elements.Alimento;
import elements.Eletronico;
import elements.Produto;
import visitors.CalculadoraImpostoVisitor;
import visitors.Visitor;


public class Main {
    public static void main(String[] args) {
        Produto arroz = new Alimento(100, "Arroz");
        Produto notebook = new Eletronico(5000, "notebook");

        Visitor imposto = new CalculadoraImpostoVisitor();

        arroz.aceitar(imposto);
        notebook.aceitar(imposto);
        }
    }
