package app;


import produtos.Eletronico;
import produtos.ProdutoI;

public class Main {
    public static void main(String[] args) {
        ProdutoI smartwatch = new Eletronico(299, "smartwatch");

        System.out.println(smartwatch.calculateImposto());
        }
    }
