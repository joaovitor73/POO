package org.example.dominio;

public abstract class Imovel {
    private String cor;

    public void pinta(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return this.cor;
    }

    public abstract int quantasPortasEstaoAbertas();
}
