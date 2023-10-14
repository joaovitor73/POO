package org.example.visao;

import org.example.dominio.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Turma> turmas = new ArrayList<Turma>();
        Utilitarios uti = new Utilitarios();
        ArrayList<Pessoa> alunos;
        Aluno a1;
        Pessoa p = null;
        Turma t1 = null, t2 = null, t3 = null;
        int op, codigo;
        boolean flag;
        String nome, cpf, endereco;
        do {
            System.out.println("\n1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Duplicar turma");
            System.out.println("4 - Guardar em uma terceira turma alunos que não pertença a duas ao mesmo tempo");
            System.out.println("5 - Listar Turmas");
            System.out.println("6 - Listar alunos");
            System.out.println("7 - Procurar aluno por CPF");
            System.out.println("8 - Procurar pelo primeiro aluno da turma");
            System.out.println("9 - Procurar pelo próximo aluno da turma");
            System.out.println("10 - sair");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    System.out.println("CADASTRANDO TURMA");
                    System.out.println("\nDigite o código da turma: ");
                    codigo = teclado.nextInt();
                    flag = true;
                    for(Turma t: turmas){
                        if(t.getCodigo()==codigo){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        t1 = new Turma(codigo);
                        turmas.add(t1);
                        System.out.println("Turma cadastrada com sucesso!!");
                    }else System.out.println("Já existe uma turma cadastrada em nosso sistema com esse código!!");
                    break;
                case 2:
                    if(!turmas.isEmpty()) {
                        System.out.println("CADASTRANDO ALUNOS: ");
                        System.out.println("\nDigite o código da turma: ");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            teclado.nextLine();
                            System.out.println("Digite o CPF do aluno: ");
                            cpf = teclado.nextLine();
                            flag = true;
                            alunos = t1.getAlunos();
                            for (Pessoa a : alunos) {
                                if (a.getCPF().equals(cpf)) {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag) {
                                System.out.println("Digite o nome do aluno: ");
                                nome = teclado.nextLine();
                                System.out.println("Digite o endereco do aluno: ");
                                endereco = teclado.nextLine();
                                a1 = new Aluno(nome, cpf, endereco);
                                t1.guarda(a1);
                                System.out.println("Aluno cadastrado com sucesso!!");
                            } else
                                System.out.println("O aluno com esse CPF já foi cadastrado na turma com esse código!!");
                        } else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 3:
                    if(!turmas.isEmpty()){
                        System.out.println("Digite o código da turma que você deseja cópiar os alunos: ");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.println("Digite o código da turma para onde os alunos serão tranferidos: ");
                            codigo = teclado.nextInt();
                            flag = false;
                            for (Turma t : turmas) {
                                if (t.getCodigo() == codigo) {
                                    t2 = t;
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                uti.duplica(t1,t2);
                                System.out.println("Duplicação realizada com sucesso!!");
                            } else System.out.println("A turma com esse código não foi encontrada!!");
                        } else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 4:
                    if(!turmas.isEmpty()){
                        System.out.println("Digite o código da primeira turma: ");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            System.out.println("Digite o código da segunda turma: ");
                            codigo = teclado.nextInt();
                            flag = false;
                            for (Turma t : turmas) {
                                if (t.getCodigo() == codigo) {
                                    t2 = t;
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                System.out.println("Digite o código da turma para onde os alunos serão transferidos: ");
                                codigo = teclado.nextInt();
                                flag = false;
                                for (Turma t : turmas) {
                                    if (t.getCodigo() == codigo) {
                                        t3 = t;
                                        flag = true;
                                        break;
                                    }
                                }
                                if (flag) {
                                    uti.diferenca(t1,t2,t3);
                                    System.out.println("Duplicação realizada com sucesso!!");
                                } else System.out.println("A turma com esse código não foi encontrada!!");
                            } else System.out.println("A turma com esse código não foi encontrada!!");
                        } else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 5:
                    if(!turmas.isEmpty()){
                        System.out.println("TURMAS CADASTRADAS: \n");
                        for(Turma t: turmas)
                            System.out.println("Código da turma: " + t.getCodigo());
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 6:
                    if(!turmas.isEmpty()){
                        System.out.println("Digite o código da turma: \n");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            alunos = t1.getAlunos();
                            if(!alunos.isEmpty()) {
                                System.out.println("ALUNOS CADASTRADOS: \n");
                                for (Pessoa a : alunos) {
                                    System.out.println("Nome: " + a.getNome());
                                    System.out.println("CPF: " + a.getCPF());
                                }
                            }else System.out.println("Nenhum aluno foi cadastrado na turma com esse código");
                        }else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 7:
                    if(!turmas.isEmpty()) {
                        System.out.println("\nDigite o código da turma: ");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            alunos = t1.getAlunos();
                            if(!alunos.isEmpty()) {
                                teclado.nextLine();
                                System.out.println("Digite o CPF do aluno: ");
                                cpf = teclado.nextLine();
                                flag = false;
                                for (Pessoa a : alunos) {
                                    if (a.getCPF().equals(cpf)) {
                                        flag = true;
                                        p = a;
                                        break;
                                    }
                                }
                                if (flag) {
                                    System.out.println("Nome: " + p.getNome());
                                    System.out.println("CPF: " + p.getCPF());
                                } else
                                    System.out.println("O aluno com esse CPF já foi cadastrado na turma com esse código!!");
                            }else System.out.println("Nenhum aluno foi cadastrado na turma com esse código");
                        } else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 8:
                    if(!turmas.isEmpty()) {
                        System.out.println("\nDigite o código da turma: ");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            alunos = t1.getAlunos();
                            if(!alunos.isEmpty()){
                                System.out.println("Primeiro aluno da turma: \n");
                                System.out.println("Nome: " + alunos.get(0).getNome());
                                System.out.println("CPF: " + alunos.get(0).getCPF());
                            }else System.out.println("Nenhum aluno foi cadastrado na turma com esse código");
                        } else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 9:
                    if(!turmas.isEmpty()) {
                        System.out.println("\nDigite o código da turma: ");
                        codigo = teclado.nextInt();
                        flag = false;
                        for (Turma t : turmas) {
                            if (t.getCodigo() == codigo) {
                                t1 = t;
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            alunos = t1.getAlunos();
                            if(!alunos.isEmpty()){
                                p = t1.proximo();
                                System.out.println("Primeiro aluno da turma: \n");
                                System.out.println("Nome: " + p.getNome());
                                System.out.println("CPF: " + p.getCPF());
                                System.out.println("Posição: " + (t1.getAlunoVez()+1));
                            }else System.out.println("Nenhum aluno foi cadastrado na turma com esse código");
                        } else System.out.println("A turma com esse código não foi encontrada!!");
                    }else System.out.println("Nenhuma turma cadastrada em nosso sistema!!");
                    break;
                case 10:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Valor inválido, digite novamente!");
            }
        }while(op != 10);

    }
}