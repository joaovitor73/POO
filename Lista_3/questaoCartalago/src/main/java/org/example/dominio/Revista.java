package org.example.dominio;

public class Revista extends Colecionaveis{
    private int anoPubli;
    private String editora;
    private int volume;

    public Revista(int identificacao, String titulo, int dia, int mes, int ano, int anoPubli,String editora, int volume){
        super(identificacao, titulo, dia, mes, ano);
        this.anoPubli = anoPubli;
        this.editora = editora;
        this.volume = volume;
    }

    public int getAnoPubli(){
        return anoPubli;
    }

    public String getEditora() {
        return editora;
    }

    public int getVolume() {
        return volume;
    }
}
