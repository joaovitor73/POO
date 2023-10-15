package org.example.dominio;

public class C2 extends C1{
    private int resultado;
    private int a;
    private int b;

    public C2(){

    }

    public C2(int a, int b){
        this.a = a;
        this.b = b;
        this.resultado = 0;
    }
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
