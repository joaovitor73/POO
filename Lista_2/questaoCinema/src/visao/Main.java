package visao;

import aplicacao.Ingresso;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Ingresso> sala = new ArrayList<Ingresso>();
        Ingresso in;
        Scanner input = new Scanner(System.in);
        int sa[] = new int[120];
        int op, cod = 1, entrada, cont, codAux;
        boolean flag;
        String cpf = null,nomeFil;

        for (int i = 0; i < sa.length; i++) sa[i] = i+1;

        System.out.println("Digite o nome do filme: ");
        nomeFil = input.nextLine();

        while (true) {
            in = new Ingresso();
            System.out.println("------------------------------");
            System.out.println("1 - Comprar ingresso");
            System.out.println("2 - Desistir do ingresso");
            System.out.println("------------------------------");
            op = input.nextInt();
            input.nextLine();
            if(op == 1) {
                in.setCodigo(cod);
                System.out.println("Digite o seu CPF: ");
                cpf = input.nextLine();
                flag = true;
                for(int i = 0; i < sala.size();i++){
                    if(sala.get(i).getCpf().equals(cpf)) flag = false;
                }
                if (flag) {
                    in.setCpf(cpf);
                    in.setNomeFilme(nomeFil);
                    System.out.println("Poltronas disponíveis: \n");
                    System.out.println("-------------------------------------------------------------------------------------------");
                    for (int i = 0; i < sa.length; i++) {
                        if ((i % 12 == 0) && (i != 0)) System.out.println();
                        System.out.print(sa[i] + "\t\t");
                    }
                    System.out.println("\n-------------------------------------------------------------------------------------------\n");
                    flag = false;
                    do {
                        if (flag) System.out.println("Poltrona ocupada, escolha outra\n");
                        do {
                            System.out.println("Digite o número da poltrona disponível: ");
                            in.setNumeroPoltrona(input.nextInt());
                        }while(in.getNumeroPoltrona() > 120 || in.getNumeroPoltrona() < 1);
                        flag = true;
                    } while (sa[in.getNumeroPoltrona() - 1] == 0);
                    sa[in.getNumeroPoltrona() - 1] = 0;
                    do {
                        System.out.println("1 - Meia e 2 - Inteira");
                        entrada = input.nextInt();
                    } while ((entrada != 1) && (entrada != 2));
                    in.Preco(entrada);
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("------------------------------");
                    System.out.println("\t\t\tINGRESO");
                    System.out.println("Código: " + in.getCodigo());
                    System.out.println("Filme: " + in.getNomeFilme());
                    System.out.println("CPF: " + in.getCpf());
                    System.out.println("Preço: " + in.getPreco());
                    System.out.println("Número da poltrona: " + in.getNumeroPoltrona());
                    cod = in.getCodigo()+ 1;
                    sala.add(in);
                } else System.out.println("Esse CPF já comprou ingresso, só pode um por usuário");
            }else if(op == 2){
                System.out.println("Digite o seu CPF: ");
                cpf = input.nextLine();
                System.out.println("Digite o código do seu ingresso: ");
                codAux = input.nextInt();
                cont = 0;
                flag = false;
                while(cont < sala.size()){
                    if(sala.get(cont).getCpf().equals(cpf)){
                        if(sala.get(cont).getCodigo() == codAux){
                            sa[cont] = sala.get(cont).getNumeroPoltrona();
                            sala.remove(cont);
                            cont = sala.size();
                            flag = true;
                        }
                    }
                    cont++;
                }
                if(flag) System.out.println("Operação realizada com sucesso!");
                else System.out.println("Ingresso com esses dados não foi encontrado!");
            }else System.out.println("Não entendi, digite novamente!");
        }
    }
}