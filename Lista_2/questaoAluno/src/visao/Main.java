package visao;

import aplicacao.Aluno;
import aplicacao.Disciplina;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int op, codigo = 1, ch, matricula;
        float ntProva[] = new float[2];
        float ntTra;
        ArrayList <Disciplina> disciplina = new ArrayList<Disciplina>();
        Disciplina d = null;
        Aluno aluno;
        String titulo, nome;
        boolean flag;

        do{
            System.out.println("----------------------------------");
            System.out.println("\t\tMENU");
            System.out.println("1 - Cadastrar disciplina");
            System.out.println("2 - Cadastrar aluno");
            System.out.println("3 - Melhor aluno da turma: ");
            System.out.println("4 - Média de notas da disciplina: ");
            System.out.println("5 - Listar disciplinas cadastradas");
            System.out.println("6 - Consultar aluno");
            System.out.println("7 - Alterar professor");
            System.out.println("8 - Sair");
            System.out.println("----------------------------------");
            op = teclado.nextInt();

            switch (op){
                case 1:
                    System.out.println("----------------------------------");
                    teclado.nextLine();
                    System.out.println("Digite o título: ");
                    titulo = teclado.nextLine();
                    System.out.println("Digite a CH: ");
                    ch = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Digite o nome do docente: ");
                    nome = teclado.nextLine();
                    d = new Disciplina(codigo);
                    d.inserirDisciplina(titulo,ch,nome);
                    disciplina.add(d);
                    System.out.println("Disciplina cadastrada com sucesso!!");
                    codigo++;
                    System.out.println("----------------------------------");
                    break;
                case 2:
                    if(!disciplina.isEmpty()){
                        System.out.println("----------------------------------");
                        flag = false;
                        System.out.println("Digite o código da disciplina: ");
                        codigo = teclado.nextInt();
                        for(Disciplina  disci : disciplina){
                            if(disci.getCodDisciplina() == codigo){
                                d = disci;
                                flag = true;
                                break;
                            }
                        }
                        if(flag) {
                            System.out.println("----------------------------------");
                            System.out.println("Disciplina: " + d.getTitulo());
                            System.out.println("----------------------------------");
                            System.out.println("Digite a matricula do aluno: ");
                            matricula = teclado.nextInt();
                            if (d.novoAluno(matricula)) {
                                System.out.println("Digite o nome do aluno: ");
                                teclado.nextLine();
                                nome = teclado.nextLine();
                                System.out.println("Digite a primeira nota da prova: ");
                                ntProva[0] = teclado.nextFloat();
                                System.out.println("Digite a segunda nota da prova: ");
                                ntProva[1] = teclado.nextFloat();
                                System.out.println("Digite a nota do trabalho: ");
                                ntTra = teclado.nextFloat();
                                aluno = new Aluno(matricula,nome,ntProva,ntTra);
                                d.inserirAlunos(aluno);
                                System.out.println("Aluno cadastrado com sucesso!!");
                                System.out.println("----------------------------------");
                            } else System.out.println("Aluno já existente na disciplina!!");
                        }else System.out.println("Disciplina não foi encontrada!!");
                    }else System.out.println("Nenhuma disciplina foi cadastrada!!");
                    System.out.println("----------------------------------");
                    break;
                case 3: if(!disciplina.isEmpty()){
                            System.out.println("----------------------------------");
                            flag = false;
                            System.out.println("Digite o código da disciplina: ");
                            codigo = teclado.nextInt();
                            for(Disciplina  disci : disciplina){
                                if(disci.getCodDisciplina() == codigo){
                                    d = disci;
                                    flag = true;
                                    break;
                                }
                            }
                            if(flag) {
                                System.out.println("----------------------------------");
                                System.out.println("Disciplina: " + d.getTitulo());
                                System.out.println("----------------------------------");
                                if(!d.melhorAluno().equals(""))
                                    System.out.println("Melhor aluno da turma: " + d.melhorAluno());
                                else
                                    System.out.println("Nenhum aluno ainda foi cadastrado!!");
                            }else System.out.println("Disciplina não foi encontrada!!");
                        }else System.out.println("Nenhuma disciplina foi cadastrada!!");
                        System.out.println("----------------------------------");
                    break;
                case 4:
                    if(!disciplina.isEmpty()){
                        System.out.println("----------------------------------");
                        flag = false;
                        System.out.println("Digite o código da disciplina: ");
                        codigo = teclado.nextInt();
                        for(Disciplina  disci : disciplina){
                            if(disci.getCodDisciplina() == codigo){
                                d = disci;
                                flag = true;
                                break;
                            }
                        }
                        if(flag) {
                            System.out.println("----------------------------------");
                            System.out.println("Disciplina: " + d.getTitulo());
                            System.out.println("----------------------------------");
                            if(!d.melhorAluno().equals("")) {
                                System.out.println("Média da turma: " + d.media());;
                            }else
                                System.out.println("Nenhum aluno ainda foi cadastrado!!");
                        }else System.out.println("Disciplina não foi encontrada!!");
                    }else System.out.println("Nenhuma disciplina foi cadastrada!!");
                    System.out.println("----------------------------------");
                    break;
                case 5:
                    if(!disciplina.isEmpty()){
                        System.out.println("----------------------------------");
                        for(Disciplina  disci : disciplina){
                            System.out.println(disci.getDados());
                            System.out.println("----------------------------------");
                        }
                    }else System.out.println("Nenhuma disciplina foi cadastrada!!");
                    System.out.println("----------------------------------");
                    break;
                case 6:
                    if(!disciplina.isEmpty()){
                        System.out.println("----------------------------------");
                        flag = false;
                        System.out.println("Digite o código da disciplina: ");
                        codigo = teclado.nextInt();
                        for(Disciplina  disci : disciplina){
                            if(disci.getCodDisciplina() == codigo){
                                d = disci;
                                flag = true;
                                break;
                            }
                        }
                        if(flag) {
                            System.out.println("----------------------------------");
                            System.out.println("Disciplina: " + d.getTitulo());
                            System.out.println("----------------------------------");
                            System.out.println("Digite a matricula do aluno: ");
                            matricula = teclado.nextInt();
                            if (!d.novoAluno(matricula)) {
                                System.out.println(d.consultarAluno(matricula));
                                System.out.println("----------------------------------");
                            }else System.out.println("Aluno não foi encontrado!!");
                        }else System.out.println("Disciplina não foi encontrada!!");
                    }else System.out.println("Nenhuma disciplina foi cadastrada!!");
                    System.out.println("----------------------------------");
                    break;
                case 7:
                    if(!disciplina.isEmpty()){
                        System.out.println("----------------------------------");
                        flag = false;
                        System.out.println("Digite o código da disciplina: ");
                        codigo = teclado.nextInt();
                        for(Disciplina  disci : disciplina){
                            if(disci.getCodDisciplina() == codigo){
                                d = disci;
                                flag = true;
                                break;
                            }
                        }
                        if(flag) {
                            teclado.nextLine();
                            System.out.println("----------------------------------");
                            System.out.println("Disciplina: " + d.getTitulo());
                            System.out.println("Digite o nome do novo professor: ");
                            d.alterarProfessor(teclado.nextLine());
                        }else System.out.println("Disciplina não foi encontrada!!");
                    }else System.out.println("Nenhuma disciplina foi cadastrada!!");
                    System.out.println("----------------------------------");
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente!");
            }

        }while(op != 8);
        System.out.println("Fim de programa!!");
    }
}