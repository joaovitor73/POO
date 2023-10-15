package org.example.visao;

import org.example.aplicacao.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calculadora c1 = new Calculadora();
        CalculadoraMelhorada cm1 = new CalculadoraMelhorada();
        int op, op2;
        float operando1 = 0, operando2 = 0;
        do {
            System.out.println("1 - Calculadora simples");
            System.out.println("2 - Calculadora melhorada");
            System.out.println("3 - Sair");
            op = teclado.nextInt();
            switch (op){
                case 1:
                    System.out.println("1 - Somar");
                    System.out.println("2 - Subtrair");
                    System.out.println("3 - Multiplicar");
                    System.out.println("4 - Divir");

                    System.out.println("Digite o valor do primeiro operando: ");
                    operando1 = teclado.nextInt();
                    System.out.println("Digite o valor do segundo operando: ");
                    operando2 = teclado.nextInt();

                    op2 = teclado.nextInt();
                    switch(op2){
                        case 1:
                            System.out.println(operando1 + " + " + operando2 + " = " + c1.calcular(1,operando1, operando2));
                            break;
                        case 2:
                            System.out.println(operando1 + " - " + operando2 + " = " + c1.calcular(2,operando1, operando2));
                            break;
                        case 3:
                            System.out.println(operando1 + " * " + operando2 + " = " + c1.calcular(3,operando1, operando2));
                            break;
                        case 4:
                            System.out.println(operando1 + "  / " + operando2 + " = "  + c1.calcular(4,operando1, operando2));
                            break;
                        default:
                            System.out.println("Erro ao digitar, tente novamente!!");
                    }
                    break;
                case 2:
                    System.out.println("1 - Somar");
                    System.out.println("2 - Subtrair");
                    System.out.println("3 - Multiplicar");
                    System.out.println("4 - Divir");
                    System.out.println("5 - Potência");
                    System.out.println("6 - Última operação");
                    op2 = teclado.nextInt();
                    if(op2 != 6){
                        System.out.println("Digite o valor do primeiro operando: ");
                        operando1 = teclado.nextInt();
                        System.out.println("Digite o valor do segundo operando: ");
                        operando2 = teclado.nextInt();
                    }
                    switch(op2){
                        case 1:
                            System.out.println(operando1 + " + " + operando2 + " = " + cm1.calcular(1,operando1, operando2));
                            break;
                        case 2:
                            System.out.println(operando1 + " - " + operando2 + " = " + cm1.calcular(2,operando1, operando2));
                            break;
                        case 3:
                            System.out.println(operando1 + " * " + operando2 + " = " + cm1.calcular(3,operando1, operando2));
                            break;
                        case 4:
                            System.out.println(operando1 + "  / "  + operando2 + " = "  + cm1.calcular(4,operando1, operando2));
                            break;
                        case 5:
                            System.out.println(operando1 + "  ^  "  + operando2 + " = "  + cm1.calcular(5,operando1, operando2));
                            break;
                        case 6:
                            System.out.println("Ultima operação: " + cm1.verUltimaOperacao() + "\n");
                            break;
                        default:
                            System.out.println("Erro ao digitar, tente novamente!!");
                    }
                    break;
                case 3:
                    System.out.println("Saindo!!");
                    break;
                default:
                    System.out.println("Erro ao digitar, tente novamente!!");
            }


        }  while(op != 3);
    }
}