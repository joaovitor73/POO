package org.example.dominio;

public class Livro extends Colecionaveis{
    private String nomeEditora;
    private int anoPubli;

    public Livro(int identificacao,String  titulo,int dia, int mes, int ano, String nomeEditora, int anoPubli){
        super(identificacao, titulo, dia, mes, ano);
        this.nomeEditora = nomeEditora;
        this.anoPubli = anoPubli;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public int getAnoPubli() {
        return anoPubli;
    }
}
