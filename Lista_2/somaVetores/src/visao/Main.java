package visao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //vetor
        int a[] = new int[2];
        int b[] = new int[2];
        int c[] = new int[2];

        int sumA = 0 , sumAandB = 0, i, aux;

        Scanner teclado = new Scanner(System.in);
        for(i = 0; i < 2; i++){
            System.out.println("Digite o " + (i+1) + "o. elemento do vetor A: ");
            a[i] = teclado.nextInt();
            sumA += a[i];
            System.out.println("Digite o " + (i+1) + "o. elemento do vetor B: ");
            b[i] = teclado.nextInt();
            c[i] = a[i] + b[i];
        }
        System.out.println("Soma dos elementos de A: " + sumA);
        System.out.println("Vetor C: ");
        for(i = 0; i < 2; i++){
            System.out.print(c[i] + " ");
        }

        //array
        ArrayList A = new ArrayList();
        ArrayList B = new ArrayList();
        ArrayList C = new ArrayList();

        sumA = 0;
        i = 0;
        char sair = 'N';
        System.out.println();
        do{

            System.out.println("Digite o " + (i+1) + "o. elemento do vetor A: ");
            A.add(teclado.nextInt());
            System.out.println("Digite o " + (i+1) + "o. elemento do vetor B: ");
            B.add(teclado.nextInt());
            i++;
            System.out.println("Deseja sair(S - sim): ");
            sair = teclado.next().charAt(0);
        }while(sair != 'S');

        for(i = 0; i < A.size(); i++){
            sumA += (int) A.get(i);
            C.add(((int)A.get(i))+ ((int)B.get(i)));
        }

        System.out.println("Soma dos elementos de A: " + sumA);
        System.out.println("Vetor C: ");
        for(i = 0; i < C.size(); i++){
            System.out.print(C.get(i) + " ");
        }
    }
}