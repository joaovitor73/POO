package org.example.visao;

import org.example.dominio.*;

public class Main {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        Fornecedor f = new Fornecedor();

        //teste dos métodos da classe pessoa
        p.setNome("João");
        p.setEndereco("Rua j");
        p.setTelefone("251 0000-0000");
        System.out.println("Nome: " + p.getNome());
        System.out.println("Endereco: " + p.getEndereco());
        System.out.println("Telefone: " + p.getTelefone());
        //teste dos métodos da classe fornecedor
        System.out.println();
        f.setNome("Pedro");
        f.setEndereco("Rua k");
        f.setTelefone("251 1111-1111");
        f.setValorCredito(1000);
        f.setValorDivida(500);
        System.out.println("Nome: " + f.getNome());
        System.out.println("Endereco: " + f.getEndereco());
        System.out.println("Telefone: " + f.getTelefone());
        System.out.println("Valor credito: " + f.getValorCredito());
        System.out.println("Valor divida: " + f.getValorDivida());
        System.out.println("Saldo: " + f.obterSaldo());
    }
}