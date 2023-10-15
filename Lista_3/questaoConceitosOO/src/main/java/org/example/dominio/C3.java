package org.example.dominio;

public class C3 extends C1 implements I1, I2{
    private boolean ligado;

    public C3(){
        this.ligado = false;
    }
    public void somar(int a, int b){

    }

    public boolean ligado(){
        return this.ligado;
    }

    public void ligar(){
        this.ligado = true;
    }
}
