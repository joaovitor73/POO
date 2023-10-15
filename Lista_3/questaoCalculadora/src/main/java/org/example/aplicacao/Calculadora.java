package org.example.aplicacao;

public class Calculadora {
    private float operando1;
    private float operando2;
    private char operador;
    private float resultado;

    public Calculadora(){
        this.operando1 = 0;
        this.operando2 = 0;
        this.operador=' ';
    }

    public float calcular(int operador, float operando1, float operando2){
        this.operando1 = operando1;
        this.operando2 = operando2;
        if(operador == 1) somar();
        else if(operador == 2) subtrair();
        else if(operador == 3) multiplicar();
        else dividir();
        return this.resultado;
    }

    private void somar(){
        resultado = operando1+operando2;
    }

    private void subtrair(){
        resultado = operando1-operando2;
    }

    private void multiplicar(){
        resultado = operando1*operando2;
    }

    private void dividir(){
        if(operando2 != 0)
            resultado = operando1/operando2;
        else resultado = 0;
    }
}
