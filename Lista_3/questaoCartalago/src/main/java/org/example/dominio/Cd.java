package org.example.dominio;

public class Cd extends Colecionaveis{
    private String genero;

    public Cd(int identificacao, String titulo, int dia, int mes, int ano, String genero){
        super(identificacao,titulo,dia,mes,ano);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
