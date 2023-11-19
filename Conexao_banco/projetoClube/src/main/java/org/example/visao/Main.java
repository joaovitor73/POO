package org.example.visao;

import org.example.Persistencia.DependenteDAO;
import org.example.Persistencia.SocioDAO;
import org.example.dominio.Dependente;
import org.example.dominio.Socio;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Socio> socios;
        ArrayList<Dependente> dependentes;
        Dependente dependente;
        Socio socio;
        SocioDAO sDAO = new SocioDAO();
        DependenteDAO dDAO = new DependenteDAO();
        int op,cpf, dia, mes, ano, novoCpf, op2,id,idade,cpf_s, novoId;
        String nome, data;
        do {
            System.out.println("\tMenu Principal");
            System.out.println("--------------------------");
            System.out.println("1 – Buscar Sócio");
            System.out.println("2 – Incluir Sócio");
            System.out.println("3 – Excluir Sócio");
            System.out.println("4 – Alterar Sócio");
            System.out.println("5 – Relatório de Sócios");
            System.out.println("6 – Sair do Sistema");
            op = teclado.nextInt();

            switch(op){
                case 1:
                    System.out.println("Digite o CPF: ");
                    cpf_s = teclado.nextInt();
                    socio = sDAO.relatorio_id(cpf_s);
                    if(socio != null) {
                        do {
                            System.out.println("\tMenu Secundário");
                            System.out.println("-------------------------");
                            System.out.println("1 – Buscar Dependente");
                            System.out.println("2 – Incluir Dependente");
                            System.out.println("3 – Alterar Dependente");
                            System.out.println("4 – Excluir Dependente");
                            System.out.println("5 – Relatório de Dependente");
                            System.out.println("6 – Voltar para o Menu Principal");
                            op2 = teclado.nextInt();
                            switch (op2){
                                case 1:
                                    System.out.println("Digite o id do dependente: ");
                                    id = teclado.nextInt();
                                    dependente = dDAO.relatorio_id(id,cpf_s);
                                    if(dependente != null){
                                        System.out.println("Nome: " + dependente.getNome_d());
                                        System.out.println("Idade: " + dependente.getIdade());
                                    }else System.out.println("Nenhum dependente foi encontrado em nosso sistema com esse id!!");
                                    break;
                                 case 2:
                                     System.out.println("Digite o id do dependente: ");
                                     id = teclado.nextInt();
                                     dependente = dDAO.relatorio_id(id, cpf_s);
                                     if(dependente == null){
                                         dependente = new Dependente();
                                         teclado.nextLine();
                                         System.out.println("Digite o nome do dependente: ");
                                         nome = teclado.nextLine();
                                         System.out.println("Digite a idade do dependente");
                                         idade = teclado.nextInt();
                                         dependente.setId(id);
                                         dependente.setNome_d(nome);
                                         dependente.setIdade(idade);
                                         dDAO.inserir(cpf_s,dependente);
                                     }else System.out.println(socio.getNome_s() + " você já tem dependente com esse id!");
                                    break;
                                 case 3:
                                     System.out.println("Digite o id do dependente: ");
                                     id = teclado.nextInt();
                                     dependente = dDAO.relatorio_id(id,cpf_s);
                                     if(dependente != null){
                                         System.out.println("Digite o novo id: ");
                                         novoId = teclado.nextInt();
                                         dependente = dDAO.relatorio_id(novoId,cpf_s);
                                         if(dependente == null){
                                             dependente = new Dependente();
                                             teclado.nextLine();
                                             System.out.println("Digite o nome do dependente: ");
                                             nome = teclado.nextLine();
                                             System.out.println("Digite a idade do dependente");
                                             idade = teclado.nextInt();
                                             dependente.setId(novoId);
                                             dependente.setNome_d(nome);
                                             dependente.setIdade(idade);
                                             dDAO.alterar(id,cpf_s,dependente);
                                         }else System.out.println(socio.getNome_s() + " você já tem um dependente com esse id!!");
                                     }else System.out.println("Nenhum dependente foi encontrado em nosso sistema com esse id!!");
                                    break;
                                 case 4:
                                     System.out.println("Digite o id do dependente: ");
                                     id = teclado.nextInt();
                                     dependente = dDAO.relatorio_id(id,cpf_s);
                                     if(dependente != null){
                                         dDAO.excluir(id,cpf_s);
                                     }else System.out.println("Nenhum dependente foi encontrado em nosso sistema com esse id!!");
                                    break;
                                 case 5:
                                        dependentes = dDAO.relatorioGeral(cpf_s);
                                        if(!dependentes.isEmpty()){
                                            System.out.println("Relatório de dependentes");
                                            System.out.println("-----------------------");
                                            for(Dependente d : dependentes){
                                                System.out.println("Id: " + d.getId());
                                                System.out.println("Nome: " + d.getNome_d());
                                                System.out.println("Idade: " + d.getIdade());
                                                System.out.println("-----------------------");
                                            }

                                        }else System.out.println("O sócio " + socio.getNome_s() + " não tem nenhum dependente cadastrado!!");
                                    break;
                                case 6:
                                    System.out.println("Voltando para o menu principal...");
                                    break;
                                default:
                                    System.out.println("Opção inválida, digite novamente!!");
                            }
                        }while(op2 != 6);
                    }else  System.out.println("Sócio com o CPF informado não foi encontrado em nosso sistema!!");
                    break;
                case 2:
                    //Digita cpf
                    System.out.println("Digite o CPF: ");
                    cpf = teclado.nextInt();
                    //verifica se existe
                    socio = sDAO.relatorio_id(cpf);
                    //Se não existe pede os restos das informações
                    if(socio == null){
                        socio = new Socio();
                        teclado.nextLine();
                        System.out.println("Digite o nome: ");
                        nome = teclado.nextLine();
                        System.out.println("Digite o dia da adimissão: ");
                        dia = teclado.nextInt();
                        System.out.println("Digite o mês: ");
                        mes = teclado.nextInt();
                        System.out.println("Digite o ano: ");
                        ano = teclado.nextInt();
                        socio.setCpf_s(cpf);
                        socio.setNome_s(nome);
                        data = "";
                        //Enviar data no formato do postgre
                        data = String.format("%04d-%02d-%02d", ano, mes, dia);
                        socio.setData_adm(data);
                        sDAO.inserir(socio);
                    }else System.out.println("Já existe sócio cadastrado com esse CPF!!");
                    break;
                case 3:
                    System.out.println("Digite o seu CPF: ");
                    cpf = teclado.nextInt();
                    //verificar se existe
                    socio = sDAO.relatorio_id(cpf);
                    //se existir enviar o cpf para remover do banco
                    if(socio != null){
                        dependentes = dDAO.relatorioGeral(cpf);
                        if(dependentes.isEmpty()) sDAO.excluir(cpf);
                        else System.out.println(socio.getNome_s() + " so podemos te remover do sistemas se voccê não tiver mais nenhum dependente!!");
                    }else System.out.println("Sócio com o CPF informado não foi encontrado em nosso sistema!!");
                    break;
                case 4:
                    System.out.println("Digite o seu CPF: ");
                    cpf = teclado.nextInt();
                    //verificar se existe
                    socio = sDAO.relatorio_id(cpf);
                    //se existir enviar o cpf para remover do banco
                    if(socio != null){
                        System.out.println("Digite o novo CPF: ");
                        novoCpf = teclado.nextInt();
                        socio = sDAO.relatorio_id(novoCpf);
                        if(socio == null) {
                            socio = new Socio();
                            teclado.nextLine();
                            System.out.println("Digite o novo nome: ");
                            nome = teclado.nextLine();
                            System.out.println("Digite o dia da adimissão: ");
                            dia = teclado.nextInt();
                            System.out.println("Digite o mês: ");
                            mes = teclado.nextInt();
                            System.out.println("Digite o ano: ");
                            ano = teclado.nextInt();
                            socio.setCpf_s(novoCpf);
                            socio.setNome_s(nome);
                            data = "";
                            //Enviar data no formato do postgre
                            data = String.format("%04d-%02d-%02d", ano, mes, dia);
                            socio.setData_adm(data);
                            sDAO.atualizar(cpf, socio);
                        }else System.out.println("Já existe sócio cadastrado com esse CPF!!");
                    }else System.out.println("Sócio com o CPF informado não foi encontrado em nosso sistema!!");
                    break;
                case 5:
                    socios = sDAO.relatorioGeral();
                    if(!socios.isEmpty()) {
                        System.out.println("RELATÓRIO GERAL");
                        System.out.println("-----------------------");
                        for (Socio s : socios) {
                            System.out.println("CPF: " + s.getCpf_s());
                            System.out.println("Nome: " + s.getNome_s());
                            System.out.println("Data adimissão: " + s.getData_adm());
                            System.out.println("-----------------------");
                        }
                    }else System.out.println("Nenhum sócio foi cadastrado ainda no sistema!!");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente!!");
            }

        }while(op != 6);
    }
}