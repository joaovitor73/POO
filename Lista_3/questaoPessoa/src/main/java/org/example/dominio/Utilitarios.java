package org.example.dominio;

import java.util.ArrayList;

public class Utilitarios {

    public void duplica(Turma t1,Turma t2){
        ArrayList<Pessoa> alunos = t1.getAlunos();
        for(Pessoa p : alunos ){
            t2.guarda(p);
        }

    }

    public void diferenca(Turma t1, Turma t2, Turma t3){
        ArrayList<Pessoa> alunos1 = t1.getAlunos();
        ArrayList<Pessoa> alunos2 = t2.getAlunos();
        boolean flag;
        for(Pessoa a1: alunos1){
            flag = true;
            for(Pessoa a2: alunos2){
                if((a1.getCPF().equals(a2.getCPF())) && (a1.getNome().equals(a2.getNome()))) {
                    flag = false;
                    break;
                }
            }
            if(flag) t3.guarda(a1); //a1 não existe em alunos 2
        }

    }
}
