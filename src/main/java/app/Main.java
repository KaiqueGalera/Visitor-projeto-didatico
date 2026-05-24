package app;


import pessoas.TuristaBrasileiro;
import pessoas.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa smartwatch = new TuristaBrasileiro(299, "smartwatch");

        System.out.println(smartwatch.calculateImposto());
        }
    }
