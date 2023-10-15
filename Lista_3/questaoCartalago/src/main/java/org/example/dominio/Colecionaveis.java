package org.example.dominio;
public abstract class Colecionaveis {
    private int identificacao;
    private String titulo;
    private String dataAquisicao;

    public Colecionaveis(int identificacao,String titulo, int dia, int mes, int ano){
        this.identificacao = identificacao;
        this.titulo = titulo;
        this.dataAquisicao = dia + "/" + mes + "/" + ano;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public String getTitulo() {
        return titulo;
    }
}
