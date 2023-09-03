package visao;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import aplicacao.Pessoa;
public class Main {
    public static void main(String[] args) {
        ArrayList<Pessoa> agenda = new ArrayList();
        Pessoa p, pAux = null;
        Scanner teclado = new Scanner(System.in);
        int op, escolha, i;
        String aux;
        boolean flag;
        String email, telefone, nome;

        while(true){
            System.out.println("-------------------------------------");
            System.out.println("\t\t\t\tAGENDA");
            System.out.println("-------------------------------------");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Remover pessoa");
            System.out.println("3 - Buscar pessoa");
            System.out.println("4 - Listar contatos");
            System.out.println("-------------------------------------");
            op = teclado.nextInt();
            switch(op){
                case 1:
                    teclado.nextLine();
                    p = new Pessoa();
                    flag = true;
                    System.out.println("Email: ");
                    aux = teclado.nextLine();
                    i = 0;
                    while((i < agenda.size() )&& (flag)){
                        if(agenda.get(i).getEmail().equals(aux)){
                            flag = false;
                            pAux = agenda.get(i);
                        }
                        i++;
                    }
                    if(flag) {
                        p.setEmail(aux);
                        System.out.println("Nome: ");
                        p.setNome(teclado.nextLine());
                        System.out.println("Telefone: ");
                        p.setTelefone(teclado.nextLine());
                        System.out.println("Contato salvo com sucesso!");
                        agenda.add(p);
                    }else{
                        System.out.println("Contato já existente");
                        do {
                            System.out.println("-------------------------------------");
                            System.out.println("1 - Ver o contato");
                            System.out.println("2 - Adicionar novo número");
                            System.out.println("3 - Voltar para o menu principal");
                            System.out.println("-------------------------------------");
                            escolha = teclado.nextInt();
                            switch(escolha){
                                case 1:
                                    flag = true;
                                    i = 0;
                                    while((i < agenda.size() )&& (flag)){
                                            if(agenda.get(i).getEmail().equals(aux)) {
                                                System.out.println("-------------------------------------");
                                                System.out.println("\t\t\tContato");
                                                System.out.println("-------------------------------------");
                                                flag = false;
                                                System.out.println("Nome: " + agenda.get(i).getNome());
                                                System.out.println("Email: " + agenda.get(i).getEmail());
                                                System.out.println("Telefone: ");
                                                for (int j = 0; j < agenda.get(i).getTelefone().size(); j++) {
                                                    System.out.println(agenda.get(i).getTelefone().get(j));
                                                }
                                                System.out.println("-------------------------------------");
                                            }
                                            i++;
                                        }
                                    break;
                                case 2:
                                    teclado.nextLine();
                                    System.out.println("Telefone: ");
                                    pAux.setTelefone(teclado.nextLine());
                                    System.out.println("Novo contado adicionado com sucesso!");
                                    break;
                                case 3:
                                    System.out.println("Saindo...");
                                    break;
                                default:
                                    System.out.println("Não entendi, digite novamente!");
                            }
                        }while(escolha != 3);
                    }
                    break;
                case 2:
                    teclado.nextLine();
                    System.out.println("Digite o email: ");
                    email = teclado.nextLine();
                    System.out.println("Digite o telefone");
                    telefone = teclado.nextLine();
                    flag = false;
                    i = 0;
                    while((i < agenda.size() )&& (!flag)){
                        if(agenda.get(i).getEmail().equals(email)){
                            for (int j = 0; j < agenda.get(i).getTelefone().size(); j++) {
                                if (agenda.get(i).getTelefone().get(j).equals(telefone)){
                                    flag = true;
                                    agenda.remove(i);
                                }
                            }
                        }
                        i++;
                    }
                    if(flag) System.out.println("Contato removido com sucesso!");
                    else System.out.println("Contato não encontrado!");

                    break;
                case 3:
                    System.out.println("Buscar por: ");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Email");
                    System.out.println("3 - Telefone");
                    escolha = teclado.nextInt();
                    teclado.nextLine();
                    flag = false;
                    switch (escolha){
                        case 1:
                            System.out.println("Digite o nome");
                            nome = teclado.nextLine();
                            System.out.println("Escolha o dado da busca");
                            System.out.println("1 - Email");
                            System.out.println("2 - Telefone");
                            escolha = teclado.nextInt();
                            switch (escolha){
                                case 1:
                                    for(i = 0; i < agenda.size(); i++){
                                        if(agenda.get(i).getNome().equals(nome)) {
                                            System.out.println("-------------------------------------");
                                            System.out.println("Email: " + agenda.get(i).getEmail());
                                            System.out.println("-------------------------------------");
                                            flag = true;
                                        }
                                    }
                                    break;
                                case 2:
                                    for(i = 0; i < agenda.size(); i++){
                                        if(agenda.get(i).getNome().equals(nome)) {
                                            System.out.println("-------------------------------------");
                                            System.out.println("Telefone: ");
                                            for (int j = 0; j < agenda.get(i).getTelefone().size(); j++) {
                                                System.out.println(agenda.get(i).getTelefone().get(j));
                                            }
                                            System.out.println("-------------------------------------");
                                            flag = true;
                                        }
                                    }
                                    break;
                                default: System.out.println("Não entendi, digite novamente!");
                            }
                            break;
                        case 2:
                            System.out.println("Digite o email");
                            email = teclado.nextLine();
                            System.out.println("Escolha o dado da busca");
                            System.out.println("1 - Nome");
                            System.out.println("2 - Telefone");
                            escolha = teclado.nextInt();
                            switch (escolha){
                                case 1:
                                    for(i = 0; i < agenda.size(); i++){
                                         if(agenda.get(i).getEmail().equals(email)) {
                                            System.out.println("-------------------------------------");
                                            System.out.println("Nome: " + agenda.get(i).getNome());
                                            System.out.println("-------------------------------------");
                                            flag = true;
                                        }
                                    }
                                    break;
                                case 2:
                                    for(i = 0; i < agenda.size(); i++){
                                        if(agenda.get(i).getEmail().equals(email)) {
                                            System.out.println("-------------------------------------");
                                            System.out.println("Telefone: ");
                                            for (int j = 0; j < agenda.get(i).getTelefone().size(); j++) {
                                                System.out.println(agenda.get(i).getTelefone().get(j));
                                            }
                                            System.out.println("-------------------------------------");
                                            flag = true;
                                        }
                                    }
                                    break;
                                default: System.out.println("Não entendi, digite novamente!");
                            }
                            break;
                        case 3:
                            System.out.println("Digite o telefone");
                            telefone = teclado.nextLine();
                            System.out.println("Escolha o dado da busca");
                            System.out.println("1 - Nome");
                            System.out.println("2 - Email");
                            escolha = teclado.nextInt();
                            switch (escolha){
                                case 1:
                                    for(i = 0; i < agenda.size(); i++){
                                        for (int j = 0; j < agenda.get(i).getTelefone().size(); j++) {
                                            if(agenda.get(i).getTelefone().get(j).equals(telefone)){
                                                System.out.println("-------------------------------------");
                                                System.out.println("Nome: " + agenda.get(i).getNome());
                                                System.out.println("-------------------------------------");
                                                flag = true;
                                            }
                                        }
                                    }
                                    break;
                                case 2:
                                    for(i = 0; i < agenda.size(); i++){
                                        for (int j = 0; j < agenda.get(i).getTelefone().size(); j++) {
                                            if(agenda.get(i).getTelefone().get(j).equals(telefone)){
                                                System.out.println("-------------------------------------");
                                                System.out.println("Email: " + agenda.get(i).getEmail());
                                                System.out.println("-------------------------------------");
                                                flag = true;
                                            }
                                        }
                                    }
                                    break;
                                default: System.out.println("Não entendi, digite novamente!");
                            }
                            break;
                        default:
                            System.out.println("Não entendi, digite novamente!");
                    }
                    if(!flag && escolha >= 1 && escolha <= 2) System.out.println("Dado não encontrado!");
                    break;
                case 4:
                    for(i = 0; i < agenda.size(); i++){
                        System.out.println("-------------------------------------");
                        System.out.println("Nome: " + agenda.get(i).getNome());
                        System.out.println("Email: " + agenda.get(i).getEmail());
                        System.out.println("Telefone: ");
                        for(int j = 0; j < agenda.get(i).getTelefone().size();j++){
                            System.out.println(agenda.get(i).getTelefone().get(j));
                        }
                        System.out.println("-------------------------------------");
                    }
                    break;
                default:
                    System.out.println("Não entendi, digite novamente");
            }
        }
    }
}