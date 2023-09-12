package aplicacao;

import java.util.ArrayList;

public class Disciplina {
    private ArrayList<Aluno> discentes;
    private int codDisciplina;
    private String titulo;
    private int ch;
    private String nomeDocente;

    public Disciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
        discentes = new ArrayList<Aluno>();
    }

    public int getCodDisciplina(){
        return codDisciplina;
    }

    public String melhorAluno(){
        String nome = "";
        float media = 0;
        for(Aluno aluno: discentes){
            if(aluno.getMedia() > media){
                media =  aluno.getMedia();
                nome =  aluno.getNome();
            }
        }
        return nome;
    }

    public String consultarAluno(int matricula){
        for(Aluno aluno: discentes){
            if(aluno.getMatricula() == matricula){
                return aluno.estado();
            }
        }
        return "Aluno não foi encontrado!";
    }

    public boolean novoAluno(int matricula){
        for(Aluno aluno: discentes){
            if(aluno.getMatricula() == matricula){
                return false;
            }
        }
        return true;
    }

    public String getTitulo(){
        return titulo;
    }


    public float media(){
        float media = 0;
        for(Aluno aluno: discentes){
            media +=  aluno.getMedia();
        }
        return media/discentes.size();
    }

    public void inserirDisciplina(String titulo, int ch, String nomeDocente){
        this.titulo = titulo;
        this.ch = ch;
        this.nomeDocente = nomeDocente;
    }

    public void inserirAlunos(Aluno aluno){
        discentes.add(aluno);
    }

    public String getDados(){
        return "Título: " + this.titulo + "\nCódigo: " + this.codDisciplina
                + "\nCH: " + this.ch + "\nDocente: " + this.nomeDocente;
    }

    public void alterarProfessor(String nomeDocente){
        this.nomeDocente = nomeDocente;
    }
}
