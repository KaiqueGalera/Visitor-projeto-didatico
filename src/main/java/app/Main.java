package app;

import elements.Eletronico;
import elements.Livro;
import elements.Produto;
import visitors.CalculadoraImpostoVisitor;
import visitors.Visitor;


public class Main {
    public static void main(String[] args) {
        Produto livro = new Livro(100, "Livro - 1");
        Produto notebook = new Eletronico(5000, "Livro - 2");

        Visitor imposto = new CalculadoraImpostoVisitor();

        livro.aceitar(imposto);
        notebook.aceitar(imposto);
        }
    }
