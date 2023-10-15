package org.example.dominio;

import java.util.ArrayList;

public class Edificio extends Imovel{
    private int totalPortas;
    private int totalAndares;
    private ArrayList<Porta> portas;

    public Edificio(){
        this.portas = new ArrayList<Porta>();
        this.totalAndares = 0;
    }

    public ArrayList<Porta> getPortas(){
        return this.portas;
    }

    public int quantasPortasEstaoAbertas(){
        int cont = 0;
        for(Porta p : portas)
            if(p.estaAberta()) cont++;
        return cont;
    }

    public void adicionarPorta(Porta p){
        portas.add(p);
        totalPortas = portas.size();
    }

    public int totalPortas(){
        return this.totalPortas;
    }

    public void adicionarAndares(){
        this.totalAndares++;
    }

    public int totalAndares(){
        return this.totalAndares;
    }
}
