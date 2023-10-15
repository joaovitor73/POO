package org.example.dominio;

public class C5 extends C2 implements I1{
    public void somar(int a, int b){
        super.setResultado(a+b);
    }

    public void somar(String a, String b){
       setResultado(Integer.parseInt(a) + Integer.parseInt(b));
    }

    //sobreposição
    public int setResultado(int a, int b){
        return a-b;
    }
}
