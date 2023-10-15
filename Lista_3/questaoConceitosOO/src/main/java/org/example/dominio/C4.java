package org.example.dominio;

public class C4 extends C2{
    private int anoFabricacao;

    public C4(){

    }

    public C4(int ano){
        this.anoFabricacao = ano;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
