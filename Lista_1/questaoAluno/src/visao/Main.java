package visao;

import aplicacao.Aluno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aluno a1, a2, a3;
        a1 = new Aluno();
        a2 = new Aluno();
        a3 = new Aluno();

        Scanner teclado = new Scanner(System.in);
        int op, matricula, notaId;
        String nome;
        float nota,n1,n2,n3;
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("MENU PRINCIPAL");
            System.out.println("---------------------------------------------------------");
            System.out.println("1 - CADASTRAR ALUNOS");
            System.out.println("2 - CADASTRAR NOTAS");
            System.out.println("3 - CALCULAR MÉDIAS");
            System.out.println("4 - INFORMAR SITUAÇÕES");
            System.out.println("5 - INFORMAR DADOS DE UM ALUNO");
            System.out.println("6 - ALTERAR NOTA");
            System.out.println("7 - SAIR");
            System.out.println("---------------------------------------------------------\n:");
            op = teclado.nextInt();

            switch (op){
                case 1:
                    teclado.nextLine();
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Digite o nome do aluno 1: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite a matrícula do aluno 1: ");
                    matricula = teclado.nextInt();
                    System.out.println("---------------------------------------------------------");
                    a1.setNome(nome);
                    a1.setMatricula(matricula);

                    teclado.nextLine();
                    System.out.println("Digite o nome do aluno 2: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite a matrícula do aluno 2: ");
                    matricula = teclado.nextInt();
                    System.out.println("---------------------------------------------------------");
                    a2.setNome(nome);
                    a2.setMatricula(matricula);

                    teclado.nextLine();
                    System.out.println("Digite o nome do aluno 3: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite a matrícula do aluno 3: ");
                    matricula = teclado.nextInt();
                    a3.setNome(nome);
                    a3.setMatricula(matricula);
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Digite a 1a. nota do aluno 1: ");
                    n1 = teclado.nextFloat();
                    System.out.println("Digite a 2a. nota do aluno 1: ");
                    n2 = teclado.nextFloat();
                    System.out.println("Digite a 3a. nota do aluno 1: ");
                    n3 = teclado.nextFloat();
                    a1.setNota(n1,n2,n3);

                    System.out.println("---------------------------------------------------------");
                    System.out.println("Digite a 1a. nota do aluno 2: ");
                    n1 = teclado.nextFloat();
                    System.out.println("Digite a 2a. nota do aluno 2: ");
                    n2 = teclado.nextFloat();
                    System.out.println("Digite a 3a. nota do aluno 2: ");
                    n3 = teclado.nextFloat();
                    a2.setNota(n1,n2,n3);

                    System.out.println("---------------------------------------------------------");
                    System.out.println("Digite a 1a. nota do aluno 3: ");
                    n1 = teclado.nextFloat();
                    System.out.println("Digite a 2a. nota do aluno 3: ");
                    n2 = teclado.nextFloat();
                    System.out.println("Digite a 3a. nota do aluno 3: ");
                    n3 = teclado.nextFloat();
                    a3.setNota(n1,n2,n3);
                    break;
                case 3:
                    a1.calcularMedia();
                    a2.calcularMedia();
                    a3.calcularMedia();
                    break;
                case 4:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Situação do aluno 1: " + a1.getSituacao());
                    System.out.println("Situação do aluno 2: " + a2.getSituacao());
                    System.out.println("Situação do aluno 3: " + a3.getSituacao());
                    break;
                case 5:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Digite a matrícula do aluno para busca: ");
                    matricula = teclado.nextInt();
                    System.out.println("---------------------------------------------------------");
                    if(a1.buscarAluno(matricula)) {
                        System.out.printf("Nome: " + a1.getNome());
                        System.out.println("Matrícula: " + a1.getMatricula());
                        System.out.println("Nota 1:" + a1.getNota1());
                        System.out.println("Nota 2:" + a1.getNota2());
                        System.out.println("Nota 3:" + a1.getNota3());
                        System.out.println("Media: " + a1.getMedia());
                        System.out.println("Situação: " + a1.getSituacao());
                    }else if(a2.buscarAluno(matricula)) {
                            System.out.printf("Nome: " + a2.getNome());
                            System.out.println("Matrícula: " + a2.getMatricula());
                            System.out.println("Nota 1:" + a2.getNota1());
                            System.out.println("Nota 2:" + a2.getNota2());
                            System.out.println("Nota 3:" + a2.getNota3());
                            System.out.println("Media: " + a2.getMedia());
                            System.out.println("Situação: " + a2.getSituacao());
                        }else if(a3.buscarAluno(matricula)){
                                System.out.printf("Nome: " + a3.getNome());
                                System.out.println("Matrícula: " + a3.getMatricula());
                                System.out.println("Nota 1:" + a3.getNota1());
                                System.out.println("Nota 2:" + a3.getNota2());
                                System.out.println("Nota 3:" + a3.getNota3());
                                System.out.println("Media: " + a3.getMedia());
                                System.out.println("Situação: " + a3.getSituacao());
                        }else System.out.println("Aluno não encontrado!");
                    break;
                case 6:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Digite a matrícula do aluno para busca: ");
                    matricula = teclado.nextInt();
                    System.out.println("---------------------------------------------------------");
                    if(a1.buscarAluno(matricula)) {
                        System.out.println("Você deseja alterar a nota 1, 2 ou 3: ");
                        notaId = teclado.nextInt();
                        if(notaId>= 1 && notaId <= 3){
                            System.out.println("Digite o valor da nova nota: ");
                            nota = teclado.nextFloat();
                            System.out.println("Situação: " + a1.alterarNota(notaId, nota));
                        }else System.out.println("Essa nota não existe!");
                    }else if(a2.buscarAluno(matricula)) {
                            System.out.println("Você deseja alterar a nota 1, 2 ou 3: ");
                            notaId = teclado.nextInt();
                            if(notaId>= 1 && notaId <= 3){
                                System.out.println("Digite o valor da nova nota: ");
                                nota = teclado.nextFloat();
                                System.out.println("Situação: " + a2.alterarNota(notaId, nota));
                            }else System.out.println("Essa nota não existe!");
                    }else if(a3.buscarAluno(matricula)){
                            System.out.println("Você deseja alterar a nota 1, 2 ou 3: ");
                            notaId = teclado.nextInt();
                            if(notaId>= 1 && notaId <= 3){
                                System.out.println("Digite o valor da nova nota: ");
                                nota = teclado.nextFloat();
                                System.out.println("Situação: " + a3.alterarNota(notaId, nota));
                            }else System.out.println("Essa nota não existe!");
                    }else System.out.println("Aluno não encontrado!");
                    break;
                case 7:
                    System.out.println("Saindo....");
                    break;
                default:
                    System.out.println("Valor incorreto, digite novamente!");
            }
        }while (op != 7);
    }

}