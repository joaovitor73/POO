package visao;

import aplicacao.Pais;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pais> listaPaises = new ArrayList();
        ArrayList<String> paisesVisinhos;
        Pais p , p1;
        Scanner teclado = new Scanner(System.in);
        int op, opAux;
        String nome, capital, pais, pais1;
        boolean flag;
        float dimersao;

        while(true){
            System.out.println("-------------------------------------------------------");
            System.out.println("1 - Cadastrar país");
            System.out.println("2 - Lista de países vizinhos comuns entre dois países");
            System.out.println("-------------------------------------------------------");
            op = teclado.nextInt();
            teclado.nextLine();
            switch (op){
                case 1:
                    System.out.println("Digite o nome do país");
                    nome = teclado.nextLine();
                    flag = true;
                    //Apenas países únicos
                    for(Pais pa : listaPaises){
                        if(pa.getNome().toUpperCase().trim().equals(nome.toUpperCase().trim())){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){

                        p = new Pais();
                        System.out.println("Digite o nome da capital: ");
                        capital = teclado.nextLine();
                        System.out.println("Digite a dimersão do país: ");
                        dimersao = teclado.nextFloat();
                        paisesVisinhos = new ArrayList<>();

                        System.out.println("O país: " + nome + " tem países vizinhos(1 - sim, 2 - Não): ");
                        opAux = teclado.nextInt();
                        teclado.nextLine();

                        if(opAux == 1){

                            do{
                                System.out.println("Digite o nome do país vizinho: ");
                                pais = teclado.nextLine();
                                //Apenas paizes vizinhos únicos
                                if(!pais.equals(nome)) {
                                    for (String pa : paisesVisinhos) {
                                        if (pa.equals(pais)) {
                                            flag = false;
                                            break;
                                        }
                                    }
                                    if(flag) {
                                        paisesVisinhos.add(pais);
                                        System.out.println("País vizinho cadastrado com sucesso\n");
                                    }else
                                        System.out.println("País ja existente, não foi possível realizar o cadastro");
                                }else{
                                    System.out.println("Erro, você digitou o vizinho com o mesmo nome do país cadastrado!\n");
                                }
                                System.out.println("Tem países vizinhos(1 - sim, 2 - Não): ");
                                opAux = teclado.nextInt();
                                teclado.nextLine();
                            }while(opAux == 1);

                            p.setPaisComFronteira(paisesVisinhos);
                            listaPaises.add(p);
                        }
                        p.setNome(nome);
                        p.setCapital(capital);
                        p.setDimersao(dimersao);
                        listaPaises.add(p);
                    }else{
                        System.out.println("Pais existente,tente cadastrar outro!");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do primerio país: ");
                    pais = teclado.nextLine();
                    flag = false;
                    p = new Pais();
                    for(Pais pa: listaPaises){
                        if(pa.getNome().equals(pais)){
                            flag = true;
                            p = pa;
                        }
                    }
                    if(flag){
                        System.out.println("Digite o nome do segundo país: ");
                        pais1 = teclado.nextLine();
                        flag = false;
                        p1 = new Pais();
                        for(Pais pa: listaPaises){
                            if(pa.getNome().equals(pais1)){
                                flag = true;
                                p1 = pa;
                                break;
                            }
                        }
                        if(flag){
                            paisesVisinhos =  p.paisesComum(p1);
                            flag = true;
                            if(!paisesVisinhos.isEmpty()){
                                for(Pais pa: listaPaises){
                                    if(flag){
                                        System.out.println("-------------------------------");
                                        System.out.println("Lista de países comuns: ");
                                        flag = false;
                                    }
                                    System.out.println("Nome: " + pa.getNome());
                                }
                                System.out.println("-------------------------------");
                            }else{
                                System.out.println("Nenhum país foi encontrado!");
                            }
                        }else{
                            System.out.println("O segundo país não foi encontrdado!");
                        }
                    }else{
                        System.out.println("O primeiro país não foi encontrdado!");
                    }
                    break;
            }
        }
    }
}