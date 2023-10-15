package org.example.dominio;

public abstract class C1 {
    private String cor;
    private float tamanho;
    public String getCor(){
        return this.cor;
    }

    public float getTamanho(){
        return this.tamanho;
    }

    public void setCor(String cor){
        this.cor =  cor;
    }

    public void setTamanho(float tamanho){
        this.tamanho = tamanho;
    }


}
