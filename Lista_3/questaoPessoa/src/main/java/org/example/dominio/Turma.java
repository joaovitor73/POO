package org.example.dominio;

import java.util.ArrayList;

public class Turma implements Repositorio{
    private int codigo;
    private ArrayList<Pessoa> alunos;
    private int ultimo;

    public Turma(int codigo){
        this.alunos = new ArrayList<Pessoa>();
        this.ultimo = 0;
        this.codigo = codigo;
    }

    public void guarda(Pessoa nova) {
        alunos.add(nova);
    }
    public Pessoa recupera(String cpf) {
        for(Pessoa p: alunos){
            if(p.getCPF().equals(cpf))
                return p;
        }
        return null;
    }

    public Pessoa primeiro() {
        return alunos.get(0);
    }
    public Pessoa proximo(){
        if(ultimo < alunos.size()-1) ultimo++;
        return alunos.get(ultimo);
    }

    public ArrayList<Pessoa> getAlunos(){
        return alunos;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public int getAlunoVez(){
        return this.ultimo;
    }
}
