package app;


import pessoas.TuristaBrasileiroImpl;
import pessoas.PessoaI;

public class Main {
    public static void main(String[] args) {
        PessoaI smartwatch = new TuristaBrasileiroImpl(299, "smartwatch");

        System.out.println(smartwatch.calculateImposto());
        }
    }
