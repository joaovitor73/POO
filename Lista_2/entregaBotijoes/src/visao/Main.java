package visao;

import dominio.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList <Pedido> pedidosEntregues = new ArrayList<>();
        ArrayList <Pedido> pedidosConfirmados = new ArrayList<>();
        Pedido p;
        Scanner teclado = new Scanner(System.in);

        int opcao, op, codigo = 1, codAux, indice;
        boolean primeiraVez, achei;


        while(true) {
            p = new Pedido();
            System.out.println("-------------------------");
            System.out.println("Loja de botijões");
            System.out.println("-------------------------");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Confirmar entrega");
            System.out.println("3 - Ver pedidos entregues");
            System.out.println("4 - Ver pedidos confirmados");
            System.out.println("-------------------------");
            opcao = teclado.nextInt();
            if (opcao == 1) {
                System.out.println("Hora da compra: ");
                teclado.nextLine();
                p.setHoraC(teclado.nextLine());
                System.out.println("Endereço de entrega: ");
                p.setEnderecoEn(teclado.nextLine());
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                primeiraVez = true;
                do {
                    System.out.println("---------------------");
                    System.out.println("Hora da compra: " + p.getHoraC());
                    System.out.println("Endereço de entrega: " + p.getEnderecoEn());
                    System.out.println("-------------------------");
                    System.out.println("1 - Confirmar dados");
                    System.out.println("2 - Alterar dados");
                    System.out.println("-------------------------");
                    opcao = teclado.nextInt();
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if (opcao == 1) {
                        System.out.println("-------------------------");
                        System.out.println("Dados confirmados com sucesso!");
                        System.out.println("-------------------------");
                    } else if (opcao == 2) {
                        System.out.println("-------------------------");
                        System.out.println("1 - Alterar hora da compra");
                        System.out.println("2 - Alterar endereço de entraga");
                        System.out.println("3 - Alterar hora e endereço");
                        System.out.println("-------------------------");
                        op = teclado.nextInt();
                        switch (op) {
                            case 1:
                                System.out.println("Hora da compra: ");
                                teclado.nextLine();
                                p.setHoraC(teclado.nextLine());
                                break;
                            case 2:
                                if (primeiraVez) {//evitar pegar o enter do console
                                    primeiraVez = false;
                                    teclado.nextLine();
                                }
                                System.out.println("Endereço de entrega: ");
                                p.setEnderecoEn(teclado.nextLine());
                                break;
                            case 3:
                                System.out.println("Hora da compra: ");
                                teclado.nextLine();
                                p.setHoraC(teclado.nextLine());
                                System.out.println("Endereço de entrega: ");
                                p.setEnderecoEn(teclado.nextLine());
                                break;
                            default:
                                System.out.println("Não entendi, digite novamente!");
                        }
                    }
                } while (opcao != 1);
                System.out.println("Digite a quantidade a quantidade de botijões: ");
                p.setQuatidade(teclado.nextInt());
                System.out.println("-------------------------");
                System.out.println(p.dadosPedido());
                System.out.println("-------------------------");
                System.out.println("Digite o numero do cartão de crédito: ");
                p.setCartaoDeCredito(teclado.nextInt());
                p.setStatus("Confirmado");
                p.setCodigo(codigo);
                System.out.println("Código do pedido: " + p.getCodigo());
                pedidosConfirmados.add(p);
            }else if(opcao == 2){
                System.out.println("Digite o código do pedido: ");
                codAux = teclado.nextInt();
                indice = 0;
                achei = false;
                while (indice < pedidosConfirmados.size()) {
                    if(codAux == pedidosConfirmados.get(indice).getCodigo()) achei = true;
                    indice++;
                    if(achei) break;
                }
                if(achei) {
                    pedidosConfirmados.get(indice - 1).setStatus("Entregue");
                    pedidosEntregues.add(pedidosConfirmados.get(indice - 1));
                    pedidosConfirmados.remove(indice -1);
                    System.out.println("Pedido entregue!");
                }else System.out.println("Pedido não localizado");
            }else if(opcao == 3){
                achei = false;
                for(int i = 0; i < pedidosEntregues.size(); i++){
                    if(!achei) achei = true;
                    System.out.println("Codigo do pedido entregue: " +  pedidosEntregues.get(i).getCodigo());
                }
                if(!achei) System.out.println("Nenhum pedido entregue");
            }else if(opcao == 4){
                    achei = false;
                    for(int i = 0; i < pedidosConfirmados.size(); i++){
                        if(!achei) achei = true;
                        System.out.println("Codigo do pedido confirmado: " +  pedidosConfirmados.get(i).getCodigo());
                    }
                    if(!achei) System.out.println("Nenhum pedido Confirmado");
            }else System.out.println("Não entendi, digite novamente!");
            codigo += p.getCodigo();
        }
    }
}