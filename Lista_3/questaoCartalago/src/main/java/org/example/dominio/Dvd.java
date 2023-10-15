package org.example.dominio;

public class Dvd extends Colecionaveis{
    private String tipo;

    public Dvd(int identificacao,String titulo, int dia, int mes, int ano, String tipo){
        super(identificacao, titulo, dia, mes, ano);
        this.tipo = tipo;
    }

   public String getTipo(){
       return tipo;
   }
}
