package org.example.aplicacao;
import java.lang.Math;
public class CalculadoraMelhorada extends Calculadora{
    private String memoria;

    public CalculadoraMelhorada(){
        this.memoria = "";
    }

    private void nomeOperacao(int operador){
        switch (operador){
            case 1: memoria = "Soma";
                break;
            case 2: memoria = "Subtração";
                break;
            case 3: memoria = "Multiplicação";
                break;
            case 4: memoria = "Divisão";
                break;
            case 5: memoria = "Potencia";
                break;
        }
    }
    //Usei sobreposição no lugar da sobrecarga para forçar apenas o método calcular sendo público na classe calculadora
    public float calcular(int operador, float operando1, float operando2){
        this.nomeOperacao(operador);
        if(operador == 5)
            return (float) this.potencia(operando1, operando2);
        else
            return super.calcular(operador, operando1, operando2);
    }

    public String verUltimaOperacao(){
        return this.memoria;
    }

    private double potencia(float operando1, float operando2){
        return Math.pow(operando1,operando2);
    }
}


