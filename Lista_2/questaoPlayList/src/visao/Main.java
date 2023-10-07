package visao;

import aplicacao.Musica;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Musica> playList = new ArrayList<Musica>();
        Musica m;
        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();
        int op, duracaoTot, min, seg, indeceObj;
        String duracao, nome, cantor;
        boolean flag;
        do {
            System.out.println("------------------------------------------------------------");
            System.out.println("\t\tPLAYLIST");
            System.out.println("------------------------------------------------------------");
            System.out.println("1 – Adicionar uma música");
            System.out.println("2 – Excluir uma música");
            System.out.println("3 – Tocar uma música específica (pelo título)");
            System.out.println("4 – Tocar as músicas de um cantor");
            System.out.println("5 – Tocar as músicas em sequência");
            System.out.println("6 – Tocar as músicas embaralhadas (random)");
            System.out.println("7 – Ver as músicas da playlist");
            System.out.println("8 – Sair");
            System.out.println("------------------------------------------------------------");
            op = teclado.nextInt();
            teclado.nextLine();
            switch(op){
                case 1:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("\t\tADICIONAR MÚSICAS");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Digite o nome da música: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite o nome do cantor: ");
                    cantor = teclado.nextLine();
                    flag = true;

                    for(int i = 0; i < playList.size();i++){
                        if(playList.get(i).getCantor().equals(cantor) && playList.get(i).getNome().equals(nome)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        System.out.println("Digite a duração da música(min:seg): ");
                        duracao = teclado.nextLine();
                        duracaoTot = (Integer.parseInt(duracao.split(":")[0]))*60;
                        duracaoTot += Integer.parseInt(duracao.split(":")[1]);
                        m = new Musica(duracaoTot, nome, cantor);
                        playList.add(m);
                        System.out.println("Música cadastrada com sucesso!");
                    }else
                        System.out.println("Música já existente na playList!");
                    break;
                case 2:
                    if(!playList.isEmpty()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\t\tEXCLUIR MÚSICA");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Digite o nome da música: ");
                        nome = teclado.nextLine();
                        System.out.println("Digite o nome do cantor: ");
                        cantor = teclado.nextLine();
                        flag = false;
                        for(int i = 0; i < playList.size();i++){
                            if(playList.get(i).getCantor().equals(cantor) && playList.get(i).getNome().equals(nome)){
                                playList.remove(playList.get(i));
                                flag = true;
                                break;
                            }
                        }
                        if(flag) System.out.println("Música removida com sucesso!");
                        else System.out.println("Música não encontrada!");
                    }else
                        System.out.println("PlayList vazia!");
                    break;
                case 3:
                    if(!playList.isEmpty()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\t\tTOCAR MÚSICAS COM NOMES IGUAIS");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Digite o nome da música: ");
                        nome = teclado.nextLine();
                        flag = true;
                        for(int i = 0; i < playList.size();i++) {
                            if (playList.get(i).getNome().equals(nome)) {
                                flag = false;
                                for (int cont = playList.get(i).getDuracaoTot(); cont >= 0; cont--) {
                                   min = cont/60;
                                   seg = cont%60;
                                    try {
                                        Thread.sleep(1000); // pausa de 1 seg
                                    } catch (InterruptedException e) {
                                        System.out.println("Erro na execução da música: " + e.getMessage());
                                    }
                                    System.out.print("\r "+playList.get(i).getNome() + "\t\t\t " + min + ":" + seg);

                                }
                            }
                        }
                        if(flag) System.out.println("Música com o nome digitado não foi encontrada!");
                        else System.out.println();
                    }else
                        System.out.println("PlayList vazia!");
                    break;
                case 4:
                    if(!playList.isEmpty()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\t\tTOCAR MÚSICAS DO MESMO CANTOR");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Digite o nome do cantor: ");
                        cantor = teclado.nextLine();
                        flag = true;
                        for(int i = 0; i < playList.size();i++) {
                            if (playList.get(i).getCantor().equals(cantor)) {
                                flag = false;
                                for (int cont = playList.get(i).getDuracaoTot(); cont >= 0; cont--) {
                                    min = cont/60;
                                    seg = cont%60;
                                    try {
                                        Thread.sleep(1000); // pausa de 1 seg
                                    } catch (InterruptedException e) {
                                        System.out.println("Erro na execução da música: " + e.getMessage());
                                    }
                                    System.out.print("\r "+playList.get(i).getNome() + "\t\t\t " + min + ":" + seg);

                                }
                            }
                        }
                        if(flag) System.out.println("Música do cantor digitado não foi encontrada!");
                        else System.out.println();
                    }else
                        System.out.println("PlayList vazia!");
                    break;
                case 5:
                    if(!playList.isEmpty()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\t\tTOCAR MÚSICAS EM SEQUÊNCIA");
                        System.out.println("------------------------------------------------------------");
                        for(int i = 0; i < playList.size();i++) {
                            for (int cont = playList.get(i).getDuracaoTot(); cont >= 0; cont--) {
                                min = cont / 60;
                                seg = cont % 60;
                                try {
                                    Thread.sleep(1000); // pausa de 1 seg
                                } catch (InterruptedException e) {
                                    System.out.println("Erro na execução da música: " + e.getMessage());
                                }
                                System.out.print("\r " + playList.get(i).getNome() + "\t\t\t " + min + ":" + seg);

                            }
                        }
                        System.out.println();
                    }else
                        System.out.println("PlayList vazia!");
                    break;
                case 6:
                    if(!playList.isEmpty()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\t\tTOCAR MÚSICAS EM ORDEM ALEATÓRIA");
                        System.out.println("------------------------------------------------------------");
                        for(int i = 0; i < playList.size();i++) {
                            //Pegando objetos aleatórios com o gerador
                            indeceObj = gerador.nextInt(playList.size());
                            for (int cont = playList.get(indeceObj).getDuracaoTot(); cont >= 0; cont--) {
                                min = cont / 60;
                                seg = cont % 60;
                                try {
                                    Thread.sleep(1000); // pausa de 1 seg
                                } catch (InterruptedException e) {
                                    System.out.println("Erro na execução da música: " + e.getMessage());
                                }
                                System.out.print("\r " + playList.get(indeceObj).getNome() + "\t\t\t " + min + ":" + seg);

                            }
                        }
                        System.out.println();
                    }else
                        System.out.println("PlayList vazia!");
                    break;
                case 7:
                    if(!playList.isEmpty()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\t\tLISTA DE MÚSICAS");
                        System.out.println("------------------------------------------------------------");
                        for(int i = 0; i < playList.size();i++) {
                            System.out.println("Título: " + playList.get(i).getNome());
                            System.out.println("Cantor: " + playList.get(i).getCantor());
                            min = playList.get(i).getDuracaoTot()/60;
                            seg = playList.get(i).getDuracaoTot()%60;
                            System.out.println("Duração: " + min + ":" + seg);
                        }
                        System.out.println();
                    }else
                        System.out.println("PlayList vazia!");
                    break;
                case 8:
                    System.out.println("Saindo.........");
                    break;
                default:
                    System.out.println("Erro, digite novamente!!");
            }
        }while(op != 8);


    }
}