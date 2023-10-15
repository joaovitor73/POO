package org.example.visao;

import org.example.dominio.*;

public class Main {
    public static void main(String[] args) {
        //objetos c1 não pode ser instanciado(Pode ter método vazio)
        //C1 c1 = new C1();
        C2 c2 = new C2();
        System.out.println("A: " + c2.getA());
        System.out.println("B: " + c2.getB());
        C2 c22 = new C2(10,5);
        System.out.println("A: " + c22.getA());
        System.out.println("B: " + c22.getB());

        System.out.println();
        C4 c4 = new C4(2000);
        C4 c44 = new C4();
        System.out.println("Ano fabricação: " + c4.getAnoFabricacao());
        System.out.println("Ano fabricação: " + c44.getAnoFabricacao());
        c4.setA(2);
        c44.setA(4);
        System.out.println("A: " + c44.getA());
        System.out.println("A: " + c4.getA());

        System.out.println();
        C5 c5 = new C5();
        c5.setA(10);
        c5.setB(5);
        System.out.println("A: " + c5.getA());
        System.out.println("B: " + c5.getB());
        System.out.println("Resultado: " + c5.setResultado(2,4));

        System.out.println();
        C3 c3 = new C3();
        System.out.println("Ligado: " + c3.ligado());
        c3.ligar();
        System.out.println("Ligado: " + c3.ligado());
    }
}