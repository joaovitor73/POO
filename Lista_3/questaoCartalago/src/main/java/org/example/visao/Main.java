package org.example.visao;

import org.example.dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<Livro>();
        ArrayList<Cd> cds = new ArrayList<Cd>();
        ArrayList<Dvd> dvds = new ArrayList<Dvd>();
        ArrayList<Revista> revistas = new ArrayList<Revista>();
        ArrayList<Colecionaveis> colecao = new ArrayList<Colecionaveis>();
        Livro l1;
        Cd c1;
        Dvd d1;
        Revista r1;
        int op, op2, numero = 0, dia, mes, ano, anoPubli, volume;
        boolean flag;
        String titulo, editora, genero, tipo;
        do{
            System.out.println("---------------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Sir");
            System.out.println("---------------------------------------");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Cadastrar livro");
                    System.out.println("2 - Cadastrar CD");
                    System.out.println("3 - Cadastrar DVD");
                    System.out.println("4 - Cadastrar Revista");
                    System.out.println("---------------------------------------");
                    op2 = teclado.nextInt();
                    flag = true;
                    if(op <= 4 &&  op >= 1){
                        System.out.println("Digite um número único para identificação: ");
                        numero = teclado.nextInt();
                        for(Colecionaveis c : colecao){
                            if(c.getIdentificacao() == numero){
                                flag = false;
                                break;
                            }
                        }
                    } else System.out.println("Erro ao digitar");
                    if(flag) {
                        teclado.nextLine();
                        System.out.println("Digite o título da obra: ");
                        titulo = teclado.nextLine();
                        do {
                            System.out.println("Digite o dia da aquisição");
                            dia = teclado.nextInt();
                        }while(dia < 1 || dia > 31); do {
                            System.out.println("Digite o mes da aquisição");
                            mes = teclado.nextInt();
                        }while(mes < 1 || mes > 12);
                        do {
                            System.out.println("Digite o ano da aquisição");
                            ano = teclado.nextInt();
                        }while(ano < 1);

                        switch (op2) {
                            case 1:
                                teclado.nextLine();
                                System.out.println("Digite o nome da editora: ");
                                editora = teclado.nextLine();
                                System.out.println("Digite o ano de publicação: ");
                                anoPubli = teclado.nextInt();
                                l1 = new Livro(numero, titulo, dia, mes, ano, editora, anoPubli);
                                livros.add(l1);
                                colecao.add(l1);
                                break;
                            case 2:
                                teclado.nextLine();
                                System.out.println("Digite o seu gênero: ");
                                genero = teclado.nextLine();
                                c1 = new Cd(numero, titulo, dia, mes, ano, genero);
                                cds.add(c1);
                                colecao.add(c1);
                                break;
                            case 3:
                                teclado.nextLine();
                                System.out.println("Digite o seu tipo: ");
                                tipo = teclado.nextLine();
                                d1 = new Dvd(numero, titulo, dia, mes, ano, tipo);
                                dvds.add(d1);
                                colecao.add(d1);
                                break;
                            case 4:
                                System.out.println("Digite o ano de publicação: ");
                                anoPubli = teclado.nextInt();
                                teclado.nextLine();
                                System.out.println("Digite o nome da editora: ");
                                editora = teclado.nextLine();
                                System.out.println("Digite o número do volume: ");
                                volume = teclado.nextInt();
                                r1 = new Revista(numero, titulo, dia, mes, ano, anoPubli, editora, volume);
                                revistas.add(r1);
                                colecao.add(r1);
                                break;
                            default:
                                System.out.println("Erro ao digitar");
                        }
                    }else System.out.println("Já existe um item com esse indentificador!!");
                    break;
                case 2:
                    System.out.println("---------------------------------------");
                    System.out.println("1 - Listar livro");
                    System.out.println("2 - Listar CD");
                    System.out.println("3 - Listar DVD");
                    System.out.println("4 - Listar Revista");
                    System.out.println("5 - Listar colecionáveis");
                    System.out.println("---------------------------------------");
                    op2 = teclado.nextInt();
                    switch (op2) {
                        case 1:
                            if(!livros.isEmpty()) {
                                for (Livro l : livros) {
                                    System.out.println("Numero: " + l.getIdentificacao());
                                    System.out.println("Título: " + l.getTitulo());
                                    System.out.println("Data de aquisição: " + l.getDataAquisicao());
                                    System.out.println("Editora: " + l.getNomeEditora());
                                    System.out.println("Ano publicação: " + l.getAnoPubli());
                                }
                            }else System.out.println("Nenhum livro cadastrado em nosso sistema!!");
                            break;
                        case 2:
                            if(!cds.isEmpty()) {
                                for(Cd c : cds){
                                    System.out.println("Numero: " + c.getIdentificacao());
                                    System.out.println("Título: " + c.getTitulo());
                                    System.out.println("Data de aquisição: " + c.getDataAquisicao());
                                    System.out.println("Gênero: " + c.getGenero());
                                }
                            }else System.out.println("Nenhum CD cadastrado em nosso sistema!!");
                            break;
                        case 3:
                            if(!dvds.isEmpty()) {
                                for(Dvd d : dvds){
                                    System.out.println("Numero: " + d.getIdentificacao());
                                    System.out.println("Título: " + d.getTitulo());
                                    System.out.println("Data de aquisição: " + d.getDataAquisicao());
                                    System.out.println("Tipo: " + d.getTipo());
                                }
                            }else System.out.println("Nenhum DVD cadastrado em nosso sistema!!");
                            break;
                        case 4:
                            if(!revistas.isEmpty()) {
                                for(Revista r : revistas){
                                    System.out.println("Numero: " + r.getIdentificacao());
                                    System.out.println("Título: " + r.getTitulo());
                                    System.out.println("Data de aquisição: " + r.getDataAquisicao());
                                    System.out.println("Editora: " + r.getEditora());
                                    System.out.println("Ano publicação: " + r.getAnoPubli());
                                    System.out.println("Volume: " + r.getVolume());
                                }
                            }else System.out.println("Nenhuma revista cadastrada em nosso sistema!!");
                            break;
                        case 5:
                            if(!colecao.isEmpty()) {
                                for(Colecionaveis c : colecao){
                                    System.out.println("Numero: " + c.getIdentificacao());
                                    System.out.println("Título: " + c.getTitulo());
                                    System.out.println("Data de aquisição: " + c.getDataAquisicao());
                                }
                            }else System.out.println("Coleção de itens vazia!!");
                            break;
                        default:
                            System.out.println("Erro ao digitar");
                    }
                    break;
                case 3:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Erro ao digitar");
            }
        }while(op != 3);
    }
}