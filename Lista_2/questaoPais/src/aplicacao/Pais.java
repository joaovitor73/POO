package aplicacao;

import java.util.ArrayList;

public class Pais {
    private String nome;
    private String capital;
    private Float dimersao;
    private ArrayList<String> paisComFronteira;

    public Pais() {
        this.nome = nome;
        this.capital = capital;
        this.paisComFronteira = new ArrayList<String>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Float getDimersao() {
        return dimersao;
    }

    public void setDimersao(Float dimersao) {
        this.dimersao = dimersao;
    }

    public ArrayList<String> getPaisComFronteira() {
        return paisComFronteira;
    }

    public void setPaisComFronteira(ArrayList<String> paisComFronteira) {
        this.paisComFronteira = paisComFronteira;
    }

    public boolean equals(Pais p){
        if((p.getNome().equals(this.nome) )&& (p.getCapital().equals(this.capital))) return true;
        return false;
    }

    public ArrayList<String> paisesComum(Pais p){
        ArrayList<String> paisComum  = new ArrayList<>();
        boolean flag;
        for (String pais : this.paisComFronteira){
            for(String paisExterno: p.paisComFronteira){
                if(paisExterno.equals(pais)){
                    flag = true;
                    for(String paisesComum: paisComum){
                        if(!paisesComum.equals(pais)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) paisComum.add(pais);
                    break;
                }
            }
        }
        return paisComum;
    }
}
