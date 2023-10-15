package org.example.visao;

import org.example.dominio.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Porta p1 = new Porta();

        p1.pinta("Verde");
        p1.setDimensaoX(10);
        p1.setDimensaoY(20);
        p1.setDimensaoZ(2);
        System.out.println("A porta está aberta: " + p1.estaAberta());
        p1.abre();
        System.out.println("A porta está aberta: " + p1.estaAberta());
        System.out.println("Cor da porta: " + p1.getCor());
        System.out.println("Largura da porta: " + p1.getDimensaoX());
        System.out.println("Altura da porta: " + p1.getDimensaoY());
        System.out.println("Espessura da porta: " + p1.getDimensaoZ());

        System.out.println();
        Casa c1 = new Casa();
        c1.pinta("Vermelho");
        System.out.println("Cor da casa: " + c1.getCor());
        //Colando duas portas iguais e abertas na casa vermelha
        c1.setPorta1(p1);
        c1.setPorta2(p1);
        System.out.println("A porta está aberta: " + c1.getPorta1().estaAberta());
        System.out.println("Cor da porta: " + c1.getPorta1().getCor());
        System.out.println("Largura da porta: " + c1.getPorta1().getDimensaoX());
        System.out.println("Altura da porta: " + c1.getPorta1().getDimensaoY());
        System.out.println("Espessura da porta: " + c1.getPorta1().getDimensaoZ());
        System.out.println("Quantas portas estão abertas: " + c1.quantasPortasEstaoAbertas());

        System.out.println();
        Edificio e1 = new Edificio();
        e1.pinta("Azul");
        System.out.println("Cor da casa: " + e1.getCor());
        System.out.println("Quantas portas estão abertas: " + e1.quantasPortasEstaoAbertas());
        System.out.println("Total de portas do prédio: " + e1.totalPortas());
        System.out.println("Quantidade de andares do prédio: " + e1.totalAndares());
        //Adicionando duas portas igauis ao predio
        e1.adicionarPorta(p1);
        e1.adicionarPorta(p1);
        System.out.println("Quantas portas estão abertas: " + e1.quantasPortasEstaoAbertas());
        System.out.println("Total de portas do prédio: " + e1.totalPortas());
        e1.adicionarAndares();
        System.out.println("Quantidade de andares do prédio: " + e1.totalAndares());
        ArrayList<Porta> portas = e1.getPortas();
        for(Porta p : portas){
            System.out.println("A porta está aberta: " + p.estaAberta());
            System.out.println("Cor da porta: " + p.getCor());
            System.out.println("Largura da porta: " +p.getDimensaoX());
            System.out.println("Altura da porta: " + p.getDimensaoY());
            System.out.println("Espessura da porta: " + p.getDimensaoZ());
        }
    }
}