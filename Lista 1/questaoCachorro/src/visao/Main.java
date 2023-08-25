package visao;

import aplicacao.Cachorro;

public class Main {
    public static void main(String[] args) {
       //Instanciando o objeto
        Cachorro c1 = new Cachorro("Cachorro sem nome", "Nenhuma raca definida", 0);
        //Métodos acessores
        System.out.println("--------------------------");
        System.out.println("Métodos acessores");
        System.out.println("Nome: " + c1.getNome());
        System.out.println("Raca: " + c1.getRaca());
        System.out.println("Idade: " + c1.getIdade());
        System.out.println("--------------------------");
        //Métodos modificadores
        c1.setNome("Totó");
        c1.setRaca("Vira-lata");
        c1.setIdade(2);
        //Acessando o estado do objeto
        System.out.println("Acessando o estado do cachorro 1");
        System.out.printf(c1.informarEstado());
        //Clonando o cachorro
        System.out.println("--------------------------");
        Cachorro c2 = c1.clonarCachorro();
        if(c1.equals(c2)) System.out.println("Os estados do cachorro 1 e 2 são iguais");
        else System.out.println("Os estados do cachorro 1 e 2 não são iguais");
        System.out.println("--------------------------");
        System.out.println("Acessando o estado do cachorro 2");
        System.out.printf(c2.informarEstado());
        System.out.println("--------------------------");
    }
}