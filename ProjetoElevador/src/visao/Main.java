package visao;

import aplicacao.Elevador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Elevador e1 = new Elevador();
        e1.inicializa(2,5);
        int opcao;
        do{
            System.out.println("----------------");
            System.out.println("\tMENU PRINCIPAL");
            System.out.println("----------------");
            System.out.println("1 - Entrar");
            System.out.println("2 - Sair");
            System.out.println("3 - Subir");
            System.out.println("4 - Descer");
            System.out.println("5 - Sair do menu");
            System.out.printf(": ");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    if (e1.entra())
                        System.out.println("Entrou");
                    else
                        System.out.println("Elevador cheio!!");
                    break;
                case 2:
                    if (e1.sair())
                        System.out.println("Saindo");
                    else
                        System.out.println("Elevador vazio!!");
                    break;
                case 3:
                    if (e1.sobe())
                        System.out.println("Subindo");
                    else
                        System.out.println("Ultimo andar");
                    break;
                case 4:
                    if (e1.desce())
                        System.out.println("Saindo");
                    else
                        System.out.println("Terreo");
                    break;
                case 5:
                    System.out.println("Saindoooo");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }while (opcao != 5);
    }
}