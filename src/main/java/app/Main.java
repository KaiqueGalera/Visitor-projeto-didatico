package app;


import produtos.Eletronico;
import produtos.Produto;

public class Main {
    public static void main(String[] args) {
        Produto smartwatch = new Eletronico(299, "smartwatch");

        System.out.println(smartwatch.calculateImposto());
        }
    }
