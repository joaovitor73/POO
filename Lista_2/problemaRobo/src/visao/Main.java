package visao;

import aplicacao.Robo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Robo r = new Robo(1);
        char sala[][] = new char[20][40];
        int posi[] = new int[2];
        Scanner input = new Scanner(System.in);
        int op;

        while(true) {
            /*
            System.out.println("----------------------");
            System.out.println("1 - Andar para frente");
            System.out.println("2 - Andar para trás");
            System.out.println("3 - Andar para esquerda");
            System.out.println("4 - Andar para direita");
            System.out.println("5 - alterar passo");
            System.out.println("----------------------");
            */
            op = input.nextInt();

            switch (op){
                case 1: r.andarFrente();
                    break;
                case 2: r.andarTras();
                    break;
                case 3: r.andarEsquerda();
                    break;
                case 4: r.andarDireita();
                    break;
                case 5:
                    System.out.println("Digite o valor do novo passo: ");
                    r.setPasso(input.nextInt());
                    break;
                default:
            }
            //System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("-----------------------------------------");
            posi = r.mostrarPosicaoAtual();
            sala[posi[0]][posi[1]] = '1';
            for(int i = 0; i < sala.length; i++){
                for(int j = 0; j < sala[0].length;j++){
                    if(sala[i][j] != '1')
                        System.out.print(" ");
                    else System.out.print("1");
                }
                System.out.println();
            }
            sala[posi[0]][posi[1]] = ' ';
            System.out.println("-----------------------------------------");
        }

    }
}